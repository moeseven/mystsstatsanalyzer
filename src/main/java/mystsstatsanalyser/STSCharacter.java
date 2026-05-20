package mystsstatsanalyser;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import csv_output.CardCount;
import csv_output.MonsterStrength;
import mystsstatsanalyser.jsonObjects.AncientChoice;
import mystsstatsanalyser.jsonObjects.Card;
import mystsstatsanalyser.jsonObjects.CardChoice;
import mystsstatsanalyser.jsonObjects.Deck;
import mystsstatsanalyser.jsonObjects.MapPointHistory;
import mystsstatsanalyser.jsonObjects.Relic;
import mystsstatsanalyser.jsonObjects.RunData;

public enum STSCharacter {
	IRONCLAD,
	SILENT,
	REGENT,
	NECROBINDER,
	DEFECT
	
	;
	
	public static final String skip = "CARD_REWARD_SKIP";
	
	private Map<AnalyzeList,List<RunData>> data_map = new HashMap<AnalyzeList,List<RunData>>();
	
	private HashMap<String, CardCount> pickwinsWithCard = new HashMap<String, CardCount>();
	private HashMap<String, CardCount> picklossesWithCard = new HashMap<String, CardCount>();
	private HashMap<String, CardCount> showsCard = new HashMap<String, CardCount>();

	
	private HashMap<String, Integer> pickwinsWithAncientBonus = new HashMap<String, Integer>();
	private HashMap<String, Integer> picklossesWithAncientBonus = new HashMap<String, Integer>();
	private HashMap<String, Integer> showsAncientBonus = new HashMap<String, Integer>();
	
	private HashMap<String, Integer> winsWithRelic = new HashMap<String, Integer>();
	private HashMap<String, Integer> lossesWithRelic = new HashMap<String, Integer>();
	private HashMap<String, Integer> showsRelic = new HashMap<String, Integer>();
	
	
	private HashMap<String,MonsterStat> monsters = new HashMap<String, MonsterStat>();
	
	private EloCalculator eloCalculator = new EloCalculator(this);
	private WinContributionCalculator winContributionCalc = new WinContributionCalculator(this);
	
	
	public CardChoice getCard_choice_skip() {
		return card_choice_skip;
	}

	private Card card_reward_skip;
	private CardChoice card_choice_skip;
	private STSCharacter() {
		card_reward_skip = new Card();
		card_reward_skip.setId(skip);
		card_choice_skip = new CardChoice();
		card_choice_skip.setCard(card_reward_skip);
	}

	public void generatePickRatesAncientBonus(String ancient,List<AncientChoice> ac, RunData runData) {
		for (Iterator iterator = ac.iterator(); iterator.hasNext();) {
			AncientChoice ancientChoice = (AncientChoice) iterator.next();
			String id = ancient + "." + ancientChoice.getTextKey();
			showsAncientBonus.merge(id, 1, Integer::sum);
			if (ancientChoice.getWasChosen()) {
				if (runData.getWin()) {
					pickwinsWithAncientBonus.merge(id, 1, Integer::sum);
				}else {
					picklossesWithAncientBonus.merge(id, 1, Integer::sum);
				}
			}
		}
	}
	

	
	public void generatePickData() {
		int act;
		List<RunData> d = getData_map().get(AnalyzeList.Runs);		
		for (Iterator iterator = d.iterator(); iterator.hasNext();) {
			RunData runData = (RunData) iterator.next();
			winContributionCalc.collectData(runData);
			generateRelicData(runData);
			act = 0;
			for (Iterator iteratorAct = runData.getMapPointHistory().iterator(); iteratorAct.hasNext();) {
				act++;
				List<MapPointHistory> actList = (List<MapPointHistory>) iteratorAct.next();
				for (Iterator iterator2 = actList.iterator(); iterator2.hasNext();) {
					MapPointHistory mph = (MapPointHistory) iterator2.next();
					String nodeType = mph.getMapPointType();
					if(!mph.getMapPointType().equals(NodeType.shop.toString())) {
						if (mph.getPlayerStats().getFirst().getCardChoices() != null) {
							boolean wasSkipped = eloCalculator.determinEloChange(mph.getPlayerStats().getFirst().getCardChoices());
							increaseCardCount(showsCard, card_reward_skip);
							if (wasSkipped) {
								if (runData.getWin()) {
									increaseCardCount(pickwinsWithCard, card_reward_skip);
								}else {
									increaseCardCount(picklossesWithCard, card_reward_skip);
								}
							}
							for (Iterator iterator3 = mph.getPlayerStats().getFirst().getCardChoices().iterator(); iterator3.hasNext();) {
								generateCardChoice(runData, iterator3);
							}
						}					
						if (nodeType.equals(NodeType.ancient.toString())) {
							if (mph.getPlayerStats().getFirst().getAncientChoice() != null) {							
								generatePickRatesAncientBonus(mph.getRooms().getFirst().getModelId(),mph.getPlayerStats().getFirst().getAncientChoice(),runData);
							}
						}
						if (nodeType.equals(NodeType.monster.toString()) || nodeType.equals(NodeType.elite.toString()) || nodeType.equals(NodeType.boss.toString())) {
							String monster = mph.getRooms().getFirst().getModelId();
							int damage_taken = mph.getPlayerStats().getFirst().getDamageTaken();
							int turns = mph.getRooms().getFirst().getTurnsTaken();
							boolean won = mph.getPlayerStats().getFirst().getCurrentHp() > 0;
							if (!monsters.containsKey(monster)) {
								String actString = runData.getActs().get(act-1);
								monsters.put(monster, new MonsterStat(actString,act,nodeType));
							}
							monsters.get(monster).merge(damage_taken, turns, won);
						}
					}
				}
			}		
		}
	}
	
	

	private void generateRelicData(RunData runData) {
		for (Iterator iterator = runData.getPlayers().getFirst().getRelics().iterator(); iterator.hasNext();) {
			Relic relic = (Relic) iterator.next();
			if (runData.getWin()) {
				winsWithRelic.merge(relic.getId(), 1, Integer::sum);
			}else {
				lossesWithRelic.merge(relic.getId(), 1, Integer::sum);
			}
			showsRelic.merge(relic.getId(), 1, Integer::sum);
		}
		
	}

	private void increaseCardCount(HashMap<String, CardCount> map, Card card) {
		boolean upgraded = false;
		if (card.getCurrentUpgradeLevel() != null && card.getCurrentUpgradeLevel() == 1) {
			upgraded = true;
		}
		if (!map.containsKey(card.getId())) {
			map.put(card.getId(), new CardCount(0));
		}
		map.get(card.getId()).increment(upgraded);
	}

	public void generateCardChoice(RunData runData, Iterator iterator) {
		CardChoice card_choice = (CardChoice) iterator.next();
		Card card = card_choice.getCard();	
		increaseCardCount(showsCard, card);
		if (card_choice.getWasPicked()) {
			if (runData.getWin()) {
				increaseCardCount(pickwinsWithCard, card);
			}else {
				increaseCardCount(picklossesWithCard, card);
			}
		}
	}

	public Map<AnalyzeList, List<RunData>> getData_map() {
		return data_map;
	}
	
	

	
	
	public HashMap<String, CardCount> getPickwinsWithCard() {
		return pickwinsWithCard;
	}

	public HashMap<String, CardCount> getPicklossesWithCard() {
		return picklossesWithCard;
	}

	public HashMap<String, CardCount> getShowsCard() {
		return showsCard;
	}

	public String getExtendedString() {
		return "CHARACTER."+super.toString();
	}

	public HashMap<String, Integer> getPickwinsWithAncientBonus() {
		return pickwinsWithAncientBonus;
	}

	public HashMap<String, Integer> getPicklossesWithAncientBonus() {
		return picklossesWithAncientBonus;
	}

	public HashMap<String, Integer> getShowsAncientBonus() {
		return showsAncientBonus;
	}

	public HashMap<String, MonsterStat> getMonsters() {
		return monsters;
	}

	public EloCalculator getEloCalculator() {
		return eloCalculator;
	}

	public HashMap<String, Integer> getWinsWithRelic() {
		return winsWithRelic;
	}

	public HashMap<String, Integer> getLossesWithRelic() {
		return lossesWithRelic;
	}

	public HashMap<String, Integer> getShowsRelic() {
		return showsRelic;
	}

	public WinContributionCalculator getWinContributionCalc() {
		return winContributionCalc;
	}



	
	
	
}

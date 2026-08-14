package mystsstatsanalyser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import csv_output.CardCount;
import mystsstatsanalyser.jsonObjects.AncientChoice;
import mystsstatsanalyser.jsonObjects.CardChoice;

public class EloCalculator {

	public static final int start_elo = 1000;
	private final int elo_change_factor = 32;
	
	private HashMap<String, CardCount> cardElo = new HashMap<String, CardCount>();
	private HashMap<String, Integer> ancientElo = new HashMap<String, Integer>();
	
	private STSCharacter stsc;
	
	public EloCalculator(STSCharacter s) {
		super();
		stsc = s;
	}
	
	public void determinEloChangeAncientBonus(List<AncientChoice> choices) {
		String picked = STSCharacter.skip;
		List<AncientChoice> pickedFirstChoiceList = new LinkedList<AncientChoice>();
		for (Iterator iterator = choices.iterator(); iterator.hasNext();) {
			AncientChoice ancientChoice = (AncientChoice) iterator.next();
			if (ancientChoice.getWasChosen()) {
				picked = ancientChoice.getTextKey();
				pickedFirstChoiceList.addFirst(ancientChoice);
			}else {
				pickedFirstChoiceList.add(ancientChoice);
			}
		}

		adjustEloAncientBonus(pickedFirstChoiceList);
	}
	
	private void adjustEloAncientBonus(List<AncientChoice> options) {
		List<Integer> elos = new LinkedList<Integer>();
		for (Iterator iterator = options.iterator(); iterator.hasNext();) {
			AncientChoice ancientChoice = (AncientChoice) iterator.next();
			String id = ancientChoice.getTextKey();
			if (ancientElo.containsKey(id)) {
				elos.add(ancientElo.get(id));
			}else {
				elos.add(start_elo);
			}
		}
		LinkedList<Integer> eloChange = calcEloChange(elos);
		for (int i = 0; i < options.size(); i++) {
			addAncientChoiceElo(options.get(i),eloChange.get(i));
		}
	}
	
	private void addAncientChoiceElo(AncientChoice ancientChoice, int mod) {
		if (!ancientElo.containsKey(ancientChoice.getTextKey())) {
			ancientElo.put(ancientChoice.getTextKey(), start_elo);
		}		
		ancientElo.put(ancientChoice.getTextKey(), modifyEloFloorOne(mod, ancientElo.get(ancientChoice.getTextKey())));
	}

	public boolean determinEloChange(List<CardChoice> choices) {
		String picked = STSCharacter.skip;
		List<CardChoice> pickedFirstChoiceList = new LinkedList<CardChoice>();
		for (Iterator iterator = choices.iterator(); iterator.hasNext();) {
			CardChoice card = (CardChoice) iterator.next();
			if (card.getWasPicked()) {
				picked = card.getCard().getId();
				pickedFirstChoiceList.addFirst(card);
			}else {
				pickedFirstChoiceList.add(card);
			}
		}
		if (picked == STSCharacter.skip) {
			pickedFirstChoiceList.addFirst(stsc.getCard_choice_skip());
		}else {
			pickedFirstChoiceList.add(stsc.getCard_choice_skip());
		}	
		adjustElo(pickedFirstChoiceList);
		return picked.equals(STSCharacter.skip);
	}

	private void adjustElo(List<CardChoice> options) {
		List<Integer> elos = new LinkedList<Integer>();
		for (Iterator iterator = options.iterator(); iterator.hasNext();) {
			CardChoice card = (CardChoice) iterator.next();
			String card_id = card.getCard().getId();
			if (cardElo.containsKey(card_id)) {
				elos.add(cardElo.get(card_id).getBasic());
			}else {
				elos.add(start_elo);
			}
		}
		LinkedList<Integer> eloChange = calcEloChange(elos);
		for (int i = 0; i < options.size(); i++) {
			addElo(options.get(i),eloChange.get(i));
		}
	}

	private void addElo(CardChoice card, int i) {
		if (!cardElo.containsKey(card.getCard().getId())) {
			cardElo.put(card.getCard().getId(), new CardCount(start_elo));
		}
		cardElo.get(card.getCard().getId()).modifyFloorOne(i, isUpgraded(card));
	}

	private boolean isUpgraded(CardChoice card) {
		return card.getCard().getCurrentUpgradeLevel() != null && card.getCard().getCurrentUpgradeLevel() > 0;
	}

	
	public int getElo(String card, boolean upgraded) {
		if (!cardElo.containsKey(card)) {
			return start_elo;
		}
		return upgraded ? cardElo.get(card).getUpgraded() : cardElo.get(card).getBasic();
	}
	
	
	
	private LinkedList<Integer> calcEloChange(List<Integer> elos) {
		int winElo = elos.getFirst();
		int totalElo = 0;
		for (Iterator iterator = elos.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			totalElo += integer;
		}
		double expectation = 1.0*winElo/totalElo;
		double difference = 1-expectation;
		int winEloGain = (int) (difference * elo_change_factor);
		LinkedList<Integer> retVal = new LinkedList<Integer>();
		for (int i = 0; i < elos.size(); i++) {
			int elo_old = elos.get(i);
			if (i == 0) {
				retVal.add(winEloGain);
			}else {
				int eloLoss = (int) (1.0 * elo_old / (totalElo - winElo) * winEloGain);
				retVal.add(-eloLoss);
			}			
		}		
		return retVal;
	}
	

	public int getAncientElo(String ancient) {
		if (!ancientElo.containsKey(ancient)) {
			return start_elo;
		}
		return ancientElo.get(ancient);
	}
	
	public static int modifyEloFloorOne(int mod, int old_value) {
			return (old_value + mod <= 0) ? 1 : old_value + mod;
	}
}

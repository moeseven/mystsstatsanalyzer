package app;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import csv_output.AncientChoiceStats;
import csv_output.BaseSTSStats;
import csv_output.CardCount;
import csv_output.CardStatStats;
import csv_output.CharacterCollectedStats;
import csv_output.CsvWriter;
import csv_output.MonsterStrength;
import csv_output.RelicStats;
import csv_output.RunDataStats;
import dboutput.AncientDao;
import dboutput.CardsDao;
import dboutput.CharacterDao;
import dboutput.MonsterDao;
import dboutput.RelicDao;
import dboutput.RunDao;
import mystsstatsanalyser.MonsterStat;
import mystsstatsanalyser.RunAnaylser;
import mystsstatsanalyser.RunReader;
import mystsstatsanalyser.STSCharacter;
import mystsstatsanalyser.jsonObjects.MapPointHistory;
import mystsstatsanalyser.jsonObjects.RunData;

public class App {
	
	public static final Path folder = Path.of("D:","game_related","Streaming","slaythespire");
	public static final Path outputFolder = Path.of("C:","Users","moritz.schick","eclipse-workspace","myrepos","mystsstatsanalyzer","resources","output");
	
	private static final Path testPath = Path.of("C:","Users","moritz.schick","eclipse-workspace","myrepos","mystsstatsanalyzer","resources","history");
	private static final Path runHistoryFilePath = Path.of("C:","Users","Moritz","AppData","Roaming","SlayTheSpire2","steam","76561198070959178","profile1","saves","history");
	
	private static final String overgrowth = "ACT.OVERGROWTH";
	private static final String underdocks = "ACT.UNDERDOCKS";

	public static void main(String[] args) {
		
		int version = 1;
		
		RunAnaylser analyzer = new RunAnaylser(runHistoryFilePath);
		
		List<BaseSTSStats> list_runs = new ArrayList<BaseSTSStats>();
		int count = 0;
		for (Iterator iterator = analyzer.getData().iterator(); iterator.hasNext();) {
			RunData data = (RunData) iterator.next();
			int floors = analyzer.getFloorReached(data);
			list_runs.add(new RunDataStats(count, data.getPlayers().getFirst().getCharacter(), data.getWin(),floors, data.getWin() ? "Architect":(data.getKilledByEncounter() != null ? data.getKilledByEncounter() : "?"),data.getActs().get(0),data.getActs().get(1),data.getActs().get(2)));
			count++;
		}

		List<BaseSTSStats> list_cards = new ArrayList<BaseSTSStats>();
		List<BaseSTSStats> list_ancient_choices = new ArrayList<BaseSTSStats>();
		List<BaseSTSStats> list_relics = new ArrayList<BaseSTSStats>();
		List<BaseSTSStats> list_collected_stats = new ArrayList<BaseSTSStats>();
		List<BaseSTSStats> list_monsters = new ArrayList<BaseSTSStats>();
		
		for (STSCharacter c : STSCharacter.values()) {
			for (String card : c.getWinContributionCalc().getAllCards()) {
				list_cards.add(new CardStatStats(c.toString()
						,c.getWinrate()
						, card
						, analyzer.getWinrate(card,false, c)
						, analyzer.getPickrate(card,false, c)
						,c.getEloCalculator().getElo(card, false)
						,c.getWinContributionCalc().getCardWinContributions().get(card).getBasicRelatedToAvarage()
						));
				if (card != c.skip) {
					list_cards.add(new CardStatStats(c.toString()
							,c.getWinrate()
							,card + "+"
							,analyzer.getWinrate(card,true, c)
							, analyzer.getPickrate(card,true, c)
							,c.getEloCalculator().getElo(card, true)
							,c.getWinContributionCalc().getCardWinContributions().get(card).getUpgradedRelatedToAvarage()));
				}
				
			}
			for (Map.Entry<String, Integer> entry : c.getShowsAncientBonus().entrySet()) {
				double winContribution = 0;
				String pureRelicName = entry.getKey().substring(entry.getKey().lastIndexOf('.') + 1);
				String relicName = "RELIC." + entry.getKey().substring(entry.getKey().lastIndexOf('.') + 1);
				if (c.getWinContributionCalc().getRelicWinContributions().containsKey(relicName)) {
					winContribution = c.getWinContributionCalc().getRelicWinContributions().get(relicName).getContributionDeviation();
				}				
				list_ancient_choices.add(new AncientChoiceStats(c.toString(), entry.getKey(), analyzer.getWinrateAncientBonus(entry.getKey(), c), analyzer.getPickrateAncientBonus(entry.getKey(), c),winContribution,c.getEloCalculator().getAncientElo(pureRelicName)));
			}
			for (Map.Entry<String, Integer> entry : c.getShowsRelic().entrySet()) {
				list_relics.add(new RelicStats(c.toString(),entry.getKey(),analyzer.getWinrateRelic(entry.getKey(), c),c.getWinContributionCalc().getRelicWinContributions().get(entry.getKey()).getContributionDeviation()));
			}

			list_collected_stats.add(new CharacterCollectedStats(c.toString(), analyzer.getAvgFloorReached(c), c.getWinrate(),analyzer.getAvgFloorReached(c, underdocks),analyzer.getWinrate(c, underdocks),analyzer.getAvgFloorReached(c, overgrowth),analyzer.getWinrate(c, overgrowth)));
			for (Map.Entry<String, MonsterStat> monster : c.getMonsters().entrySet()) {
				double records = monster.getValue().getRecords();
				if (records > 0) {
					list_monsters.add(new MonsterStrength(c.toString(), monster.getKey(),monster.getValue().getType(),monster.getValue().getAct(),monster.getValue().getAct_number(), monster.getValue().getDamage()/records, monster.getValue().getTurns()/records, monster.getValue().getKills()/records));
				}				
			}
			
		}
		
//		CsvWriter csvWriter = new CsvWriter(folder);
//		
//		try {
//			csvWriter.writeStats("monster_stats_" + version, list_monsters);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			csvWriter.writeStats("card_stats_" + version, list_cards);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			csvWriter.writeStats("run_stats_"+ version, list_runs);
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//
//		try {
//			csvWriter.writeStats("ancient_stats_"+ version, list_ancient_choices);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			csvWriter.writeStats("relic_stats_"+ version, list_relics);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			csvWriter.writeStats("character_stats_"+ version, list_collected_stats);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		//////////DB Export//////////
		RunDao.deleteAllEntries();
		RunDao.insertMultipleRows(list_runs);
		
		CardsDao cardsDao = new CardsDao();
		cardsDao.deleteAllEntries();
		cardsDao.insertMultipleRows(list_cards);
		
		MonsterDao monsterDao = new MonsterDao();
		monsterDao.deleteAllEntries();
		monsterDao.insertMultipleRows(list_monsters);
		
		RelicDao relicDao = new RelicDao();
		relicDao.deleteAllEntries();
		relicDao.insertMultipleRows(list_relics);
		
		AncientDao ancientDao = new AncientDao();
		ancientDao.deleteAllEntries();
		ancientDao.insertMultipleRows(list_ancient_choices);
		
		CharacterDao charDao = new CharacterDao();
		charDao.deleteAllEntries();
		charDao.insertMultipleRows(list_collected_stats);
		///////////////////////
		
		System.out.println("data exported");
	}



}

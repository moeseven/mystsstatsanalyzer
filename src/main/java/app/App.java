package app;

import java.io.IOException;
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
import csv_output.RunDataStats;
import mystsstatsanalyser.MonsterStat;
import mystsstatsanalyser.RunAnaylser;
import mystsstatsanalyser.RunReader;
import mystsstatsanalyser.STSCharacter;
import mystsstatsanalyser.jsonObjects.MapPointHistory;
import mystsstatsanalyser.jsonObjects.RunData;

public class App {
	
	private static final String overgrowth = "ACT.OVERGROWTH";
	private static final String underdocks = "ACT.UNDERDOCKS";

	public static void main(String[] args) {
		
		int version = 1;
		
		RunAnaylser analyzer = new RunAnaylser();
		
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
		List<BaseSTSStats> list_collected_stats = new ArrayList<BaseSTSStats>();
		List<BaseSTSStats> list_monsters = new ArrayList<BaseSTSStats>();
		
		for (STSCharacter c : STSCharacter.values()) {
			for (Map.Entry<String, CardCount> entry : c.getShowsCard().entrySet()) {
				list_cards.add(new CardStatStats(c.toString(), entry.getKey(), analyzer.getWinrate(entry.getKey(),false, c), analyzer.getPickrate(entry.getKey(),false, c), analyzer.getWinrate(entry.getKey(),true, c), analyzer.getPickrate(entry.getKey(),true, c)));
			}
			for (Map.Entry<String, Integer> entry : c.getShowsAncientBonus().entrySet()) {
				list_ancient_choices.add(new AncientChoiceStats(c.toString(), entry.getKey(), analyzer.getWinrateAncientBonus(entry.getKey(), c), analyzer.getPickrateAncientBonus(entry.getKey(), c)));
			}

			list_collected_stats.add(new CharacterCollectedStats(c.toString(), analyzer.getAvgFloorReached(c), analyzer.getWinrate(c),analyzer.getAvgFloorReached(c, underdocks),analyzer.getWinrate(c, underdocks),analyzer.getAvgFloorReached(c, overgrowth),analyzer.getWinrate(c, overgrowth)));
			for (Map.Entry<String, MonsterStat> monster : c.getMonsters().entrySet()) {
				double records = monster.getValue().getRecords();
				if (records > 0) {
					list_monsters.add(new MonsterStrength(c.toString(), monster.getKey(),monster.getValue().getType(),monster.getValue().getAct(),monster.getValue().getAct_number(), monster.getValue().getDamage()/records, monster.getValue().getTurns()/records, monster.getValue().getWins()/records));
				}				
			}
			
		}
		
		
		try {
			CsvWriter.writeStats("monster_stats_" + version, list_monsters);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			CsvWriter.writeStats("card_stats_" + version, list_cards);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			CsvWriter.writeStats("run_stats_"+ version, list_runs);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			CsvWriter.writeStats("ancient_stats_"+ version, list_ancient_choices);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			CsvWriter.writeStats("character_stats_"+ version, list_collected_stats);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("data exported");
	}



}

package mystsstatsanalyser;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

import mystsstatsanalyser.jsonObjects.MapPointHistory;
import mystsstatsanalyser.jsonObjects.RunData;
import tools.STSAnalyserUtils;

public class RunAnaylser {

	private List<RunData> data;
	
	private static String game_mode_standard = "standard";
	


	private Path sourcePath;
	
	public List<RunData> getData() {
		return data;
	}


	public RunAnaylser(Path sourcePath) {
		super();
		this.sourcePath = sourcePath;
		RunReader reader = new RunReader(this.sourcePath);		
		List<RunData> runDataList = reader.readAllData();
		System.out.println(runDataList.size());
		runDataList = runDataList.stream()
				.filter(element -> element.getAscension() == 10)
				.filter(element -> !element.getWasAbandoned())
				.filter(element -> element.getGameMode().equals(game_mode_standard)).toList();
		data = runDataList.stream().filter(e -> e.getPlayers().size() == 1).toList();
		System.out.println(runDataList.size());
		
		for (STSCharacter c : STSCharacter.values()) {
			generateLists(c);
			c.generatePickData();
		}
	}
	
	
	private void generateLists(STSCharacter character) {
		List<RunData> characterData = getCharacterStats(character);
		character.getData_map().put(AnalyzeList.Runs, characterData);
		character.getData_map().put(AnalyzeList.WINS, characterData.stream().filter(e -> e.getWin()).toList());
		character.getData_map().put(AnalyzeList.LOSSES, characterData.stream().filter(e -> !e.getWin()).toList());
	}


	public List<RunData> getCharacterStats(STSCharacter character) {
		return data.stream().filter(e -> e.getPlayers().getFirst().getCharacter().equals(character.getExtendedString())).toList();
	}
	
	private double calcTruncatedRate(int wins, int losses) {
		double retVal = 0;
		if (losses >= 0 && wins >= 0 && wins+losses > 0) {
			retVal = 1.0 * wins / (wins + losses);
		}
		return STSAnalyserUtils.truncateToTwoDecimals(retVal);
	}


	
	public double getWinrateAncientBonus(String ancient, STSCharacter character) {
		int losses = character.getPicklossesWithAncientBonus().containsKey(ancient) ? character.getPicklossesWithAncientBonus().get(ancient) : 0;
		int wins = character.getPickwinsWithAncientBonus().containsKey(ancient) ? character.getPickwinsWithAncientBonus().get(ancient) : 0;
		return calcTruncatedRate(wins, losses);
	}
	
	public double getWinrate(String card,boolean upgraded, STSCharacter character) {
		int losses = character.getPicklossesWithCard().containsKey(card) ? character.getPicklossesWithCard().get(card).getCount(upgraded) : 0;
		int wins = character.getPickwinsWithCard().containsKey(card) ? character.getPickwinsWithCard().get(card).getCount(upgraded) : 0;
		return calcTruncatedRate(wins, losses);
	}
	
	public double getPickrate(String card,boolean upgraded, STSCharacter character) {
		int losses = character.getPicklossesWithCard().containsKey(card) ? character.getPicklossesWithCard().get(card).getCount(upgraded) : 0;
		int wins = character.getPickwinsWithCard().containsKey(card) ? character.getPickwinsWithCard().get(card).getCount(upgraded) : 0;
		int shows = character.getShowsCard().containsKey(card) ? character.getShowsCard().get(card).getCount(upgraded) : 0;
		return calcTruncatedRate(wins+losses, shows);
	}
	
	public double getWinrate(STSCharacter character) {
		int losses = character.getData_map().get(AnalyzeList.LOSSES).size();
		int wins = character.getData_map().get(AnalyzeList.WINS).size();
		return calcTruncatedRate(wins, losses);
	}
	
	public double getWinrate(STSCharacter character, String act) {
		int losses = 0;
		for (Iterator iterator = character.getData_map().get(AnalyzeList.LOSSES).iterator(); iterator.hasNext();) {
			RunData runData = (RunData) iterator.next();
			if (containsAct(runData,act)) {
				losses++;
			}
		}
		int wins = 0;
		for (Iterator iterator = character.getData_map().get(AnalyzeList.WINS).iterator(); iterator.hasNext();) {
			RunData runData = (RunData) iterator.next();
			if (containsAct(runData,act)) {
				wins++;
			}
		}
		return calcTruncatedRate(wins, losses);
	}
	
	public double getAvgFloorReached(STSCharacter character, String act) {
		List<RunData> data_list = character.getData_map().get(AnalyzeList.Runs);
		int floor = 0;
		for (Iterator iterator = data_list.iterator(); iterator.hasNext();) {
			RunData runData = (RunData) iterator.next();
			if (containsAct(runData,act)) {
				floor += getFloorReached(runData);
			}			
		}
		return STSAnalyserUtils.truncateToTwoDecimals(1.0 * floor / data_list.size());
	}


	public boolean containsAct(RunData runData, String act) {
		for (Iterator iterator2 = runData.getActs().iterator(); iterator2.hasNext();) {
			String act_part = (String) iterator2.next();
			if (act_part.equals(act)) {
				return true;
			}
		}
		return false;
	}
	
	public String getActString(RunData runData, int index) {
		return runData.getActs().get(index);
	}
	
	public double getAvgFloorReached(STSCharacter character) {
		List<RunData> data_list = character.getData_map().get(AnalyzeList.Runs);
		int floor = 0;
		for (Iterator iterator = data_list.iterator(); iterator.hasNext();) {
			RunData runData = (RunData) iterator.next();
			floor += getFloorReached(runData);
		}
		return STSAnalyserUtils.truncateToTwoDecimals(1.0 * floor / data_list.size());
	}
	
	public static int getFloorReached(RunData data) {
		int floors = 0;
		for (Iterator iterator2 = data.getMapPointHistory().iterator(); iterator2.hasNext();) {
			List<MapPointHistory> acts = (List<MapPointHistory>) iterator2.next();
			for (Iterator iterator3 = acts.iterator(); iterator3.hasNext();) {
				MapPointHistory hist = (MapPointHistory) iterator3.next();
				floors++;
			}
		}
		if (data.getWin()) {
			floors++;
		}
		return floors;
	}


	public double getPickrateAncientBonus(String ancient, STSCharacter character) {
		int losses = character.getPicklossesWithAncientBonus().containsKey(ancient) ? character.getPicklossesWithAncientBonus().get(ancient) : 0;
		int wins = character.getPickwinsWithAncientBonus().containsKey(ancient) ? character.getPickwinsWithAncientBonus().get(ancient) : 0;
		int shows = character.getShowsAncientBonus().containsKey(ancient) ? character.getShowsAncientBonus().get(ancient) : 0;
		return calcTruncatedRate(wins+losses, shows);
	}
}

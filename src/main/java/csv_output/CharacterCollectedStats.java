package csv_output;

public class CharacterCollectedStats extends BaseSTSStats {
	
	
	
	public String getCharacter() {
		return character;
	}

	public double getFloor_reached_avg() {
		return floor_reached_avg;
	}

	public double getWinRate() {
		return winRate;
	}

	public double getFloor_reached_start_underdocks() {
		return floor_reached_start_underdocks;
	}

	public double getWinRate_underdocks() {
		return winRate_underdocks;
	}

	public double getFloor_reached_start_overgrowth() {
		return floor_reached_start_overgrowth;
	}

	public double getWinRate_owergrowth() {
		return winRate_owergrowth;
	}

	private String character;
	private double floor_reached_avg;
	private double winRate;
	private double floor_reached_start_underdocks;
	private double winRate_underdocks;
	private double floor_reached_start_overgrowth;
	private double winRate_owergrowth;


	public CharacterCollectedStats(String character, double floor_reached_avg, double winRate,
			double floor_reached_start_underdocks, double winRate_underdocks, double floor_reached_start_overgrowth,
			double winRate_owergrowth) {
		super();
		this.character = character;
		this.floor_reached_avg = floor_reached_avg;
		this.winRate = winRate;
		this.floor_reached_start_underdocks = floor_reached_start_underdocks;
		this.winRate_underdocks = winRate_underdocks;
		this.floor_reached_start_overgrowth = floor_reached_start_overgrowth;
		this.winRate_owergrowth = winRate_owergrowth;
	}

	@Override
	public String headerRow() {
		return String.join(CsvWriter.seperator,"character","avg floor reached", "win rate", "underdocks floor", "underdocks win rate", "overgrowth floor", "overgrowth win rate");
	}

	@Override
	public String printRow() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +CsvWriter.seperator  + floor_reached_avg
                +CsvWriter.seperator  + winRate
                +CsvWriter.seperator  + floor_reached_start_underdocks
                +CsvWriter.seperator  + winRate_underdocks
                +CsvWriter.seperator  + floor_reached_start_overgrowth
                +CsvWriter.seperator  + winRate_owergrowth
                ;
	}

}

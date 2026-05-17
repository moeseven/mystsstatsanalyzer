package csv_output;

public class CharacterCollectedStats extends BaseSTSStats {
	
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
		return "character,avg floor reached, win rate, underdocks floor, underdocks win rate, overgrowth floor, overgrowth win rate";
	}

	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +"," + floor_reached_avg
                +"," + winRate
                +"," + floor_reached_start_underdocks
                +"," + winRate_underdocks
                +"," + floor_reached_start_overgrowth
                +"," + winRate_owergrowth
                ;
	}

}

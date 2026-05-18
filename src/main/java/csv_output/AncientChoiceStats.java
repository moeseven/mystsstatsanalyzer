package csv_output;

public class AncientChoiceStats extends BaseSTSStats{
		
	private final String character;
	private final String ancient;
	private final String ancient_bonus;
	private final double win_rate;
	private final double pick_rate;

	

	
	public AncientChoiceStats(String character, String ancient_bonus, double win_rate, double pick_rate) {
		super();
		this.character = character;
		String[] parts = ancient_bonus.split("\\.");
		this.ancient = parts[1];
		this.ancient_bonus = parts[2];
		this.win_rate = win_rate;
		this.pick_rate = pick_rate;
	}



	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
				+"," + ancient
                +"," + ancient_bonus
                +"," + win_rate
                +"," + pick_rate
                ;
	}
	
	
	
	public String headerRow() {
		return "character, ancient,ancient_bonus,winrate,pickrate";
	}
	
}


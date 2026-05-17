package csv_output;

public class AncientChoiceStats extends BaseSTSStats{
		
	private final String character;
	private final String ancient_bonus;
	private final double win_rate;
	private final double pick_rate;

	

	
	public AncientChoiceStats(String character, String ancient_bonus, double win_rate, double pick_rate) {
		super();
		this.character = character;
		this.ancient_bonus = ancient_bonus;
		this.win_rate = win_rate;
		this.pick_rate = pick_rate;
	}



	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +"," + ancient_bonus.substring(ancient_bonus.indexOf('.') + 1)
                +"," + win_rate
                +"," + pick_rate
                ;
	}
	
	
	
	public String headerRow() {
		return "character,ancient_bonus,winrate,pickrate";
	}
	
}


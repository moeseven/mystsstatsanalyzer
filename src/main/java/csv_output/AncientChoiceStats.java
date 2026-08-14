package csv_output;

public class AncientChoiceStats extends BaseSTSStats{
	
	
	
		
	public int getPick_elo() {
		return pick_elo;
	}



	public String getCharacter() {
		return character;
	}



	public String getAncient() {
		return ancient;
	}



	public String getAncient_bonus() {
		return ancient_bonus;
	}



	public double getWin_rate() {
		return win_rate;
	}



	public double getPick_rate() {
		return pick_rate;
	}



	public double getWin_contribution() {
		return win_contribution;
	}



	private final String character;
	private final String ancient;
	private final String ancient_bonus;
	private final double win_rate;
	private final double pick_rate;
	private final double win_contribution;
	private final int pick_elo;

	

	
	public AncientChoiceStats(String character, String ancient_bonus, double win_rate, double pick_rate, double win_contribution,int pick_elo) {
		super();
		this.character = character;
		String[] parts = ancient_bonus.split("\\.");
		this.ancient = parts[1];
		this.ancient_bonus = parts[2];
		this.win_rate = win_rate;
		this.pick_rate = pick_rate;
		this.win_contribution = win_contribution;
		this.pick_elo = pick_elo;
	}



	@Override
	public String printRow() {
		return 	character.substring(character.lastIndexOf('.') + 1)
				+CsvWriter.seperator  + ancient
                +CsvWriter.seperator  + ancient_bonus
                +CsvWriter.seperator  + win_rate
                +CsvWriter.seperator  + pick_rate
                +CsvWriter.seperator  + win_contribution
                +CsvWriter.seperator  + pick_elo
                ;
	}
	
	
	
	public String headerRow() {
		return String.join(CsvWriter.seperator, "character", "ancient","ancient_bonus","winrate,pickrate,wincontribution,pickelo");
	}
	
}


package csv_output;

public class RelicStats extends BaseSTSStats{
	
	
		
	public double getWin_contribution() {
		return win_contribution;
	}



	public String getCharacter() {
		return character;
	}



	public String getName() {
		return name;
	}



	public double getWin_rate() {
		return win_rate;
	}



	private final String character;
	private final String name;
	private final double win_rate;
	private final double win_contribution;


	



	public RelicStats(String character, String name, double win_rate, double win_contribution) {
		super();
		this.character = character;
		this.name = name.substring(name.lastIndexOf('.') + 1);
		this.win_rate = win_rate;
		this.win_contribution = win_contribution;
	}



	@Override
	public String printRow() {
		return 	character.substring(character.lastIndexOf('.') + 1)
				+CsvWriter.seperator  + name
				+CsvWriter.seperator  + win_rate
				+CsvWriter.seperator  + win_contribution
                ;
	}
	
	
	
	public String headerRow() {
		return String.join(CsvWriter.seperator, "character", "relic" ,"winrate","wincontribution");
	}
	
}


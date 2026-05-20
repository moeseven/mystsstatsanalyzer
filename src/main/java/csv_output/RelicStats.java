package csv_output;

public class RelicStats extends BaseSTSStats{
		
	private final String character;
	private final String name;
	private final double win_rate;


	public RelicStats(String character, String name, double win_rate) {
		super();
		this.character = character;
		this.name = name;
		this.win_rate = win_rate;
	}



	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
				+"," + name.substring(name.lastIndexOf('.') + 1)
                +"," + win_rate
                ;
	}
	
	
	
	public String headerRow() {
		return "character, relic ,winrate";
	}
	
}


package csv_output;

public class RunDataStats extends BaseSTSStats{
	
	
	
	
	public int getRun_id() {
		return run_id;
	}

	public String getCharacter() {
		return character;
	}

	public boolean isWon() {
		return won;
	}

	public int getFloor_reached() {
		return floor_reached;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public String getAct1() {
		return act1;
	}

	public String getAct2() {
		return act2;
	}

	public String getAct3() {
		return act3;
	}

	private final int run_id;
	private final String character;
	private final boolean won;
	private final int floor_reached;
	private final String deathCause;
	private final String act1;
	private final String act2;
	private final String act3;

	

	
	public RunDataStats(int run_id, String character, boolean won, int floor_reached, String deathCause, String act1,
			String act2, String act3) {
		super();
		this.run_id = run_id;
		this.character = character.substring(character.lastIndexOf('.') + 1);
		this.won = won;
		this.floor_reached = floor_reached;
		this.deathCause = deathCause;
		this.act1 = act1;
		this.act2 = act2;
		this.act3 = act3;
	}

	@Override
	public String printRow() {
		return 	run_id
				+CsvWriter.seperator + character
                +CsvWriter.seperator + (won ? 1:0)
                +CsvWriter.seperator + floor_reached
                +CsvWriter.seperator + deathCause
                +CsvWriter.seperator + act1
                +CsvWriter.seperator + act2
                +CsvWriter.seperator + act3
                ;
	}
	
	public String headerRow() {
		return String.join(CsvWriter.seperator, "run id","character","won","floor reached","death cause", "act1", "act2", "act3");
	}

}

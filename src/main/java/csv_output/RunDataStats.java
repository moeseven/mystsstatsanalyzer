package csv_output;

public class RunDataStats extends BaseSTSStats{
	
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
		this.character = character;
		this.won = won;
		this.floor_reached = floor_reached;
		this.deathCause = deathCause;
		this.act1 = act1;
		this.act2 = act2;
		this.act3 = act3;
	}

	@Override
	public String toString() {
		return 	run_id
				+"," + character.substring(character.lastIndexOf('.') + 1)
                +"," + (won ? 1:0)
                +"," + floor_reached
                +"," + deathCause
                +"," + act1
                +"," + act2
                +"," + act3
                ;
	}
	
	public String headerRow() {
		return "run id,character,won,floor reached,death cause, act1, act2, act3";
	}

}

package csv_output;

public class CardStatStats extends BaseSTSStats{
		
	private final String character;
	private final String card;
	private final double win_rate_picked;
	private final double pick_rate;
	private final int pick_elo;
	private final double win_rate_picked_upgraded;
	private final double pick_rate_upgraded;
	private final int pick_elo_upgraded;
	
	





	public CardStatStats(String character, String card, double win_rate_picked, double pick_rate, int pick_elo,
			double win_rate_picked_upgraded, double pick_rate_upgraded, int pick_elo_upgraded) {
		super();
		this.character = character;
		this.card = card;
		this.win_rate_picked = win_rate_picked;
		this.pick_rate = pick_rate;
		this.pick_elo = pick_elo;
		this.win_rate_picked_upgraded = win_rate_picked_upgraded;
		this.pick_rate_upgraded = pick_rate_upgraded;
		this.pick_elo_upgraded = pick_elo_upgraded;
	}



	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +"," + card.substring(card.lastIndexOf('.') + 1)
                +"," + win_rate_picked
                +"," + pick_rate
                +"," + (pick_elo)
                +"," + win_rate_picked_upgraded
                +"," + pick_rate_upgraded
                +"," + (pick_elo_upgraded)
                ;
	}
	
	
	
	public String headerRow() {
		return "character,card,winrate,pickrate, pick elo,wr_upgraded,pr_upgraded, pick elo upgraded";
	}
	
}


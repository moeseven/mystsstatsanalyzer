package csv_output;

public class CardStatStats extends BaseSTSStats{
		
	private final String character;
	private final String card;
	private final double win_rate;
	private final double pick_rate;
	private final double win_rate_upgraded;
	private final double pick_rate_upgraded;


	
	
	



	public CardStatStats(String character, String card, double win_rate, double pick_rate, double win_rate_upgraded,
			double pick_rate_upgraded) {
		super();
		this.character = character;
		this.card = card;
		this.win_rate = win_rate;
		this.pick_rate = pick_rate;
		this.win_rate_upgraded = win_rate_upgraded;
		this.pick_rate_upgraded = pick_rate_upgraded;
	}



	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +"," + card.substring(card.lastIndexOf('.') + 1)
                +"," + win_rate
                +"," + pick_rate
                +"," + win_rate_upgraded
                +"," + pick_rate_upgraded
                ;
	}
	
	
	
	public String headerRow() {
		return "character,card,winrate,pickrate,wr_upgraded,pr_upgraded";
	}
	
}


package csv_output;

import javax.swing.plaf.synth.SynthGraphicsUtils;

import mystsstatsanalyser.WinContributionCalculator;
import tools.STSAnalyserUtils;

public class CardStatStats extends BaseSTSStats{
		
	private final String character;
	private final String card;
	private final double win_rate_picked;
	private final double pick_rate;
	private final int pick_elo;
	private final double card_win_contribution;
	private final double win_rate_picked_upgraded;
	private final double pick_rate_upgraded;
	private final int pick_elo_upgraded;	
	private final double card_win_contribution_upgraded;
	
	private final double character_wr;



	public CardStatStats(String character, double character_wr, String card, double win_rate_picked, double pick_rate, int pick_elo,
			double card_win_contribution, double win_rate_picked_upgraded, double pick_rate_upgraded,
			int pick_elo_upgraded, double card_win_contribution_upgraded) {
		super();
		this.character = character;
		this.card = card;
		this.win_rate_picked = win_rate_picked;
		this.pick_rate = pick_rate;
		this.pick_elo = pick_elo;
		this.card_win_contribution = card_win_contribution;
		this.win_rate_picked_upgraded = win_rate_picked_upgraded;
		this.pick_rate_upgraded = pick_rate_upgraded;
		this.pick_elo_upgraded = pick_elo_upgraded;
		this.card_win_contribution_upgraded = card_win_contribution_upgraded;
		this.character_wr = character_wr;
	}



	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +"," + card.substring(card.lastIndexOf('.') + 1)
                +"," + win_rate_picked
                +"," + pick_rate
                +"," + (pick_elo)
                +"," + (STSAnalyserUtils.truncateToTwoDecimals(card_win_contribution - character_wr))
                +"," + win_rate_picked_upgraded
                +"," + pick_rate_upgraded
                +"," + (pick_elo_upgraded)
                +"," + (STSAnalyserUtils.truncateToTwoDecimals(card_win_contribution_upgraded - character_wr))
                ;
	}
	
	
	
	public String headerRow() {
		return "character,card,pick winrate,pick rate, pick elo, win contribution,pick winrate upgraded,pick rate upgraded, pick elo upgraded, win contribution upgraded";
	}
	
}


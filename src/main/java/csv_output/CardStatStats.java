package csv_output;

import mystsstatsanalyser.EloCalculator;
import tools.STSAnalyserUtils;

public class CardStatStats extends BaseSTSStats{
		
	
	
	public String getCharacter() {
		return character;
	}




	public String getCard() {
		return card;
	}




	public double getWin_rate_picked() {
		return win_rate_picked;
	}




	public double getPick_rate() {
		return pick_rate;
	}




	public int getPick_elo() {
		return pick_elo;
	}




	public double getCard_win_contribution() {
		return card_win_contribution;
	}






	public double getCharacter_wr() {
		return character_wr;
	}



	private final String character;
	private final String card;
	private final double win_rate_picked;
	private final double pick_rate;
	private final int pick_elo;
	private final double card_win_contribution;
	
	private final double character_wr;



	public CardStatStats(String character, double character_wr, String card, double win_rate_picked, double pick_rate, int pick_elo,
			double card_win_contribution) {
		super();
		this.character = character;
		this.card = card;
		this.win_rate_picked = win_rate_picked;
		this.pick_rate = pick_rate;
		this.pick_elo = pick_elo;
		this.card_win_contribution = card_win_contribution;
		this.character_wr = character_wr;
	}


	

	@Override
	public String printRow() {
		return printForStupidExcel();
	}
	
	public String solidOutput() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +CsvWriter.seperator  + card.substring(card.lastIndexOf('.') + 1)
                +CsvWriter.seperator  + win_rate_picked * 100
                +CsvWriter.seperator  + pick_rate * 100
                +CsvWriter.seperator  + (pick_elo-EloCalculator.start_elo)
                +CsvWriter.seperator  + (STSAnalyserUtils.truncateToTwoDecimals(card_win_contribution - character_wr))
                ;
	}
	
	public String printForStupidExcel() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +CsvWriter.seperator  + card.substring(card.lastIndexOf('.') + 1)
                +CsvWriter.seperator  + (int) (win_rate_picked * 100)
                +CsvWriter.seperator  + (int) (pick_rate * 100)
                +CsvWriter.seperator  + (pick_elo-EloCalculator.start_elo)
                +CsvWriter.seperator  + (int) ((STSAnalyserUtils.truncateToTwoDecimals(card_win_contribution - character_wr))*100)
                ;
	}
	
	
	
	public String headerRow() {
		return String.join(CsvWriter.seperator, "character","card","pick winrate","pick rate", "pick elo", "win contribution");
	}
	
}


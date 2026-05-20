package mystsstatsanalyser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import mystsstatsanalyser.jsonObjects.Card;
import mystsstatsanalyser.jsonObjects.RunData;

public class WinContributionCalculator {

	private final double fitting_factor = -0.77;
	private STSCharacter stsc;

	public WinContributionCalculator(STSCharacter stsc) {
		super();
		this.stsc = stsc;
	}

	private HashMap<String, CardWinContribution> winContributions = new HashMap<String, CardWinContribution>();
	
	private HashSet<String> allCards = new HashSet<String>();

	
	public void collectData(RunData runData) {
		List<Card> deck = runData.getPlayers().getFirst().getDeck();
		int deck_size = deck.size();
		int actual_result = 0;
		if (runData.getWin()) {
			actual_result = 1;
		}
		double calculated_result = calcResult(deck);
		double deviation = calculated_result - actual_result;
		fit(deck, deviation);

	}
	


	private void fit(List<Card> deck, double deviation) {
		double fitting = deviation * fitting_factor / deck.size();
		for (Iterator iterator = deck.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			CardWinContribution contribution = winContributions.get(card.getId());		
			contribution.modify(fitting, isUpgraded(card));			
		}
	}


	private boolean isUpgraded(Card card) {
		return card.getCurrentUpgradeLevel()!= null;
	}
	
	private double calcResult(List<Card> deck) {
		double result = 0;
		for (Iterator iterator = deck.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			allCards.add(card.getId());
			if (!winContributions.containsKey(card.getId())) {
				winContributions.put(card.getId(), new CardWinContribution(stsc.getWinrate()));
			}
			CardWinContribution contribution = winContributions.get(card.getId());		
			if (isUpgraded(card)) {
				result += contribution.upgraded;
			}else {
				result+= contribution.basic;
			}
			
		}
		return result/deck.size();
	}


	public HashMap<String, CardWinContribution> getWinContributions() {
		return winContributions;
	}



	public HashSet<String> getAllCards() {
		return allCards;
	}
	
	
	
}

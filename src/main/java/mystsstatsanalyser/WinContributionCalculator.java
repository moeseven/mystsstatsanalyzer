package mystsstatsanalyser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import mystsstatsanalyser.jsonObjects.Card;
import mystsstatsanalyser.jsonObjects.Relic;
import mystsstatsanalyser.jsonObjects.RunData;

public class WinContributionCalculator {

	private STSCharacter stsc;

	public WinContributionCalculator(STSCharacter stsc) {
		super();
		this.stsc = stsc;
	}

	private HashMap<String, CardWinContribution> cardWinContributions = new HashMap<String, CardWinContribution>();
	private HashMap<String, WinContribution> relicWinContributions = new HashMap<String, WinContribution>();
	
	private HashSet<String> allCards = new HashSet<String>();
	
	private HashSet<String> allRelics = new HashSet<String>();

	
	public void collectData(RunData runData, int skipCount) {
		List<Card> deck = runData.getPlayers().getFirst().getDeck();
		addSkips(deck,skipCount);
		int actual_result = 0;
		if (runData.getWin()) {
			actual_result = 1;
		}
		double calculated_result = calcCardResult(deck);
		double deviation = actual_result - calculated_result;
		fitCards(deck, deviation);
	}
	
	public void collectRelicData(RunData runData) {
		List<Relic> relics = runData.getPlayers().getFirst().getRelics();
		int actual_result = 0;
		if (runData.getWin()) {
			actual_result = 1;
		}
		double calculated_result = calcRelicResult(relics);
		double deviation = actual_result - calculated_result;
		fit(relics,deviation);
	}




	

	private void addSkips(List<Card> deck, int numberOfSkips) {
		for (int i = 0; i < numberOfSkips; i++) {
			deck.add(stsc.getCard_choice_skip().getCard());
		}
	}


	private void fitCards(List<Card> deck, double deviation) {
		double fittingValue = deviation;
		for (Iterator iterator = deck.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			CardWinContribution contribution = cardWinContributions.get(card.getId());		
			contribution.modifyDiminishingly(fittingValue, isUpgraded(card));			
		}
	}
	
	private void fit(List<Relic> relics, double deviation) {
		double fittingValue = deviation;
		for (Iterator iterator = relics.iterator(); iterator.hasNext();) {
			Relic relic = (Relic) iterator.next();
			WinContribution contribution = relicWinContributions.get(relic.getId());		
			contribution.modifyDiminishingly(fittingValue);			
		}
	}


	private boolean isUpgraded(Card card) {
		return card.getCurrentUpgradeLevel()!= null;
	}
	
	private double calcCardResult(List<Card> deck) {
		double result = 0;
		for (Iterator iterator = deck.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			allCards.add(card.getId());
			if (!cardWinContributions.containsKey(card.getId())) {
				cardWinContributions.put(card.getId(), new CardWinContribution(stsc.getWinrate()));
			}
			CardWinContribution contribution = cardWinContributions.get(card.getId());		
			if (isUpgraded(card)) {
				result += contribution.getUpgraded().getValue();
			}else {
				result+= contribution.getBasic().getValue();
			}
			
		}
		return result/deck.size();
	}
	

	private double calcRelicResult(List<Relic> relics) {
		double result = 0;
		for (Iterator iterator = relics.iterator(); iterator.hasNext();) {
			Relic relic = (Relic) iterator.next();
			allRelics.add(relic.getId());
			if (!relicWinContributions.containsKey(relic.getId())) {
				relicWinContributions.put(relic.getId(), new WinContribution(stsc.getWinrate()));
			}
			WinContribution contribution = relicWinContributions.get(relic.getId());		
			result += contribution.getValue();
		}
		return result/relics.size();
	}


	public HashMap<String, CardWinContribution> getCardWinContributions() {
		return cardWinContributions;
	}



	public HashMap<String, WinContribution> getRelicWinContributions() {
		return relicWinContributions;
	}

	public HashSet<String> getAllCards() {
		return allCards;
	}
	
	
	
}

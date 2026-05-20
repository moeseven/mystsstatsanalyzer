package mystsstatsanalyser;

import java.util.Iterator;
import java.util.List;

import mystsstatsanalyser.jsonObjects.Card;
import mystsstatsanalyser.jsonObjects.Deck;

public class DeckComposition {

	private int[] basic;
	private int[] upgraded;
	
	private String[] allCards;

	public DeckComposition(String[] allCards, List<Card> cards) {
		super();
		this.allCards = allCards;
		for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
			Card type = (Card) iterator.next();
			
		}
	}
	
	public void addCard(Card card) {
		if (card.getCurrentUpgradeLevel()!= null) {
			
		}else {
			
		}
	}
	
}

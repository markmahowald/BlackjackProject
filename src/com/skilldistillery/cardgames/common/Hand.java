package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> handOfCards = new ArrayList<>();

	public int getValue() {
		int total = 0;
		if (handOfCards.size() != 0) {

			for (int i = 0; i < handOfCards.size(); i++) {
				total += handOfCards.get(i).getValue();
			}

		}
		return total;

	}
	public void addCard(Card card) {
	}
	public void clearHand() {
		handOfCards.removeAll(handOfCards);
		
	}
	public List<Card> getCards(){
		return this.handOfCards;
		
	}
	@Override
	public String toString() {
		return null;
	}
}

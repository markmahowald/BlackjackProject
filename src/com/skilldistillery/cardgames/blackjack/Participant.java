package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;
import com.skilldistillery.cardgames.common.Hand;

abstract public class Participant {
	private boolean bust;
	private BlackJackHand hand;

	public void hitMe(BlackJackHand hand, Deck deck) {
		Card c = deck.dealACard();
		hand.addCard(c);
		System.out.println(c.toString());

	}


public boolean isBust(BlackJackHand hand) {
	int total = hand.getValue();
	if (total>21) {
		setBust(true);
		return  getBust();
		
	}
	return bust;
}

	public void setBust(boolean bust) {
		this.bust = bust;
	}

	public boolean getBust() {
		return bust;
	}


	public BlackJackHand getHand() {
		return hand;
	}


	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}
}

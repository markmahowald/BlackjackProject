package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;
import com.skilldistillery.cardgames.common.Hand;

public class Dealer extends Participant {

	/*
	 * Dealer has specific rules of play. if hand total is lower than 17, he will
	 * keep hitting. he can bust the same way
	 */

	public void playHand(BlackJackHand hand, Deck deck) {
		int total = hand.getValue();
		while (total < 17) {
			System.out.println("Dealer hits.");
			hitMe(hand, deck);
			total = hand.getValue();
		}
		if (!isBust(hand)) {
			System.out.println("Dealer has " + total);

		} else {
			System.out.println("Dealer has gone bust");
		}

	}
	public void deal (Player player, Deck deck) {
		deck.shuffle();

		//	creating empty hands for dealer and player.
		BlackJackHand p = new BlackJackHand();
		BlackJackHand d = new BlackJackHand();
		
		this.setHand(d);
		player.setHand(p);
		
		System.out.println("Dealer is shuffling.");
		Card c = deck.dealACard();
		this.getHand().addCard(c);
		
		c = deck.dealACard();
		player.getHand().addCard(c);
		
		c = deck.dealACard();
		this.getHand().addCard(c);
		
		c = deck.dealACard();
		player.getHand().addCard(c);
		
	}
}

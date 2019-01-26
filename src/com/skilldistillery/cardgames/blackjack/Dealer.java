package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Deck;
import com.skilldistillery.cardgames.common.Hand;

public class Dealer extends Participant {

	
/* Dealer has specific rules of play.  if hand total is lower than 17, he will keep hitting. 
 * he can bust the same way
*/
	
	public void playHand(Hand hand, Deck deck) {
		int total = hand.getValue();
		while (total<17) {
			System.out.println("Dealer hits.");
			hitMe(hand, deck);
			total = hand.getValue();
		}
		if(isBust()) {
//			trigger some kind of loss here. 
		}else {
			System.out.println("Dealer has "+ total);
		}
		
	}
}

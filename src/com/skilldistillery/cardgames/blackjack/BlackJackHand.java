package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;

public class BlackJackHand extends Hand{
	
	public void playerDisplayHand() {
		List<Card> h = getCards();
		for (int i = 0; i < h.size(); i++) {
			
			System.out.print(h.get(i).getSuit()+ "" + h.get(i).getRank()+ " ");
		}
	}
	public void dealerDisplayHand() {
		List<Card> h = getCards();
		for (int i = 1; i < h.size(); i++) {
			
			System.out.print("Dealer has "+ h.get(i).getSuit()+ " " + h.get(i).getRank()+" showing");
		}
	}

}

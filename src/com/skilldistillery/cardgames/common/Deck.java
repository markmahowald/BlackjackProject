package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>();

	public Deck() {
		super();
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				Card c = new Card(suits[j], ranks[i]);
				this.deck.add(c);
			}
		}
	}
	public int checkDeckSize() {
		return this.deck.size();
	}
	public Card dealACard() {
		return this.deck.remove(0);
	}
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
}

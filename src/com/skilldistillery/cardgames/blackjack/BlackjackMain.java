package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgames.common.Deck;

public class BlackjackMain {

	public static void main(String[] args) {
//		instantiate player, dealer, deck, and driver. 
		Scanner kb = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Player player = new Player();
		BlackJackDriver driver = new BlackJackDriver();
		Deck deck = new Deck();
		
//deal will create hands for player and dealer. display hands will show one card for the dealer, and both for the player. 
		System.out.println("Welcome to the Casino. Lets play blackjack. ");
		dealer.deal(player, deck);
		driver.displayHands(dealer, player);
		
		driver.playerChoice(player, kb);
		
		
		
		

	}

}

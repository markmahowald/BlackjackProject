package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

public class BlackJackDriver {
	
	public void displayHands(Dealer dealer, Player player) {
		BlackJackHand playerHand = player.getHand();
		BlackJackHand dealerHand = dealer.getHand();
//		System.out.println("Dealer has "+dealerHand.getValue()+".");
		dealerHand.dealerDisplayHand();
		System.out.println();
		System.out.println();
		System.out.print("You have "); 
		playerHand.playerDisplayHand();
		System.out.print("showing "); 
		System.out.println("for a total of "+playerHand.getValue()+".");
	}

	public void playerChoice(Player player, Scanner kb) {
		if(!player.isBust(player.getHand())){
			System.out.println("What would you like to do?");
			System.out.println("1. Hit");
			System.out.println("2. Hit");
			
		}
		
	}

}


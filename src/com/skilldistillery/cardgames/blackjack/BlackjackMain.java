package com.skilldistillery.cardgames.blackjack;

import java.util.InputMismatchException;
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
		int playAgain = 0;

//deal will create hands for player and dealer. display hands will show one card for the dealer, and both for the player. 
		System.out.println("Welcome to the Casino. Lets play blackjack. ");
		
		while (playAgain == 0) {
			System.out.println(deck.checkDeckSize());
			dealer.deal(player, deck);
			driver.displayHands(dealer, player);
			while (!player.getBust() && !player.isStay()) {
				driver.playerChoice(player, kb, deck);
			}
			if (!player.getBust()) {

				driver.displayHands(dealer, player);
				System.out.println();
				System.out.println("Dealer will play their hand.");
				dealer.playHand(dealer.getHand(), deck);
			}
			if (player.getBust()) {
				System.out.println("You have busted. Dealer wins.");
			} else if (dealer.getBust()) {
				System.out.println("Dealer has busted. You win!");
			} else if (!player.getBust() && !dealer.getBust()) {
				driver.finalDisplayHands(dealer, player);
				if (player.getHand().getValue() > dealer.getHand().getValue()) {
					System.out.println("You Win!!! ");
				} else if (player.getHand().getValue() < dealer.getHand().getValue()) {
					System.out.println("Dealer wins. :(");
				}
			} else if (player.getHand().getValue() == dealer.getHand().getValue()) {
				System.out.println("Push (aka a tie). You get your money back. ");
			}

			System.out.println();
			System.out.println("Would you like to play another hand?\n1. Yes.\n2. No.");
			while (playAgain == 0) {

				try {
					playAgain = kb.nextInt();
					while (playAgain > 2 || playAgain < 0) {
						System.out.println("That was not one of the choices.\nYou have:");
						player.getHand().playerDisplayHand();
						System.out.println();
						System.out.println("Please input 1 or 2 for hit or stay");
						playAgain = kb.nextInt();
					}
				} catch (InputMismatchException e) {
					System.err.println("That was not a valid choice. Please input 1 or 2 to play again or leave.");
					playAgain = 0;

				} finally {
					kb.nextLine();
				}
				if (playAgain == 2) {
					System.out.println("Good Bye.");
					kb.close();
					System.exit(0);
				}
				if(playAgain ==1) {
					player.getHand().clearHand();
					dealer.getHand().clearHand();
					kb.nextLine();
					
				}
			}
		}
	}
}

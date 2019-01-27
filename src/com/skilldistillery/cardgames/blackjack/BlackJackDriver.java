package com.skilldistillery.cardgames.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cardgames.common.Deck;

public class BlackJackDriver {

	public void displayHands(Dealer dealer, Player player) {
		BlackJackHand playerHand = player.getHand();
		BlackJackHand dealerHand = dealer.getHand();
		dealerHand.dealerDisplayHand();
		System.out.println();
		System.out.println();
		System.out.print("You have ");
		playerHand.playerDisplayHand();
		System.out.print("showing ");
		System.out.println("for a total of " + playerHand.getValue() + ".");
	}

	public void finalDisplayHands(Dealer dealer, Player player) {
		BlackJackHand playerHand = player.getHand();
		BlackJackHand dealerHand = dealer.getHand();
		dealerHand.playerDisplayHand();
		System.out.println();
		System.out.println();
		System.out.print("You have ");
		playerHand.playerDisplayHand();
		System.out.print("showing ");
		System.out.println("for a total of " + playerHand.getValue() + ".");
	}

	public void playerChoice(Player player, Scanner kb, Deck deck) {
		int choice = 0;
		while (choice == 0) {
			System.out.println("What would you like to do?");
			System.out.println("1. Hit");
			System.out.println("2. Stay");

			try {
				choice = kb.nextInt();
				while (choice > 2 || choice < 1) {
					System.out.println("That was not one of the choices.\nYou have:");
					player.getHand().playerDisplayHand();
					System.out.println();
					System.out.println("Please input 1 or 2 for hit or stay");
					choice = kb.nextInt();
				}
			} catch (InputMismatchException e) {
				System.err.println("That was not a valid choice. Please input 1 or 2 for hit or stay");
				choice = 0;

			} finally {
				kb.nextLine();
			}
		}
		if (choice == 1) {
			player.hitMe(player.getHand(), deck);
			System.out.print("You now have ");
			player.getHand().playerDisplayHand();
			System.out.print(" for a total of " + player.getHand().getValue());
			System.out.println();
			player.isBust(player.getHand());

		} else if (choice == 2) {
			player.setStay(true);
		}

	}

	public void playLoop() {
		
//		instantiate player, dealer, deck, and driver. 
		Scanner kb = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Player player = new Player();
		Deck deck = new Deck();
		int playAgain = 0;
		
		System.out.println("Welcome to the Casino. Lets play blackjack. ");


//		this is the play loop - it will allow the player to play until they decide to exit. 
		while (playAgain == 0 || playAgain == 1) {
			if (deck.checkDeckSize() < 15) {
				deck = new Deck();
			}
			playAgain = 0;
			System.out.println(deck.checkDeckSize());
			dealer.deal(player, deck);
			displayHands(dealer, player);

			while (!player.getBust() && !player.isStay()) {
				playerChoice(player, kb, deck);
			}

			if (!player.getBust()) {

				displayHands(dealer, player);
				System.out.println();
				System.out.println("Dealer will play their hand.");
				dealer.playHand(dealer.getHand(), deck);
			}
			if (player.getBust()) {
				System.out.println("You have busted. Dealer wins.");
			} else if (dealer.getBust()) {
				System.out.println("Dealer has busted. You win!");
			} else if (!player.getBust() && !dealer.getBust()) {
				finalDisplayHands(dealer, player);
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
				if (playAgain == 1) {
					player.getHand().clearHand();
					dealer.getHand().clearHand();
					player.setStay(false);
					dealer.setStay(false);
					player.setBust(false);
					dealer.setBust(false);
				}
			}
		}

	}

}

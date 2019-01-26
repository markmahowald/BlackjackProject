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
			System.out.print(" for a total of "+ player.getHand().getValue());
			System.out.println();
			player.isBust(player.getHand());

		}else if(choice ==2) {
			player.setStay(true);
		}

	}

}



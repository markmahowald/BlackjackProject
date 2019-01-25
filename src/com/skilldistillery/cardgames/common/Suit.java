package com.skilldistillery.cardgames.common;

public enum Suit {

	HEARTS("\u2764"), 
	SPADES("\u2660"), 
	CLUBS ("\u2663"), 
	DIAMONDS("\u2666");
	
	Suit(String d){
		name=d;
	}

	final private String name;

	  @Override
	  public String toString() {
	    return name;
	  }

	  public String getName() {
	    return name;
	}
}

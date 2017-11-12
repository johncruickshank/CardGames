package com.example.john.cardgames.setup;

/**
 * Created by John on 10/11/2017.
 */

public class Card {

    Suit suit;
    Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return this.rank.getValue();
    }

}

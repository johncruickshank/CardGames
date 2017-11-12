package com.example.john.cardgames.setup;

import java.util.ArrayList;

/**
 * Created by John on 10/11/2017.
 */

public class Dealer extends Player {

    private Deck deck;
    private ArrayList<Card> cards;
    private int playerScore;

    public Dealer(String name, Deck deck) {
        super(name);
        this.cards = new ArrayList<>();
        this.playerScore = 0;
        this.deck = deck;
        shuffle();
    }

    public Card deal() {
        return deck.removeCard();
    }

    public void shuffle(){
        this.deck.shuffle();
    }

}

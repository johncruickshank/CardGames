package com.example.john.cardgames.setup;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by John on 10/11/2017.
 */

public class Deck {

    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        generateDeck();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void generateDeck() {
        for (Card card : Card.values()) {
                cards.add(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        return cards.remove(0);
    }

}

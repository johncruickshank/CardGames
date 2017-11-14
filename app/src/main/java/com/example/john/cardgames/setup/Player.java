package com.example.john.cardgames.setup;

import com.example.john.cardgames.setup.Card;

import java.util.ArrayList;

/**
 * Created by John on 10/11/2017.
 */

public class Player {

    private String name;
    private ArrayList<Card> cards;
    private int playerScore;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.playerScore = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void takeCard(Card card) {
        this.cards.add(card);
    }

    public void calculateScore() {

        int score = 0;
        for (Card card : cards) {
            score += card.getValue();
        }
        setPlayerScore(score);

        if (isBust()) {
            for (Card card : getCards()) {
                if (card.getValue() == 11) {
                    score -= 10;
                    setPlayerScore(score);
                    if (score <= 21) {
                        break;
                    }
                }
            }
        }
    }

    public boolean isBust() {
        return (getPlayerScore() > 21);
    }

    public boolean checkBlackjack() {
        calculateScore();
        return getPlayerScore() == 21;
    }

    public boolean checkFiveCardTrick() {
        return (!isBust() && (cards.size()) == 5);
    }

    public void clearArray() {
        cards.clear();
    }

}

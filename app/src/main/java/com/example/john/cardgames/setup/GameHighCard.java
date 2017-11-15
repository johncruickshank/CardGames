package com.example.john.cardgames.setup;

/**
 * Created by John on 14/11/2017.
 */

public class GameHighCard {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public GameHighCard(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void initialDeal() {
        deck.shuffle();
        player.takeCard(dealer.deal());
        dealer.takeCard(dealer.deal());
    }

    public Player checkWinner(Player player, Dealer dealer) {
        if (player.getHighCardValue() > dealer.getHighCardValue()) {
            return player;
        }
        if (player.getHighCardValue() < dealer.getHighCardValue()) {
                return dealer;
        }
        return null;
    }

}

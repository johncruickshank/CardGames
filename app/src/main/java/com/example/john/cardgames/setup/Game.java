package com.example.john.cardgames.setup;

import com.example.john.cardgames.setup.Card;
import com.example.john.cardgames.setup.Dealer;
import com.example.john.cardgames.setup.Deck;
import com.example.john.cardgames.setup.Player;

import java.util.ArrayList;

/**
 * Created by John on 10/11/2017.
 */

public class Game {

    Player player;
    Dealer dealer;
    Deck deck;

    public Game(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void initialDeal() {
        deck.shuffle();
        player.takeCard(dealer.deal());
        dealer.takeCard(dealer.deal());
        player.takeCard(dealer.deal());
        dealer.takeCard(dealer.deal());
    }

    public Player checkWinner(Player player, Dealer dealer) {
        if (!player.isBust() && dealer.isBust()) {
            return player;
        }
        if (!player.isBust() && player.checkFiveCardTrick() && !dealer.checkFiveCardTrick()) {
                return player;
            }
        if (!player.isBust() && player.getPlayerScore() > dealer.getPlayerScore()) {
                return player;
            }
        return dealer;
        }

    }




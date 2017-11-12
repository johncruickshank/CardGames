package com.example.john.cardgames;

import com.example.john.cardgames.setup.Card;
import com.example.john.cardgames.setup.Dealer;
import com.example.john.cardgames.setup.Deck;
import com.example.john.cardgames.setup.Game;
import com.example.john.cardgames.setup.Player;
import com.example.john.cardgames.setup.Rank;
import com.example.john.cardgames.setup.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by John on 12/11/2017.
 */

public class TestGame {

    Game game;
    Deck deck;
    Player player;
    Dealer dealer;
    Card card;
    Card card2;
    Card card3;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        player = new Player("John");
        dealer = new Dealer("dealer", deck);
        game = new Game(player, dealer, deck);
        card = new Card(Suit.SPADES, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.KING);
        card3 = new Card(Suit.SPADES, Rank.FIVE);
    }

    @Test
    public void testInitialDeal() {
        game.initialDeal();
        assertEquals(2, player.getCards().size());
        assertEquals(2, dealer.getCards().size());
    }

    @Test
    public void canCheckWinnerPlayer() {
        player.takeCard(card);
        player.takeCard(card2);
        dealer.takeCard(card);
        dealer.takeCard(card3);
        player.calculateScore();
        dealer.calculateScore();
        assertEquals(player, game.checkWinner(player, dealer));
    }

    @Test
    public void canCheckWinnerDealer() {
        player.takeCard(card);
        player.takeCard(card2);
        dealer.takeCard(card);
        dealer.takeCard(card2);
        player.calculateScore();
        dealer.calculateScore();
        assertEquals(dealer, game.checkWinner(player, dealer));
    }

}

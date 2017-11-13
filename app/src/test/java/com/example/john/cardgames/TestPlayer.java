package com.example.john.cardgames;

import com.example.john.cardgames.setup.Card;
import com.example.john.cardgames.setup.Dealer;
import com.example.john.cardgames.setup.Deck;
import com.example.john.cardgames.setup.Player;
import com.example.john.cardgames.setup.Rank;
import com.example.john.cardgames.setup.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by John on 10/11/2017.
 */

public class TestPlayer {

    Player player;
    Card card;
    Card card2;
    Card card3;
    Dealer dealer;
    Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        player = new Player("John");
        dealer = new Dealer("dealer", deck);
        card = Card.ACESPADES;
        card2 = Card.KINGSPADES;
        card3 = Card.FIVESPADES;
    }

    @Test
    public void canTakeCard() throws Exception {
        player.takeCard(card);
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canCalculateScore() {
        player.takeCard(card);
        player.takeCard(card2);
        player.calculateScore();
        assertEquals(21, player.getPlayerScore());
    }

    @Test
    public void canCalculateScoreWithAce() {
        player.takeCard(card);
        player.takeCard(card2);
        player.takeCard(card2);
        player.calculateScore();
        assertEquals(21, player.getPlayerScore());
    }

    @Test
    public void canCalculateScoreWithTwoAces() {
        player.takeCard(card);
        player.takeCard(card);
        player.takeCard(card2);
        player.takeCard(card3);
        player.calculateScore();
        assertEquals(17, player.getPlayerScore());
    }

    @Test
    public void testDealer() {
        dealer.takeCard(card);
        dealer.takeCard(card);
        dealer.takeCard(card2);
        dealer.takeCard(card3);
        dealer.calculateScore();
        assertEquals(17, dealer.getPlayerScore());
    }

    @Test
    public void testBlackjack() {
        player.takeCard(card);
        player.takeCard(card2);
        assertEquals(true, player.checkBlackjack());
    }

    @Test
    public void testFiveCardTrick() {
        player.takeCard(card);
        player.takeCard(card);
        player.takeCard(card);
        player.takeCard(card);
        player.takeCard(card2);
        assertEquals(true, player.checkFiveCardTrick());
    }

}

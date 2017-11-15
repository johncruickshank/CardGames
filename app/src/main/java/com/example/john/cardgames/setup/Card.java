package com.example.john.cardgames.setup;

import com.example.john.cardgames.R;

/**
 * Created by John on 10/11/2017.
 */

public enum Card {

    KINGSPADES(10, 13, R.drawable.king_spades),
    QUEENSPADES(10, 12, R.drawable.queen_spades),
    JACKSPADES(10, 11, R.drawable.jack_spades),
    TENSPADES(10, 10, R.drawable.ten_spades),
    NINESPADES(9, 9, R.drawable.nine_spades),
    EIGHTSPADES(8, 8, R.drawable.eight_spades),
    SEVENSPADES(7, 7, R.drawable.seven_spades),
    SIXSPADES(6, 6, R.drawable.six_spades),
    FIVESPADES(5, 5, R.drawable.five_spades),
    FOURSPADES(4, 4, R.drawable.four_spades),
    THREESPADES(3, 3, R.drawable.three_spades),
    TWOSPADES(2, 2, R.drawable.two_spades),
    ACESPADES(11, 14, R.drawable.ace_spades),
    KINGHEARTS(10, 13, R.drawable.king_hearts),
    QUEENHEARTS(10, 12, R.drawable.queen_hearts),
    JACKHEARTS(10, 11, R.drawable.jack_hearts),
    TENHEARTS(10, 10, R.drawable.ten_hearts),
    NINEHEARTS(9, 9, R.drawable.nine_hearts),
    EIGHTHEARTS(8, 8, R.drawable.eight_hearts),
    SEVENHEARTS(7, 7, R.drawable.seven_hearts),
    SIXHEARTS(6, 6, R.drawable.six_hearts),
    FIVEHEARTS(5, 5, R.drawable.five_hearts),
    FOURHEARTS(4, 4, R.drawable.four_hearts),
    THREEHEARTS(3, 3, R.drawable.three_hearts),
    TWOHEARTS(2, 2, R.drawable.two_hearts),
    ACEHEARTS(11, 14, R.drawable.ace_hearts),
    KINGCLUBS(10, 13, R.drawable.king_clubs),
    QUEENCLUBS(10, 12, R.drawable.queen_clubs),
    JACKCLUBS(10, 11, R.drawable.jack_clubs),
    TENCLUBS(10, 10, R.drawable.ten_clubs),
    NINECLUBS(9, 9, R.drawable.nine_clubs),
    EIGHTCLUBS(8, 8, R.drawable.eight_clubs),
    SEVENCLUBS(7, 7, R.drawable.seven_clubs),
    SIXCLUBS(6, 6, R.drawable.six_clubs),
    FIVECLUBS(5, 5, R.drawable.five_clubs),
    FOURCLUBS(4, 4, R.drawable.four_clubs),
    THREECLUBS(3, 3, R.drawable.three_clubs),
    TWOCLUBS(2, 2, R.drawable.two_clubs),
    ACECLUBS(11, 14, R.drawable.ace_clubs),
    KINGDIAMONDS(10, 13, R.drawable.king_diamonds),
    QUEENDIAMONDS(10, 12, R.drawable.queen_diamonds),
    JACKDIAMONDS(10, 11, R.drawable.jack_diamonds),
    TENDIAMONDS(10, 10, R.drawable.ten_diamonds),
    NINEDIAMONDS(9, 9, R.drawable.nine_diamonds),
    EIGHTDIAMONDS(8, 8, R.drawable.eight_diamonds),
    SEVENDIAMONDS(7, 7, R.drawable.seven_diamonds),
    SIXDIAMONDS(6, 6, R.drawable.six_diamonds),
    FIVEDIAMONDS(5, 5, R.drawable.five_diamonds),
    FOURDIAMONDS(4, 4, R.drawable.four_diamonds),
    THREEDIAMONDS(3, 3, R.drawable.three_diamonds),
    TWODIAMONDS(2, 2, R.drawable.two_diamonds),
    ACEDIAMONDS(11, 14, R.drawable.ace_diamonds);

    protected int value;
    protected int highCardValue;
    protected int image;

    Card(int value, int highCardValue, int drawableID) {
        this.value = value;
        this.highCardValue = highCardValue;
        this.image = drawableID;
    }

    public int getValue() {
        return value;
    }

    public int getHighCardValue() {
        return highCardValue;
    }

    public int getImage() {
        return image;
    }
}

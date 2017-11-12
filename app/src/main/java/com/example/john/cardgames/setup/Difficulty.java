package com.example.john.cardgames.setup;

/**
 * Created by John on 10/11/2017.
 */

public enum Difficulty {

    EASY(1, "easy"),
    MEDIUM(2, "medium"),
    HARD(5, "hard");

    private int modifier;
    private String difficulty;

    Difficulty(int modifier, String difficulty) {
        this.modifier = modifier;
        this.difficulty = difficulty;
    }
}

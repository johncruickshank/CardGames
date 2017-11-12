package com.example.john.cardgames.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.john.cardgames.R;

public class BlackjackGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_game);

        Intent i = getIntent();
    }

    public static void main(String[] args) {

    }

}

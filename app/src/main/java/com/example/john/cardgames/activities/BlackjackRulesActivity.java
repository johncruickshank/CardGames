package com.example.john.cardgames.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.john.cardgames.R;

public class BlackjackRulesActivity extends AppCompatActivity {

    private Button playBlackjack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_rules);
        Intent i = getIntent();

        playBlackjack = (Button) findViewById(R.id.playBlackjackButton);

    }

    public void onPlayBlackjack(View button) {
        Intent i = new Intent(this, BlackjackGameActivity.class);
        startActivity(i);
    }


}

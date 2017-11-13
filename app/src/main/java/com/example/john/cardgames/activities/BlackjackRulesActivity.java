package com.example.john.cardgames.activities;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.cardgames.R;
import com.example.john.cardgames.setup.Player;

public class BlackjackRulesActivity extends AppCompatActivity {

    private Button playBlackjack;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_rules);
        nameEditText = (EditText) findViewById(R.id.enterName);
        Intent i = getIntent();

        playBlackjack = (Button) findViewById(R.id.playBlackjackButton);

    }

    public void onPlayBlackjack(View button) {
        String name = nameEditText.getText().toString();
        Intent i = new Intent(this, BlackjackGameActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }


}

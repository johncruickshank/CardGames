package com.example.john.cardgames.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.example.john.cardgames.R;
import com.example.john.cardgames.setup.Player;

import static com.example.john.cardgames.R.string.twentyOneRules;

public class BlackjackRulesActivity extends AppCompatActivity {

    private Button playBlackjack;
    private EditText nameEditText;
    private MultiAutoCompleteTextView rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_rules);
        nameEditText = (EditText) findViewById(R.id.enterName);
        Intent i = getIntent();

        playBlackjack = (Button) findViewById(R.id.playBlackjackButton);

        Typeface font = Typeface.createFromAsset(getAssets(), "fff.ttf");
        ((TextView)findViewById(R.id.twentyOneRules)).setTypeface(font);
    }

    public void onPlayBlackjack(View button) {
        String name = nameEditText.getText().toString();
        Intent i = new Intent(this, BlackjackGameActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }


}

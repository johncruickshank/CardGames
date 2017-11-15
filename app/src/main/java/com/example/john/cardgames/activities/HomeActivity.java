package com.example.john.cardgames.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.john.cardgames.R;

public class HomeActivity extends AppCompatActivity {

    private ImageButton blackjackButton;
    private ImageButton highCardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        blackjackButton = (ImageButton) findViewById(R.id.blackjackButton);
        highCardButton = (ImageButton) findViewById(R.id.highCardButton);

        Typeface font = Typeface.createFromAsset(getAssets(), "fff.ttf");
        ((TextView)findViewById(R.id.title)).setTypeface(font);
    }

    public void onBlackjackClicked(View button) {
        Intent i = new Intent(this, BlackjackRulesActivity.class);
        startActivity(i);
    }

    public void onHighCardClicked(View button) {
        Intent i = new Intent(this, HighCardRulesActivity.class);
        startActivity(i);
    }

}

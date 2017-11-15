package com.example.john.cardgames.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.john.cardgames.R;

public class HighCardRulesActivity extends AppCompatActivity {

    private Button playHighCard;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_card_rules);
        nameEditText = (EditText) findViewById(R.id.enterName);
        Intent i = getIntent();

        playHighCard = (Button) findViewById(R.id.playHighCardButton);

        Typeface font = Typeface.createFromAsset(getAssets(), "fff.ttf");
        ((TextView)findViewById(R.id.highCardRules)).setTypeface(font);
    }

    public void onPlayHighCard(View button) {
        String name = nameEditText.getText().toString();
        Intent i = new Intent(this, HighCardGameActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }

}

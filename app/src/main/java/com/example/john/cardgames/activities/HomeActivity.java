package com.example.john.cardgames.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.john.cardgames.R;

public class HomeActivity extends AppCompatActivity {

    private Button blackjackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        blackjackButton = (Button) findViewById(R.id.blackjackButton);
    }

    public void onBlackjackClicked(View button) {
        Intent i = new Intent(this, BlackjackRulesActivity.class);
        startActivity(i);
    }

}

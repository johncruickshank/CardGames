package com.example.john.cardgames.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.cardgames.R;
import com.example.john.cardgames.setup.Dealer;
import com.example.john.cardgames.setup.Deck;
import com.example.john.cardgames.setup.Game21;
import com.example.john.cardgames.setup.GameHighCard;
import com.example.john.cardgames.setup.Player;

import static com.example.john.cardgames.R.id.houseWins;
import static com.example.john.cardgames.activities.BlackjackGameActivity.realDeal2;

public class HighCardGameActivity extends AppCompatActivity {

    private static Deck deck;
    private static Player player;
    private static Dealer dealer;
    private static GameHighCard game;
    int playerWinCounter;
    int houseWinCounter;
    ImageButton deal;
    ImageButton playAgain;
    String name;
    Bundle extras;
    static ImageView realPlay1;
    static ImageView realDeal1;
    static ImageView houseWin;
    static ImageView playerWin;
    static TextView playerWins;
    static TextView dealerWins;
    static TextView dealText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_card_game);
        extras = getIntent().getExtras();
        name = extras.getString("name");
        houseWinCounter = 0;
        playerWinCounter = 0;
        deal = (ImageButton) findViewById(R.id.dealButton);
        playAgain = (ImageButton) findViewById(R.id.playAgainButton);
        realPlay1 = (ImageView) findViewById(R.id.playerImage1);
        realDeal1 = (ImageView) findViewById(R.id.dealerImage1);
        houseWin = (ImageView) findViewById(houseWins);
        playerWin = (ImageView) findViewById(R.id.playerWin);
        playerWins = (TextView) findViewById(R.id.playerWins);
        dealerWins = (TextView) findViewById(R.id.dealerWins);
        dealText = (TextView) findViewById(R.id.dealText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fff.ttf");
        ((TextView)findViewById(R.id.playerWins)).setTypeface(font);
        ((TextView)findViewById(R.id.dealerWins)).setTypeface(font);
    }

    public void onPlayAgain(View view) {
        deal.setVisibility(View.VISIBLE);
        dealText.setVisibility(View.VISIBLE);
        houseWin.setVisibility(View.GONE);
        playerWin.setVisibility(View.GONE);
        realPlay1.setVisibility(View.INVISIBLE);
        realDeal1.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.GONE);
        realPlay1.setImageResource(R.drawable.back);
        realDeal1.setImageResource(R.drawable.back);
    }

    public void onClick(View view) {
        // get rid of deal button
        deal.setVisibility(View.GONE);
        dealText.setVisibility(View.GONE);

        // initialise new game
        deck = new Deck();
        dealer = new Dealer("dealer", deck);
        player = new Player(name);
        game = new GameHighCard(player, dealer, deck);
        // deal initial cards
        game.initialDeal();
        // display both cards
        player.setPlayerScore(player.getCards().get(0).getValue());
        dealer.setPlayerScore(dealer.getCards().get(0).getValue());
        realPlay1.setImageResource(player.getCards().get(0).getImage());
        realDeal1.setImageResource(dealer.getCards().get(0).getImage());
        realPlay1.setVisibility(View.VISIBLE);
        realDeal1.setVisibility(View.VISIBLE);

        // finish game, display results
        gameOver();
    }

    public void gameOver() {
        if (game.checkWinner(player, dealer) == player) {
            playerWin.setVisibility(View.VISIBLE);
            playAgain.setVisibility(View.VISIBLE);
            playerWinCounter = playerWinCounter + 1;
        }
        if (game.checkWinner(player, dealer) == null) {
            // perform tie activity
            playAgain.setVisibility(View.VISIBLE);
        }
        if (game.checkWinner(player, dealer) == dealer) {
            houseWin.setVisibility(View.VISIBLE);
            playAgain.setVisibility(View.VISIBLE);
            houseWinCounter = houseWinCounter + 1;
        }
        // display win count
        playerWins.setText(name + "'s wins:\n" + playerWinCounter);
        dealerWins.setText("Dealer's wins:\n" + houseWinCounter);
    }
}


package com.example.john.cardgames.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.john.cardgames.R;
import com.example.john.cardgames.setup.Dealer;
import com.example.john.cardgames.setup.Deck;
import com.example.john.cardgames.setup.Game;
import com.example.john.cardgames.setup.Player;

import static android.os.Build.VERSION_CODES.O;

public class BlackjackGameActivity extends AppCompatActivity implements View.OnClickListener{

    private static Deck deck;
    private static Player player;
    private static Dealer dealer;
    private static Game game;
    Button deal;
    Button twist;
    Button stick;
    static ImageView realPlay1;
    static ImageView realPlay2;
    static ImageView realPlay3;
    static ImageView realPlay4;
    static ImageView realPlay5;
    static ImageView realDeal1;
    static ImageView realDeal2;
    static ImageView realDeal3;
    static ImageView realDeal4;
    static ImageView realDeal5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_game);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        deal = (Button) findViewById(R.id.dealButton);
        twist = (Button) findViewById(R.id.twistButton);
        stick = (Button) findViewById(R.id.stickButton);
        deal.setOnClickListener(BlackjackGameActivity.this);
        realDeal1 = (ImageView) findViewById(R.id.dealerImage1);
        realDeal2 = (ImageView) findViewById(R.id.dealerImage2);
        realDeal3 = (ImageView) findViewById(R.id.dealerImage3);
        realDeal4 = (ImageView) findViewById(R.id.dealerImage4);
        realDeal5 = (ImageView) findViewById(R.id.dealerImage5);
        realPlay1 = (ImageView) findViewById(R.id.playerImage1);
        realPlay2 = (ImageView) findViewById(R.id.playerImage2);
        realPlay3 = (ImageView) findViewById(R.id.playerImage3);
        realPlay4 = (ImageView) findViewById(R.id.playerImage4);
        realPlay5 = (ImageView) findViewById(R.id.playerImage5);
    }

    public static void main(String[] args) {

        // set player name


        // display player score
        //  while not bust
        //      twist or stick button
        //      if twist, display new card and total
        // dealer turn
        // display other card
        // twist if < 16 or <player score
        // display winner
    }

    public void onClick(View view) {
        // get rid of deal button
        deal.setVisibility(View.GONE);

        // initialise new game
        deck = new Deck();
        dealer = new Dealer("dealer", deck);
        player = new Player("player");
        game = new Game(player, dealer, deck);
        // deal initial cards
        game.initialDeal();
        // display one dealer card, 2 player
        player.getCards();
        realPlay1.setImageResource(player.getCards().get(0).getImage());
        realPlay2.setImageResource(player.getCards().get(1).getImage());
        realDeal1.setImageResource(dealer.getCards().get(0).getImage());

        // make twist or stick options available
        twist.setVisibility(View.VISIBLE);
        stick.setVisibility(View.VISIBLE);
    }


    public void twist(View view) {
    }

    public void stick(View view) {
    }
}

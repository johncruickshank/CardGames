package com.example.john.cardgames.activities;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.cardgames.R;
import com.example.john.cardgames.setup.Dealer;
import com.example.john.cardgames.setup.Deck;
import com.example.john.cardgames.setup.Game;
import com.example.john.cardgames.setup.Player;

import static com.example.john.cardgames.R.id.houseWins;


public class BlackjackGameActivity extends AppCompatActivity implements View.OnClickListener{

    private static Deck deck;
    private static Player player;
    private static Dealer dealer;
    private static Game game;
    int playerWinCounter;
    int houseWinCounter;
    Button deal;
    Button twist;
    Button stick;
    ImageButton playAgain;
    String name;
    Bundle extras;
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
    static ImageView houseWin;
    static ImageView playerWin;
    static TextView playerWins;
    static TextView dealerWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_game);
        extras = getIntent().getExtras();
        name = extras.getString("name");
        houseWinCounter = 0;
        playerWinCounter = 0;
        deal = (Button) findViewById(R.id.dealButton);
        twist = (Button) findViewById(R.id.twistButton);
        stick = (Button) findViewById(R.id.stickButton);
        playAgain = (ImageButton) findViewById(R.id.playAgainButton);
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
        houseWin = (ImageView) findViewById(houseWins);
        playerWin = (ImageView) findViewById(R.id.playerWin);
        playerWins = (TextView) findViewById(R.id.playerWins);
        dealerWins = (TextView) findViewById(R.id.dealerWins);
        Typeface font = Typeface.createFromAsset(getAssets(), "fff.ttf");
        ((TextView)findViewById(R.id.playerWins)).setTypeface(font);
        ((TextView)findViewById(R.id.dealerWins)).setTypeface(font);
    }

    public static void main(String[] args) {

    }

    public void onPlayAgain(View view) {
        deal.setVisibility(View.VISIBLE);
        houseWin.setVisibility(View.GONE);
        playerWin.setVisibility(View.GONE);
        realPlay1.setVisibility(View.INVISIBLE);
        realPlay2.setVisibility(View.INVISIBLE);
        realPlay3.setVisibility(View.INVISIBLE);
        realPlay4.setVisibility(View.INVISIBLE);
        realPlay5.setVisibility(View.INVISIBLE);
        realDeal1.setVisibility(View.INVISIBLE);
        realDeal2.setVisibility(View.INVISIBLE);
        realDeal3.setVisibility(View.INVISIBLE);
        realDeal4.setVisibility(View.INVISIBLE);
        realDeal5.setVisibility(View.INVISIBLE);
        twist.setVisibility(View.GONE);
        stick.setVisibility(View.GONE);
        playAgain.setVisibility(View.GONE);
        realDeal2.setImageResource(0);
        realDeal2.destroyDrawingCache();
        realDeal2.setImageResource(R.drawable.back);
    }

    public void onClick(View view) {
        // get rid of deal button
        deal.setVisibility(View.GONE);

        // initialise new game
        deck = new Deck();
        dealer = new Dealer("dealer", deck);
        player = new Player(name);
        game = new Game(player, dealer, deck);
        // deal initial cards
        game.initialDeal();
        // display one dealer card, 2 player
        player.getCards();
        realPlay1.setImageResource(player.getCards().get(0).getImage());
        realPlay2.setImageResource(player.getCards().get(1).getImage());
        realPlay1.setVisibility(View.VISIBLE);
        realPlay2.setVisibility(View.VISIBLE);
        realDeal1.setImageResource(dealer.getCards().get(0).getImage());
        realDeal1.setVisibility(View.VISIBLE);

        realDeal2.setVisibility(View.VISIBLE);

        // check for blackjack
        if (player.checkBlackjack()) {
            gameOver();
        }

        // make twist or stick options available
        twist.setVisibility(View.VISIBLE);
        stick.setVisibility(View.VISIBLE);

    }


    public void twist(View view) {

        player.takeCard(dealer.deal());
        if (player.getCards().size() == 3) {
            realPlay3.setImageResource(player.getCards().get(2).getImage());
            realPlay3.setVisibility(View.VISIBLE);
        }
        if (player.getCards().size() == 4) {
            realPlay4.setImageResource(player.getCards().get(3).getImage());
            realPlay4.setVisibility(View.VISIBLE);
        }
        if (player.getCards().size() == 5) {
            realPlay5.setImageResource(player.getCards().get(4).getImage());
            realPlay5.setVisibility(View.VISIBLE);
            twist.setVisibility(View.GONE);
        }
        player.calculateScore();
        if (player.isBust()) {
            gameOver();
        }

    }


    public void stick(View view) {

        // get rid of stick/twist buttons
        twist.setVisibility(View.GONE);
        stick.setVisibility(View.GONE);
//        new CountDownTimer(2000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//            }
//            @Override
//            public void onFinish() {
                // reveal second card
                realDeal2.setImageResource(dealer.getCards().get(1).getImage());
//            }
//        }.start();
        dealer.calculateScore();
        // dealer's turn
        // dealer must twist if score < 16, and if score is less than players
        while (!dealer.isBust() && dealer.getPlayerScore() < player.getPlayerScore() && dealer.getPlayerScore() < 16) {
//            new CountDownTimer(3000, 1000) {
//                @Override
//                public void onTick(long millisUntilFinished) {
//                }
//                @Override
//                public void onFinish() {
                    dealer.takeCard(dealer.deal());
                    if (dealer.getCards().size() == 3) {
                        realDeal3.setImageResource(dealer.getCards().get(2).getImage());
                        realDeal3.setVisibility(View.VISIBLE);
                    }
                    if (dealer.getCards().size() == 4) {
                        realDeal4.setImageResource(dealer.getCards().get(3).getImage());
                        realDeal4.setVisibility(View.VISIBLE);
                    }
                    if (dealer.getCards().size() == 5) {
                        realDeal5.setImageResource(dealer.getCards().get(4).getImage());
                        realDeal5.setVisibility(View.VISIBLE);
                    }
                    // store the dealers score
                    dealer.calculateScore();
                    if (dealer.isBust()) {
                        gameOver();
                    }
//                }
//            }.start();
        }
        gameOver();
    }

    public void gameOver() {
        twist.setVisibility(View.GONE);
        stick.setVisibility(View.GONE);

        if (game.checkWinner(player, dealer).equals(player)) {
            realDeal2.setImageResource(dealer.getCards().get(1).getImage());
            playerWin.setVisibility(View.VISIBLE);
            playAgain.setVisibility(View.VISIBLE);
            playerWinCounter++;
        }
        else {
            realDeal2.setImageResource(dealer.getCards().get(1).getImage());
            houseWin.setVisibility(View.VISIBLE);
            playAgain.setVisibility(View.VISIBLE);
            houseWinCounter++;
        }



        playerWins.setText(name + "'s wins:\n" + playerWinCounter);
        dealerWins.setText("Dealer's wins:\n" + houseWinCounter);
    }



}



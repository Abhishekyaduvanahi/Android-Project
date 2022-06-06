package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView playerOneScore,playerTwoScore,playerStatus;
    private Button[] buttons = new Button[9];
    private Button resetGame;

    private int playerOneScoreCount ,playerTwoScoreCount,rountCount;
    boolean activePlayer;

    // p1 -> 0
    // p2 -> 1
    // empty ->2
    int [] gameState ={2,2,2,2,2,2,2,2,2};

    int [][] winningPosition = {
            {0,1,2},{3,4,5},{6,7,8} , //rows
            {0,3,6},{1,4,7},{2,5,8}, //columns
            {0,4,8},{2,4,6} //cross
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore =(TextView) findViewById(R.id.playerOneScore);
        playerTwoScore =(TextView) findViewById(R.id.playerTwoScore);
        playerStatus = (TextView) findViewById(R.id.playerStatus);

        resetGame =(Button) findViewById(R.id.resetGame);

        for (int i =0;i< buttons.length;i++)
        {
            String buttonID ="btn"+i;
            int resourceID = getResources().getIdentifier(buttonID,"id",getPackageName());
            buttons[i] =(Button) findViewById(resourceID);
            buttons[i].setOnClickListener( this);
        }
        rountCount =0;
        playerOneScoreCount =0;
        playerTwoScoreCount=0;
        activePlayer =true;

    }

    @Override
    public void onClick(View v) {

        if(!((Button)v).getText().toString().equals(" ")) {
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId()); //btn2
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length())); //2

        if(activePlayer)
        {
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.parseColor("#FFC34A"));
            gameState[gameStatePointer]=0;
        }
        else
        {
            ((Button)v).setText("O");
            ((Button)v).setTextColor(Color.parseColor("#70FFEA"));
            gameState[gameStatePointer]=1;

        }
        rountCount++;
        if(checkWinner()){
            if(activePlayer){
                playerOneScoreCount++;
                updatePlayerScore();
                Toast.makeText(this, "Player One Won!", Toast.LENGTH_SHORT).show();
            }else{
                playerTwoScoreCount++;
                updatePlayerScore();
                Toast.makeText(this, "Player One Won! ", Toast.LENGTH_SHORT).show();
                playAgain();
            }

        }
        else if (rountCount ==9){
            playAgain();
            Toast.makeText(this, "No Winner!", Toast.LENGTH_SHORT).show();

        }
        else {
            activePlayer=! activePlayer;
        }
        if(playerOneScoreCount > playerTwoScoreCount){
            playerStatus.setText("Player One is Winning ");
        } else if(playerTwoScoreCount > playerOneScoreCount) {
            playerStatus.setText("Player Two is winning ");
        }else
        {
            playerStatus.setText("");
        }

        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain();
                playerOneScoreCount = 0;
                playerTwoScoreCount = 0;
                playerStatus.setText("");
                updatePlayerScore();
            }
        });

    }
    public boolean checkWinner(){
        boolean winnerResult = false;

        for (int [] winnigPosition:winningPosition){
            if(gameState[winnigPosition[0]] == gameState[winnigPosition[1]] &&
                    gameState[winnigPosition[1]] == gameState[winnigPosition[2]] &&
            gameState[winnigPosition[0]] !=2){
                winnerResult = true;

            }
        }
      return  winnerResult;

    }

    public void updatePlayerScore(){

        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }
    public void playAgain(){

        rountCount =0;
        activePlayer = true;

        for(int i =0;i < buttons.length ;i++){
            gameState[i]=2;
            buttons[i].setText("");

        }
    }
}
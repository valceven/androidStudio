package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class tictac extends AppCompatActivity {

        Button[][] btn;
        TableLayout background;
        final int[] COLOR = {Color.RED , Color.BLUE};
        boolean playerTurn = true;
        public String textMessage = "Player O's turn";
        TextView playerTv;
        Button reset;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tictac);

            background = findViewById(R.id.backGround);
            playerTv = findViewById(R.id.textView);
            playerTv.setText(textMessage);


            btn= new Button[][]{
                    {findViewById(R.id.button11), findViewById(R.id.button12), findViewById(R.id.button13)},
                    {findViewById(R.id.button21), findViewById(R.id.button22), findViewById(R.id.button23)},
                    {findViewById(R.id.button31), findViewById(R.id.button32), findViewById(R.id.button33)}
            };

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int  col = j;
                    int  row = i;
                    btn[row][col].setOnClickListener(view -> {
                        if(btn[row][col].getText().toString().equals("")) {
                            if (playerTurn) {
                                btn[row][col].setText("0");
                                playerTurn = !playerTurn;
                                background.setBackgroundColor(COLOR[0]);
                                textMessage = "Player X's turn";
                                playerTv.setText(textMessage);
                            } else {
                                btn[row][col].setText("X");
                                playerTurn = !playerTurn;
                                background.setBackgroundColor(COLOR[1]);
                                textMessage = "Player 0's turn";
                                playerTv.setText(textMessage);
                            }
                            if((btn[0][0].getText().equals("0") && btn[1][1].getText().equals("0") && btn[2][2].getText().equals("0") )||
                                    (btn[0][0].getText().equals("0") && btn[0][1].getText().equals("0") && btn[0][2].getText().equals("0")) ||
                                    (btn[1][0].getText().equals("0") && btn[1][1].getText().equals("0") && btn[1][2].getText().equals("0"))
                            ){
                                Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
                                for(int k = 0; k < 3; k++){
                                    for(int l = 0; l < 3; l++){
                                        btn[k][l].setText("");
                                        playerTurn = true;
                                        textMessage = "Player O's turn";
                                        background.setBackgroundColor(COLOR[1]);
                                    }
                                }
                            }
                            if((btn[0][0].getText().equals("X") && btn[1][1].getText().equals("X") && btn[2][2].getText().equals("X") )||
                                    (btn[0][0].getText().equals("X") && btn[0][1].getText().equals("X") && btn[0][2].getText().equals("X")) ||
                                    (btn[2][0].getText().equals("X") && btn[2][1].getText().equals("X") && btn[2][2].getText().equals("X")) ||
                                    (btn[0][2].getText().equals("X") && btn[0][1].getText().equals("X") && btn[0][0].getText().equals("X")) ||
                                    (btn[1][0].getText().equals("X") && btn[1][1].getText().equals("X") && btn[1][2].getText().equals("X"))
                            ){
                                Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
                                for(int k = 0; k < 3; k++){
                                    for(int l = 0; l < 3; l++){
                                        btn[k][l].setText("");
                                        playerTurn = true;
                                        textMessage = "Player 0's turn";
                                        background.setBackgroundColor(COLOR[1]);
                                    }
                                }
                            }

                        }
                    });

                }
            }

            reset = (Button) findViewById(R.id.result);
            reset.setOnClickListener(view -> {
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        int  col = j;
                        int  row = i;
                        btn[row][col].setText("");
                        playerTurn = true;
                        textMessage = "Player 0's turn";
                        background.setBackgroundColor(COLOR[1]);
                    }
                }
            });

        }
    }
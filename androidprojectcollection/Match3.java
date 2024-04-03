package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Match3 extends AppCompatActivity {

    int[] COLOR = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,};

    Button btn[][] = new Button[5][5];

   Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                String res = "btn" + row + col;
                int resId = getResources().getIdentifier(res, "id", this.getPackageName());
                btn[row][col] = findViewById(resId);
            }
        }
        randomize();



        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int finalI = i;
                int finalJ = j;
                btn[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleButtonClick(finalI, finalJ);
                    }
                });
            }
        }

        Button reset = (Button) findViewById(R.id.btnReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomize();
            }
        });
    }

    private void randomize(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int temp = rand.nextInt(4);
                btn[i][j].setBackgroundColor(COLOR[temp]);
            }
        }
    }
    private Button selectedButton = null;
    private void handleButtonClick(int row, int col) {
        if (selectedButton == null) {
            selectedButton = btn[row][col];
            return;
        }
        if(btn[row - 1][col] == selectedButton || btn[row + 1][col] == selectedButton ||
                btn[row][col + 1] == selectedButton || btn[row][col - 1] == selectedButton){
            swapColors(selectedButton, btn[row][col]);
        }
        selectedButton = null;
    }

    private void swapColors(Button button1, Button button2) {
        Drawable tempColor = button1.getBackground();
        Drawable tempColor2 = button2.getBackground();
        int temp1 = Integer.parseInt(String.valueOf(tempColor));
        int temp2 = Integer.parseInt(String.valueOf(tempColor2));
        button1.setBackgroundColor(temp1);
        button2.setBackgroundColor(temp2);
    }
}
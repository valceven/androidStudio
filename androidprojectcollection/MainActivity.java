package com.example.androidprojectcollection;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,close,calculator,ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayout);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
       MainActivity.this,//this activity
                    LayoutExercise.class); // destination activity
                    startActivity(intent1);
            }
        });

        btn2 = (Button)findViewById(R.id.toastBtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_LONG).show();
            }
        });

        btn3 = (Button)findViewById(R.id.changeBgBtn);
        View actMain = findViewById(R.id.rlVar1);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random bgcolor = new Random();
                actMain.setBackgroundColor(Color.argb(255,bgcolor.nextInt(255),bgcolor.nextInt(255),bgcolor.nextInt(255)));
            }
        });

        btn4 = (Button)findViewById(R.id.changeBtnBgBtn);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random color = new Random();
                btn4.setBackgroundColor(Color.argb(255,color.nextInt(255),color.nextInt(255),color.nextInt(255)));
            }
        });

        btn5 = (Button)findViewById(R.id.disapperBtn);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setVisibility(View.GONE);
            }
        });

        close = (Button)findViewById(R.id.closeBtn);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        MainActivity.this,//this activity
                        closeFinalActivity.class); // destination activity
                startActivity(intent2);
            }
        });

        calculator = (Button)findViewById(R.id.calculatorBtn);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(
                        MainActivity.this,//this activity
                        calculatorActivity.class); // destination activity
                startActivity(intent3);
            }
        });

        ticTacToe = (Button) findViewById(R.id.ticTacToeBtn);
        ticTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(
                        MainActivity.this,//this activity
                        tictac.class); // destination activity
                startActivity(intent4);
            }
        });

        Button match3 = (Button) findViewById(R.id.match3Btn);
        match3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        Match3.class
                );
                startActivity(intent);
            }
        });

    }
}
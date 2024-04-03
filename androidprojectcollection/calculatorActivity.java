package com.example.androidprojectcollection;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Stack;

import com.google.android.material.button.MaterialButton;

public class calculatorActivity extends AppCompatActivity implements View.OnClickListener {
    TextView answerTv, equationTv;
    Stack<String>stack = new Stack<>();
    MaterialButton divBtn,addBtn,multBtn,equalsBtn,subBtn,prcntBtn;
    MaterialButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn00;
    MaterialButton clearBtn,deleteBtn,dcmlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        answerTv = findViewById(R.id.answerTextView);
        equationTv = findViewById(R.id.equationTextView);
        equationTv.setText("");

        assignId(divBtn,R.id.slashButton);
        assignId(addBtn,R.id.additionBtn);
        assignId(subBtn,R.id.subtractionBtn);
        assignId(multBtn,R.id.multiplyBtn);
        assignId(equalsBtn,R.id.equalsBtn);
        assignId(prcntBtn,R.id.percentBtn);
        assignId(btn1,R.id.button1);
        assignId(btn2,R.id.button2);
        assignId(btn3,R.id.button3);
        assignId(btn4,R.id.button4);
        assignId(btn5,R.id.button5);
        assignId(btn6,R.id.button6);
        assignId(btn7,R.id.button7);
        assignId(btn8,R.id.button8);
        assignId(btn9,R.id.button9);
        assignId(btn0,R.id.button0);
        assignId(btn00,R.id.btn00);
        assignId(clearBtn,R.id.clearBtn);
        assignId(deleteBtn,R.id.deleteBtn);
        assignId(dcmlBtn,R.id.decimalBtn);
    }
    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String btnText = button.getText().toString();
        String data = equationTv.getText().toString();
        String tempData = "";

        switch (btnText){
            case "+":
            case "/":
            case "X":
            case "-":
//                if(data.charAt(data.length() - 1))
                break;
            case "=":

            case "DEL":
                if(data.length() > 0){
                    data = "0";
                    break;
                }
            case ".":
                if(data.contains(".")){

                }else{
                    data += btnText;
                }
                break;
            case "C":
                if(data.length() > 0){
                    String newData = data.substring(0, data.length() - 1);
                    data = newData;
                }
                break;

            default :
                if(data.contains("0")){
                    data = btnText;
                }else{
                    data += btnText;
                }

        }

        equationTv.setText(tempData + data);

    }

//    private static boolean isOperator(Char c){
//
//        return (c.equals('-'));
//    }
//
//    public static double evaluateEquation(Stack stack){
//
//        double a = 2;
//
//
//        return ambot;
    //}

}
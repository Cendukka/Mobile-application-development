package com.example.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


public class CalculatorActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    Button add;
    Button sub;
    Button mpy;
    Button div;
    TextView result;
    Button backBut;
    Button nextBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        firstNumber = (EditText) findViewById(R.id.firstNumber);
        secondNumber = (EditText) findViewById(R.id.secondNumber);
        add = (Button)findViewById(R.id.addBut);
        sub = (Button)findViewById(R.id.subBut);
        mpy = (Button)findViewById(R.id.mpyBut);
        div = (Button)findViewById(R.id.divBut);
        result = (TextView)findViewById(R.id.result);
        backBut = (Button)findViewById((R.id.backButton));
        nextBut = (Button)findViewById((R.id.nextButton));

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalculatorActivity.this, StudentLoanCalculatorActivity.class));
            }
        });

    }
    //Make Summary calculation of given numbers
    public void add(View view){
        if(firstNumber.getText().toString() == ""){
            firstNumber.setText("0");
        }
        if(secondNumber.getText().toString() == ""){
            secondNumber.setText("0");
        }
        Integer resultTemp = Integer.parseInt(firstNumber.getText().toString()) + Integer.parseInt(secondNumber.getText().toString());
        result.setText(Integer.toString(resultTemp));
    }
    //Make subtraction calculation of given numbers
    public void sub(View view){
        if(firstNumber.getText().toString() == ""){
            firstNumber.setText("0");
        }
        if(secondNumber.getText().toString() == ""){
            secondNumber.setText("0");
        }
        Integer resultTemp = Integer.parseInt(firstNumber.getText().toString()) - Integer.parseInt(secondNumber.getText().toString());
        result.setText(Integer.toString(resultTemp));
    }
    //Make multiply calculation of given numbers
    public void multiply(View view){
        if(firstNumber.getText().toString() == ""){
            firstNumber.setText("0");
        }
        if(secondNumber.getText().toString() == ""){
            secondNumber.setText("0");
        }
        Integer resultTemp = Integer.parseInt(firstNumber.getText().toString()) * Integer.parseInt(secondNumber.getText().toString());
        result.setText(Integer.toString(resultTemp));
    }
    //Make divide calculation of given numbers
    public void divide(View view){
        if(firstNumber.getText().toString() == ""){
            firstNumber.setText("0");
        }
        if(secondNumber.getText().toString() == ""){
            secondNumber.setText("0");
        }
        Integer resultTemp = Integer.parseInt(firstNumber.getText().toString()) / Integer.parseInt(secondNumber.getText().toString());
        result.setText(Integer.toString(resultTemp));
    }

    public void backToName(View view){

        setContentView(R.layout.activity_main);
    }
}

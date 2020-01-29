package com.example.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.text.TextUtils;


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
        if(TextUtils.isEmpty(firstNumber.getText().toString()) || TextUtils.isEmpty(secondNumber.getText().toString())){
            result.setText("Provide numbers to calculate");
        }else {
            Float resultTemp = Float.parseFloat(firstNumber.getText().toString()) + Float.parseFloat(secondNumber.getText().toString());

            result.setText(Float.toString(resultTemp));
        }
    }
    //Make subtraction calculation of given numbers
    public void sub(View view){
        if(TextUtils.isEmpty(firstNumber.getText().toString()) || TextUtils.isEmpty(secondNumber.getText().toString())){
            result.setText("Provide numbers to calculate");
        }else {
            Float resultTemp = Float.parseFloat(firstNumber.getText().toString()) - Float.parseFloat(secondNumber.getText().toString());
            result.setText(Float.toString(resultTemp));
        }
    }
    //Make multiply calculation of given numbers
    public void multiply(View view){
        if(TextUtils.isEmpty(firstNumber.getText().toString()) || TextUtils.isEmpty(secondNumber.getText().toString())){
            result.setText("Provide numbers to calculate");
        }else {
            Float resultTemp = Float.parseFloat(firstNumber.getText().toString()) * Float.parseFloat(secondNumber.getText().toString());
            result.setText(Float.toString(resultTemp));
        }
    }
    //Make divide calculation of given numbers
    public void divide(View view){
        if(TextUtils.isEmpty(firstNumber.getText().toString()) || TextUtils.isEmpty(secondNumber.getText().toString())){
            result.setText("Provide numbers to calculate");
        }else if(secondNumber.getText().toString().equals("0")){
            result.setText("You can't divide by 0!");
        }else{
            Float resultTemp = Float.parseFloat(firstNumber.getText().toString()) / Float.parseFloat(secondNumber.getText().toString());
            result.setText(Float.toString(resultTemp));
        }
    }

}

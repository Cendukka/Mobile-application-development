package com.example.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class StudentLoanCalculatorActivity extends AppCompatActivity {

    Button backBut;
    EditText loanAmount;
    EditText loanDuration;
    EditText interestRate;
    TextView totalLoan;
    Button calculateLoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_loan_calculator);

        backBut = (Button)findViewById(R.id.backCalc);
        loanAmount = (EditText)findViewById(R.id.amountOfLoan);
        loanDuration = (EditText)findViewById(R.id.durationOfLoan);
        interestRate = (EditText)findViewById(R.id.rateOfInterest);
        totalLoan = (TextView)findViewById(R.id.totalLoan);
        calculateLoan = (Button)findViewById(R.id.calculateBut);



        //Back button gets you to previous activity
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    //calculate the total loan for the given duration of days

    /**
     *
     * @variable loanTemp = Amount of given loan
     * @variable duraTemp = Given duration of given loan
     * @variable interestTemp = given Rate of Interest
     */
    public void calculateLoan(View view){
        alertCalculation();
        if(TextUtils.isEmpty(loanAmount.getText().toString()) || Float.parseFloat(loanAmount.getText().toString()) <= 0){
            totalLoan.setText("Provide positive loan amount to calculate!");
        }else if(TextUtils.isEmpty(loanDuration.getText().toString())|| Float.parseFloat(loanDuration.getText().toString()) < 7){
            totalLoan.setText("Provide loan duration to calculate! Minimum is 7 days!");
        }else if(TextUtils.isEmpty(interestRate.getText().toString()) || Float.parseFloat(interestRate.getText().toString()) < 0){
            totalLoan.setText("Provide positive rate of interest to calculate");
        }else {
            Float loanTemp = Float.parseFloat(loanAmount.getText().toString());
            Float duraTemp = Float.parseFloat(loanDuration.getText().toString());
            Float interestTemp = Float.parseFloat(interestRate.getText().toString()) / 100;

            //set new total loan
            totalLoan.setText(Float.toString((loanTemp * interestTemp / 365 * duraTemp) + loanTemp));
        }
    }
    public void alertCalculation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(StudentLoanCalculatorActivity.this);
        builder.setTitle("You sure?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(StudentLoanCalculatorActivity.this,"Selected Option: YES",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(StudentLoanCalculatorActivity.this,"Selected Option: No",Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();
    }
}

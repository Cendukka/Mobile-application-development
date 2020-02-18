package com.example.samuli_lehtonen_comp304_sec003_lab2_exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{


    EditText loanAmount;
    Spinner loanDurationSpinner;
    RadioGroup interestRate;
    TextView totalLoan;
    Button calculateLoan;
    Float loanDurationFloat,interestTemp;
    String loanDurationStringTemp;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loanAmount = (EditText)findViewById(R.id.amountOfLoan);
        loanDurationSpinner = (Spinner) findViewById(R.id.loanYearSpinner);
        interestRate = (RadioGroup)findViewById(R.id.rateOfInterest);
        totalLoan = (TextView)findViewById(R.id.totalLoan);
        calculateLoan = (Button)findViewById(R.id.calculateBut);
        interestRate = null;

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.years_Array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loanDurationSpinner.setAdapter(adapter);
        loanDurationSpinner.setOnItemSelectedListener(this);



    calculateLoan.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            alertCalculation();
        }
    });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.interestTwo:
                if (checked)
                    interestTemp = 0.02f;
                    break;
            case R.id.interestTwoPointFive:
                if (checked)
                    interestTemp = 0.025f;
                    break;
            case R.id.interestThree:
                if(checked)
                    interestTemp = 0.03f;
                    break;
            default:
                interestTemp = null;
                break;
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        loanDurationStringTemp = parent.getItemAtPosition(position).toString();

        switch(loanDurationStringTemp){
            case "1 year":
                loanDurationFloat = 365.0f;
                break;
            case "2 years":
                loanDurationFloat = 730.0f;
                break;
            case "3 years":
                loanDurationFloat = 1090.0f;
                break;
            case "4 years":
                loanDurationFloat = 1460.0f;
                break;
            case "5 years":
                loanDurationFloat = 1825.0f;
                break;
            default:
                loanDurationFloat = 0.0f;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //calculate the total loan for the given duration of days

    /**
     *
     * @variable loanTemp = Amount of given loan
     * @variable duraTemp = Given duration of given loan
     * @variable interestTemp = given Rate of Interest
     */
    public void calculateLoan(View v){




                if (TextUtils.isEmpty(loanAmount.getText().toString()) || Float.parseFloat(loanAmount.getText().toString()) <= 0) {
                    totalLoan.setText("Provide positive loan amount to calculate!");
                } /*else if (TextUtils.isEmpty(loanDurationSpinner.getPrompt().toString()) || Float.parseFloat(loanDurationSpinner.getPrompt().toString()) < 7) {
                    totalLoan.setText("Provide loan duration to calculate! Minimum is 7 days!");
                } else if (TextUtils.isEmpty(interestRate.getText().toString()) || Float.parseFloat(interestRate.getText().toString()) < 0) {
                    totalLoan.setText("Provide positive rate of interest to calculate");*/
                else if(interestTemp == null){
                    totalLoan.setText("Select interest rate!");
                }
                else {
                    Float loanTemp = Float.parseFloat(loanAmount.getText().toString());
                    Float duraTemp = loanDurationFloat;
                    //Float interestTemp = Float.parseFloat(interestRate.getText().toString()) / 100;

                    //set new total loan
                    String totalLoanString = Float.toString((loanTemp * interestTemp / 365 * duraTemp) + loanTemp);
                    Toast.makeText(MainActivity.this, "Total loan: "+totalLoanString+", Loan amount: "+loanTemp+", Interest rate: "+interestTemp*100+"%", Toast.LENGTH_LONG).show();
                    totalLoan.setText("");
                }

    }
    public void alertCalculation() {



        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("You sure?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        calculateLoan(v);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Selected Option: No",Toast.LENGTH_SHORT).show();


                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();


    }


}

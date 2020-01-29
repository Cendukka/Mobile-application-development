package com.example.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    Button submit;
    TextView wholeName;
    Button nextCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        submit = (Button)findViewById(R.id.submit);
        wholeName = (TextView)findViewById(R.id.wholeName);
        nextCalc = (Button)findViewById(R.id.nextCalc);

        nextCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
            }
        });


    }



    public void submit_clicked(View view) {
        String wholeNameTemp = firstName.getText().toString() + " " + lastName.getText().toString();
        wholeName.setText(wholeNameTemp);
    }
}

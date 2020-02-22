package com.example.samulilehtonen_comp304_003_test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.lang.reflect.Array;


public class BrainActivity extends AppCompatActivity {
    Button nextButton;
    Context context;
    String loseThingsStr;
    String rememberNamesStr;
    String learnThinsStr;
    String keepTrackStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain);
        this.getSupportActionBar().setTitle("Brain Challenge");
        context = getApplicationContext();
        nextButton = (Button)findViewById(R.id.buttonSelectedChallenges);
        //initializing strings
        loseThingsStr="";
        rememberNamesStr="";
        learnThinsStr="";
        keepTrackStr="";


    }

    @Override
    protected void onStart() {
        super.onStart();
        //clear the string
        loseThingsStr = "";
        rememberNamesStr = "";
        learnThinsStr = "";
        keepTrackStr = "";
    }
    //check which buttons are checked
    public void onRadioButtonClicked(View view) {
        // Is the view now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.loseThingsRadio:
                if (checked)
                    loseThingsStr ="Lose Things\n";
                break;
            case R.id.rememberNamesRadio:
                if (checked)
                    rememberNamesStr ="Remember names\n";
                break;
            case R.id.learnThingsRadio:
                if (checked)
                    learnThinsStr ="Learn things quickly\n";
                break;
            case R.id.keepTrackRadio:
                if (checked)
                    keepTrackStr ="Keep track of multiple things\n";

                break;
            default:
                break;
        }
    }
    //show toast
    public void showToast(View view) {


        Toast.makeText(context,loseThingsStr+rememberNamesStr+learnThinsStr+keepTrackStr , Toast.LENGTH_SHORT).show();
    }
}

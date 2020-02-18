package com.example.samuli_lehtonen_secondmidtermpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class VitaminActivity extends AppCompatActivity {
    private Intent intent;

    Context context;

    private int[] checkedStates = new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin);
        context = getApplicationContext();
        for (int o:checkedStates
             ) {
            checkedStates[o] = 0;
            System.out.println(checkedStates[o]);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (int o:checkedStates
        ) {
            checkedStates[o] = 0;
            System.out.println(checkedStates[o]);
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkVitaminA:
                if (checked)
                    checkedStates[0]=1;

                if (!checked)
                    checkedStates[0]=0;
            break;
            case R.id.chkVitaminB:
                if (checked)
                checkedStates[1]=1;
                if (!checked)
                    checkedStates[1]=0;
                break;
            case R.id.chkVitaminC:
                if (checked)
                    checkedStates[2]=1;
                if (!checked)
                    checkedStates[2]=0;
                break;
            case R.id.chkVitaminD:
                if (checked)
                    checkedStates[3]=1;
                if (!checked)
                    checkedStates[3]=0;
                break;
            default:
                break;
        }
    }
    //
    //handling image button
    public void showChartActivity(View v)
    {
        if(!nothingSelected(checkedStates)) {
            //put selected items in Extras
            intent = new Intent(this, ChartActivity.class);
            intent.putExtra("checkedStates", checkedStates);
            //
            startActivity(intent);
        }else{
            Toast.makeText(context, "Select atleast one vitamin, please!", Toast.LENGTH_SHORT).show();
        }
    }
    boolean nothingSelected(int[] checkedStatesArr){
        for (int trueOrFalse:checkedStatesArr
             ) {
            if(trueOrFalse == 1){
                return false;
            }
        }
        return true;
    }
}

package com.example.samuli_lehtonen_comp304_sec003_lab02_ex2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AIActivity extends AppCompatActivity {

    TextView lifeCycleAI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);

        lifeCycleAI = (TextView)findViewById(R.id.activityAiLife);
        String onCreateExecute = "onCreate() Executed \n";
        lifeCycleAI.append(onCreateExecute);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String onStartExecute = "onStart() Executed \n";
        lifeCycleAI.append(onStartExecute);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(),"onResume() executed",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

            Toast.makeText(getApplicationContext(),"onDestroy() executed",Toast.LENGTH_SHORT).show();
        }

}

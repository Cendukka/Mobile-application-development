package com.example.samuli_lehtonen_comp304_sec003_lab02_ex2b;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.FragmentManager;

import android.os.Bundle;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String onCreateStep = "onCreate() executed\n";
        FragmentManager fm = getFragmentManager();


        BottomFragment fragment = (BottomFragment)fm.findFragmentById(R.id.bottomFragment);
        fragment.showLifeCycleEvent(onCreateStep);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String onCreateStep = "onStart() executed\n";
        FragmentManager fm = getFragmentManager();


        BottomFragment fragment = (BottomFragment)fm.findFragmentById(R.id.bottomFragment);
        fragment.showLifeCycleEvent(onCreateStep);
    }
}

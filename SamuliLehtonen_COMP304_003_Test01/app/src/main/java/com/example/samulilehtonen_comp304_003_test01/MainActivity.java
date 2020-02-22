package com.example.samulilehtonen_comp304_003_test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    ImageView logo;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //set the logo
        logo = (ImageView) findViewById(R.id.brainChallengeLogo);
        logo.setImageResource(R.drawable.mushroom);
    }

    //go to next activity on clicking "Select exercises" image button
    public void goToBrainActivity(View view) {
        Intent intent = new Intent(this, BrainActivity.class);
        startActivity(intent);
    }
}

package com.example.samuli_lehtonen_comp304_sec003_lab03;


import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Exercise2Activity extends AppCompatActivity {

    Button startButton;
    Button stopButton;
    ImageView earth;
    ImageView moon;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        this.getSupportActionBar().setTitle("Exercise 2");
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startOrbit(R.anim.orbit);
            }
        });
        stopButton = (Button)findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                endOrbit();
            }
        });
        //set the images
        earth = (ImageView) findViewById(R.id.earth);
        earth.setImageResource(R.drawable.earth);
        moon = (ImageView) findViewById(R.id.moon);
        moon.setImageResource(R.drawable.moon);
    }
//start the orbit animation
    private void startOrbit(int animationFile)
    {
        earth.setVisibility(View.VISIBLE);
        moon.setVisibility(View.VISIBLE);
        // Load the appropriate animation
        animation =  AnimationUtils.loadAnimation(this, animationFile);
        animation.setRepeatMode(1);
        animation.setRepeatCount(Animation.INFINITE);
        // Start the animation
        moon.startAnimation(animation);
    }
    //end the orbit animation
    private void endOrbit()
    {
        moon.clearAnimation();
    }
}

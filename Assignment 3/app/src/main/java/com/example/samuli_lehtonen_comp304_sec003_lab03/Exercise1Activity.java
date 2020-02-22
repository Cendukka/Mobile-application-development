package com.example.samuli_lehtonen_comp304_sec003_lab03;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class Exercise1Activity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;
    Button startButton;
    Button endButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        this.getSupportActionBar().setTitle("Exercise 1");
        // Handle Start Button
        startButton = (Button) findViewById(R.id.ButtonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startAnimation();
            }
        });

        // Handle Stop Button
        endButton = (Button) findViewById(R.id.ButtonStop);
        endButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                stopAnimation();
            }
        });
    }

    //

    private void startAnimation()
    {

        ImageView monkeyImg = (ImageView)findViewById(R.id.ImageView_Monkey);
        //set each frame
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.monkeywalk1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.monkeywalk2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.monkeywalk3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.monkeywalk4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.monkeywalk5);

        //Animate the frames in the imageview
        int frameDuration = 200;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);
        mframeAnimation.addFrame(frame1, frameDuration);
        mframeAnimation.addFrame(frame2, frameDuration);
        mframeAnimation.addFrame(frame3, frameDuration);
        mframeAnimation.addFrame(frame4, frameDuration);
        mframeAnimation.addFrame(frame5, frameDuration);

        monkeyImg.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }

}

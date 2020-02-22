package com.example.samuli_lehtonen_comp304_sec003_lab03;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.Paint;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageButton upButton;
    ImageButton downButton;
    ImageButton rightButton;
    ImageButton leftButton;
    Button clearCanvas;
    TextView penYPositionText;
    Spinner penThickness;
    RadioButton redRadio;
    RadioButton yellowRadio;
    RadioButton cyanRadio;
    ImageView drawingCanvas;


    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    Path penPath;
    Integer penCurrX;
    Integer penCurrY;
    Integer penStartX;
    Integer penStartY;
    Integer penThicknessSize;
    String penYpositionString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);
        this.getSupportActionBar().setTitle("Exercise 3");
        //connect views to variables
        upButton = (ImageButton)findViewById(R.id.upButton);

        downButton = (ImageButton)findViewById(R.id.downButton);
        rightButton = (ImageButton)findViewById(R.id.rightButton);
        leftButton = (ImageButton)findViewById(R.id.leftButton);
        clearCanvas = (Button)findViewById(R.id.clearCanvasButton);

        penYPositionText = (TextView)findViewById(R.id.penLocationText);
        penThickness = (Spinner) findViewById(R.id.penThicknessSpinner);
        redRadio = (RadioButton) findViewById(R.id.redRadio);
        yellowRadio = (RadioButton) findViewById(R.id.yellowRadio);
        cyanRadio = (RadioButton) findViewById(R.id.cyanRadio);
        drawingCanvas = (ImageView)findViewById(R.id.drawingCanvas);

        ArrayAdapter<CharSequence> spinnerAdapter= ArrayAdapter.createFromResource(this, R.array.penThickneses, android.R.layout.simple_spinner_item);
        penThickness.setAdapter(spinnerAdapter);
        penThickness.setOnItemSelectedListener(this);

        //Set pen position, color and thickness
        penStartX = 50;
        penStartY = 0;
        penCurrX = penStartX;
        penCurrY = penStartY;
        penThicknessSize = 5;
        //setup the canvas
        bitmap = Bitmap.createBitmap( 400,400, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        drawingCanvas.setImageBitmap(bitmap);
        //create paint pen
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(penThicknessSize);
        //create the path
        penPath = new Path();
        penPath.moveTo(penCurrX, penCurrY);

        penYpositionString = penCurrY.toString();
        penYPositionText.setText("Y = "+penYpositionString);

        //listen buttons to draw line
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //check that the pen stays in canvas
                if(penCurrY >=10) {
                    penCurrY -= 10;
                    penPath.lineTo(penCurrX, penCurrY);
                    canvas.drawPath(penPath, paint);
                    penPath.moveTo(penCurrX, penCurrY);
                    penYpositionString = penCurrY.toString();
                    penYPositionText.setText("Y = " + penYpositionString);
                }

            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //check that the pen stays in canvas
                if(penCurrY<canvas.getHeight()) {
                    penCurrY += 10;
                    penPath.lineTo(penCurrX, penCurrY);
                    canvas.drawPath(penPath, paint);
                    penPath.moveTo(penCurrX, penCurrY);
                    penYpositionString = penCurrY.toString();
                    penYPositionText.setText("Y = " + penYpositionString);
                }

            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //check that the pen stays in canvas
                if(penCurrX<canvas.getWidth()) {
                    penCurrX += 10;
                    penPath.lineTo(penCurrX, penCurrY);
                    canvas.drawPath(penPath, paint);
                    penPath.moveTo(penCurrX, penCurrY);
                    penYpositionString = penCurrY.toString();
                    penYPositionText.setText("Y = " + penYpositionString);
                }
            }
        });
        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //check that the pen stays in canvas
                if(penCurrX>=10) {
                    penCurrX -= 10;
                    penPath.lineTo(penCurrX, penCurrY);
                    canvas.drawPath(penPath, paint);
                    penPath.moveTo(penCurrX, penCurrY);
                    penYpositionString = penCurrY.toString();
                    penYPositionText.setText("Y = " + penYpositionString);
                }
            }
        });

        //clear canvas
        clearCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                penPath.reset();
                penStartX = 50;
                penStartY = 0;
                penCurrX = penStartX;
                penCurrY = penStartY;
                penPath.moveTo(penStartX,penStartY);
                canvas.drawColor(Color.WHITE);
            }
        });

    }
    //change the pen thickness
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

        switch (position){
            case 0:
                penThicknessSize = 5;
                paint.setStrokeWidth(penThicknessSize);
                break;
            case 1:
                penThicknessSize = 10;
                paint.setStrokeWidth(penThicknessSize);
                break;
            case 2:
                penThicknessSize = 15;
                paint.setStrokeWidth(penThicknessSize);
                break;
            case 3:
                penThicknessSize = 20;
                paint.setStrokeWidth(penThicknessSize);
                break;
            default:
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //change the color of line
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.redRadio:
                if(checked)
                    paint.setColor(Color.RED);
                break;
            case R.id.yellowRadio:
                if(checked)
                    paint.setColor(Color.YELLOW);
                break;
            case R.id.cyanRadio:
                if(checked)
                    paint.setColor(Color.CYAN);
                break;
            default:
                break;
        }

    }
}

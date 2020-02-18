package com.example.samuli_lehtonen_comp304_sec003_lab02_ex2_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    // Get the Intent that started this activity and extract the string
    Intent intent;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessage2Activity.class);
        EditText editText = (EditText) findViewById(R.id.editText5);
        String messageWholeName = editText.getText().toString();
        message += " "+messageWholeName;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

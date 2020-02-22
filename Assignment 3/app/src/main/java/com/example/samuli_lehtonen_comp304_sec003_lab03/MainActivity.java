package com.example.samuli_lehtonen_comp304_sec003_lab03;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView exercisesListView;
    String[] exercisesArr;
    ArrayAdapter arrayAdapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the list view of exercises
        exercisesListView = (ListView) findViewById(R.id.exerciseListView);
        //add the string array in the string variable
        exercisesArr= getResources().getStringArray(R.array.exercises);
        //create an arrayadapter and add it to the list
        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, exercisesArr);
        exercisesListView.setAdapter(arrayAdapter);
        //add click listener
        exercisesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                selectedAcivity(selectedItem);
            }
        });
    }
    //list item event handler
    public void selectedAcivity(String activity)
    {
        intent=null;
        //open new activity based on the clicked item
        switch (activity)
        {
            case "Exercise 1":
                intent = new Intent(this, Exercise1Activity.class);
                break;
            case "Exercise 2":
                intent = new Intent(this, Exercise2Activity.class);
                break;
            case "Exercise 3":
                intent = new Intent(this, Exercise3Activity.class);
                break;
        }
        startActivity(intent);

    }
}

package com.qdot.quincy.workoutstorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private EditText workoutType;
    private EditText userId;
    private EditText rest;
    private ImageButton nextBtn;
    private EditText workoutSubtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutType = (EditText) findViewById(R.id.workoutType);
        userId = (EditText) findViewById(R.id.userId);
        rest = (EditText) findViewById(R.id.rest);
        nextBtn = (ImageButton) findViewById(R.id.nextBtn);
        workoutSubtype = (EditText) findViewById(R.id.workoutSubtype);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String workoutTypeData = workoutType.getText().toString();
                String userIdData = userId.getText().toString();
                String restData = rest.getText().toString();
                String subtypeData = workoutSubtype.getText().toString();
                Bundle exerciseBundle = new Bundle();
                exerciseBundle.putString("workoutTypeData", workoutTypeData);
                exerciseBundle.putString("userIdData", userIdData);
                exerciseBundle.putString("restData", restData);
                exerciseBundle.putString("subtypeData", subtypeData);

                Intent addExercise = new Intent(MainActivity.this, AddExercise.class);
                startActivity(addExercise, exerciseBundle);
            }
        });




    }
}

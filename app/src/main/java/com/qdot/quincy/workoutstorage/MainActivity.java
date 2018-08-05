package com.qdot.quincy.workoutstorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText workoutType;
    private TextInputEditText userId;
    private TextInputEditText rest;
    private ImageButton nextBtn;
    private TextInputEditText workoutSubtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutType = (TextInputEditText) findViewById(R.id.workoutType);
        userId = (TextInputEditText) findViewById(R.id.userId);
        userId.requestFocus();
        rest = (TextInputEditText) findViewById(R.id.rest);
        nextBtn = (ImageButton) findViewById(R.id.nextBtn);
        workoutSubtype = (TextInputEditText) findViewById(R.id.workoutSubtype);
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
                addExercise.putExtras(exerciseBundle);
                startActivity(addExercise);
            }
        });




    }
}

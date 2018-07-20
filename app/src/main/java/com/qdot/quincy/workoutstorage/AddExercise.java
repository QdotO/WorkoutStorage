package com.qdot.quincy.workoutstorage;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class AddExercise extends AppCompatActivity {

    public EditText exerciseName;
    public EditText reps;
    public EditText sets;
    public FloatingActionButton addExercise;
    public FloatingActionButton done;
    public Workout workout;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        exerciseName = (EditText) findViewById(R.id.exerciseName);
        reps = (EditText) findViewById(R.id.reps);
        sets = (EditText) findViewById(R.id.sets);
        addExercise = (FloatingActionButton) findViewById(R.id.AddExercise);
        done = (FloatingActionButton) findViewById(R.id.done);

        workout = new Workout();
        workout.setType((String) savedInstanceState.get("workoutTypeData"));
        workout.setSubtype((String) savedInstanceState.get("subTypeData"));
        workout.setRest((String) savedInstanceState.get("restData"));
        String userId = (String) savedInstanceState.get("userIdData");
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workout.addExercise(new Exercise(exerciseName.getText().toString(), sets.getText().toString(), reps.getText().toString()));
                exerciseName.setText("");
                sets.setText("");
                reps.setText("");
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

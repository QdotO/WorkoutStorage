package com.qdot.quincy.workoutstorage;


import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class AddExercise extends AppCompatActivity
{

    public EditText exerciseName;
    public EditText reps;
    public EditText sets;
    public FloatingActionButton addExercise;
    public FloatingActionButton done;
    public Workout workout;

    String TAG = "SAVE WORKOUT";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        exerciseName = (EditText) findViewById(R.id.exerciseName);
        reps = (EditText) findViewById(R.id.reps);
        sets = (EditText) findViewById(R.id.sets);
        addExercise = (FloatingActionButton) findViewById(R.id.AddExercise);
        done = (FloatingActionButton) findViewById(R.id.done);

        Bundle bundle = getIntent().getExtras();
        workout = new Workout();
        workout.setType((String) bundle.get("workoutTypeData"));
        workout.setSubtype((String) bundle.get("subTypeData"));
        workout.setRest((String) bundle.get("restData"));
//        Log.d(TAG, "onCreate: workout in onCreate is: " + workout.toJson());
        final String userId = (String) bundle.get("userIdData");
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExercise(new Exercise(exerciseName.getText().toString(), sets.getText().toString(), reps.getText().toString()));
                exerciseName.setText("");
                sets.setText("");
                reps.setText("");
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: workout is: " + workout);
                saveWorkout(userId, workout);
            }
        });

    }

    private void saveExercise(Exercise exercise)
    {
        workout.addExercise(exercise);
    }

    private void saveWorkout(String userId, Workout workout)
    {

        String url = "https://4vf0bog3sd.execute-api.us-east-2.amazonaws.com/prod/StoreWorkout";
//        RequestParams params = new RequestParams();
//        final Gson gson = new Gson();
//        params.put("userId", userId);
//        params.put("workout", workout.toJson().toString());
//        Log.d("SAVE WORKOUT", "onResponse: " + workout.toJson().toString());
        JSONObject payload = new JSONObject();
        try
        {
            payload.put("workout", workout.toJson());
            Log.d(TAG, "saveWorkout: payload " + payload);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, payload, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                Log.d("SAVE WORKOUT", "onResponse: " + response.toString());
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("SAVE WORKOUT", "onErrorResponse: " +  error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);


//        AsyncHttpClient client = new AsyncHttpClient();
//        client.post(url, params, new JsonHttpResponseHandler()
//        {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                gson.fromJson(response.toString(), Workout.class);
//                Snackbar.make(findViewById(R.id.addExerciseLayout), "Workout saved", Snackbar.LENGTH_LONG).show();
//                Log.d("SAVE WORKOUT", "onResponse: " + response.toString());
//                finish();
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse)
//            {
//                Log.d("SAVE WORKOUT", "onFailure: " + errorResponse.toString());
//                Snackbar.make(findViewById(R.id.addExerciseLayout), "Error saving Workout", Snackbar.LENGTH_LONG).show();
//            }
//
//        });

    }

}

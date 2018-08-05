package com.qdot.quincy.workoutstorage;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by Quincy on 7/20/18.
 */

public class Workout {
    public String type;
    public String subtype;
    public String rest;
    public String userId;
    public ArrayList<Exercise> exerciseArrayList;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public ArrayList<Exercise> getExerciseArrayList() {
        return exerciseArrayList;
    }

    public void addExercise(Exercise exercise) {
        if(this.exerciseArrayList == null){
            this.exerciseArrayList = new ArrayList<>();
        }
        this.exerciseArrayList.add(exercise);
    }


    public void setExerciseArrayList(ArrayList<Exercise> exerciseArrayList) {
        this.exerciseArrayList = exerciseArrayList;
    }

    public JsonObject toJson()
    {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonObject.addProperty("userId", getUserId());
        jsonObject.addProperty("type", getType());
        jsonObject.addProperty("subType", getSubtype());
        jsonObject.addProperty("rest", getRest());
        for (Exercise ex : getExerciseArrayList())
        {
            jsonArray.add(ex.toJson());
        }
        jsonObject.add("exercises",jsonArray);


        Log.d("Workout.toJSON", "toJson: " + jsonObject.toString());
        return jsonObject;
    }

}

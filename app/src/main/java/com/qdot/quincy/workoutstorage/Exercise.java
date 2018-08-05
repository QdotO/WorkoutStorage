package com.qdot.quincy.workoutstorage;


import com.google.gson.JsonObject;

/**
 * Created by Quincy on 7/20/18.
 */

public class Exercise {
    public String name,
            sets,
            reps;

    public Exercise(String name, String sets, String reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }


    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", getName());
        jsonObject.addProperty("sets", getSets());
        jsonObject.addProperty("reps", getReps());
        return jsonObject;
    }
}

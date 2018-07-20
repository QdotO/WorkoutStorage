package com.qdot.quincy.workoutstorage;

import java.util.ArrayList;

/**
 * Created by Quincy on 7/20/18.
 */

public class Workout {
    public String type,
            subtype,
            rest;
    public ArrayList<Exercise> exerciseArrayList;

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
        this.exerciseArrayList.add(exercise);
    }


    public void setExerciseArrayList(ArrayList<Exercise> exerciseArrayList) {
        this.exerciseArrayList = exerciseArrayList;
    }


}

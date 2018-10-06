package com.gbcontest.gbcontest.Model;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("average")
    float average;

    public Rating(float average) {
        this.average = average;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}

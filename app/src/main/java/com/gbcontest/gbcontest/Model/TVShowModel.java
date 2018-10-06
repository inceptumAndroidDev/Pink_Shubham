package com.gbcontest.gbcontest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TVShowModel {

    @SerializedName("url")
    String url;

    @SerializedName("name")
    String name;

    @SerializedName("genres")
    ArrayList<String> geners;

    @SerializedName("summary")
    String summary;

    @SerializedName("rating")
    Rating rating;

    @SerializedName("image")
    ImageRes imagePic;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getGeners() {
        return geners;
    }

    public void setGeners(ArrayList<String> geners) {
        this.geners = geners;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public ImageRes getImagePic() {
        return imagePic;
    }

    public void setImagePic(ImageRes imagePic) {
        this.imagePic = imagePic;
    }
}



package com.gbcontest.gbcontest.Model;

import com.google.gson.annotations.SerializedName;

public class ImageRes {
    @SerializedName("medium")
    String url;

    public ImageRes(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.gbcontest.gbcontest.Api;

import com.gbcontest.gbcontest.Model.TVShowModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("shows")
    Call<ArrayList<TVShowModel>> getTVShows();

}

package com.gbcontest.gbcontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gbcontest.gbcontest.Adapters.TVListAdapter;
import com.gbcontest.gbcontest.Api.ApiClient;
import com.gbcontest.gbcontest.Api.ApiInterface;
import com.gbcontest.gbcontest.Model.TVShowModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVActivity extends AppCompatActivity {

    private ApiInterface apiService;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        recyclerView = findViewById(R.id.movie_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiService = ApiClient.getClient().create(ApiInterface.class);

        getTVList();
    }


    private void getTVList() {

        Call<ArrayList<TVShowModel>> call = apiService.getTVShows();
        call.enqueue(new Callback<ArrayList<TVShowModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TVShowModel>> call, Response<ArrayList<TVShowModel>> response) {
                ArrayList<TVShowModel> tvList = response.body();
                recyclerView.setAdapter(new TVListAdapter(tvList, getApplicationContext()));

                Log.d("Success", "Number of HashtagModels received: " + response.body().size());
            }

            @Override
            public void onFailure(Call<ArrayList<TVShowModel>> call, Throwable t) {
                // Log error here since request failed
                Log.e("Failure", call.request().url() + "");
            }
        });
    }
}

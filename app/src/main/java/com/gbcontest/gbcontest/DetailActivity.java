package com.gbcontest.gbcontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imphoto;
    private TextView tvsummary;
    private TextView tvname;
    private TextView tvDetail;
    private TextView tvGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String photo = intent.getStringExtra("photo");
        String name = intent.getStringExtra("name");
        String summary = intent.getStringExtra("summary");
        String genre = intent.getStringExtra("genre");


        imphoto = findViewById(R.id.event_imageview);
        tvsummary = findViewById(R.id.event_summary_view);
        tvname = findViewById(R.id.event_title_view);
        tvDetail = findViewById(R.id.event_descrpition_view);
        tvGenre = findViewById(R.id.event_location_view);

        tvname.setText(name);
        tvDetail.setText(summary);
        tvsummary.setText(summary);
        tvGenre.setText("@" + genre);
        Picasso.with(getApplicationContext()).load(photo).into(imphoto);
    }
}

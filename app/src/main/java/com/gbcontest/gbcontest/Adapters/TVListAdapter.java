package com.gbcontest.gbcontest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gbcontest.gbcontest.DetailActivity;
import com.gbcontest.gbcontest.Model.TVShowModel;
import com.gbcontest.gbcontest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TVListAdapter extends RecyclerView.Adapter<TVListAdapter.TagViewHolder> {

    private ArrayList<TVShowModel> shows;
    private Context context;


    public TVListAdapter(ArrayList<TVShowModel> tags, Context context) {
        this.shows = tags;
        this.context = context;
    }

    @Override
    public TVListAdapter.TagViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tvitem_row_layout, parent, false);
        return new TagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("name", shows.get(position).getName() + "");
                i.putExtra("summary", shows.get(position).getSummary() + "");
                i.putExtra("genre", shows.get(position).getGeners().get(0) + shows.get(position).getGeners().get(1) + "");
                i.putExtra("photo", shows.get(position).getImagePic().getUrl());
                context.startActivity(i);
            }
        });

        holder.movieTitle.setText(shows.get(position).getName() + "");
        holder.genre.setText(shows.get(position).getGeners().get(0) + " " + shows.get(position).getGeners().get(1) + "");
        holder.summary.setText(shows.get(position).getSummary() + "");
        holder.rating.setText(shows.get(position).getRating().getAverage() + " " + "Stars");
        Picasso.with(context).load(shows.get(position).getImagePic().getUrl()).into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public static class TagViewHolder extends RecyclerView.ViewHolder {

        private final CardView cardView;
        private final TextView movieTitle;
        private final TextView genre;
        private final TextView summary;
        private final TextView rating;
        private final ImageView pic;

        public TagViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.event_card);
            movieTitle = v.findViewById(R.id.movie_name);
            genre = v.findViewById(R.id.genre_view);
            pic = v.findViewById(R.id.evt_picture_view);
            rating = v.findViewById(R.id.rating);
            summary = v.findViewById(R.id.evt_summary_view);

        }
    }
}
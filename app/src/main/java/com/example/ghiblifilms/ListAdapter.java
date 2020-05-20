package com.example.ghiblifilms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Film> list;
    private FilmsActivity filmsActivity;

    ListAdapter(ArrayList<Film> list, FilmsActivity FIlmsActivity) {
        this.list = list;
        this.filmsActivity = FIlmsActivity;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        ViewHolder(View v) {
            super(v);
            img = v.findViewById(R.id.filmPoster);
            txt = v.findViewById(R.id.filmTitle);
        }
    }

    public void add(int position, Film item) {
        list.add(position, item);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Film currentFilm = list.get(position);
        String uri = "@drawable/" + currentFilm.getTitle().toLowerCase().replace(" ", "_").replace("'", "_");
        int imageResource = filmsActivity.getResources().getIdentifier(uri, null, filmsActivity.getPackageName());
        holder.img.setImageResource(imageResource);
        holder.txt.setText(currentFilm.getTitle());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filmsActivity.navigateToDetail();
            }
        });
        //TODO holder.txt.setOnClicker(new OnClickListener(){__activer une chek box__})
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

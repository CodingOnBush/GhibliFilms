package com.example.ghiblifilms;

import android.content.Context;
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
    private Context context;

    ListAdapter(ArrayList<Film> list, Context context) {
        this.list = list;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
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
        String uri = "@drawable/"+currentFilm.getTitle().toLowerCase().replace(" ","_").replace("'","_");
        int imageResource = context.getResources().getIdentifier(uri, null,context.getPackageName());
        holder.img.setImageResource(imageResource);
        holder.txt.setText(currentFilm.getTitle());
        //TODO holder.txt.setOnClicker(new OnClickListener(){__activer une chek box__})
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

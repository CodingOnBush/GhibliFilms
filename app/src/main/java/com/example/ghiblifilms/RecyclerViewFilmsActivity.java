package com.example.ghiblifilms;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFilmsActivity extends Activity {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Film> filmArrayList;
    private RecyclerViewFilmsController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO add checkbox
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_films);
        filmArrayList = new ArrayList<Film>();
        controller = new RecyclerViewFilmsController(this, filmArrayList);
        controller.onStart();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void showFilmList(ArrayList<Film> filmArrayList){
        recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);// Pour augmenter un petit peu les perf
        layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ListAdapter(filmArrayList, this, controller);
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

}

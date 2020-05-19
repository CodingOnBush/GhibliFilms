package com.example.ghiblifilms;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewFilmsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO add checkbox
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_films);

        RecyclerViewFilmsController controller = new RecyclerViewFilmsController(this);
        controller.onStart();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void showFilmList(ArrayList<Film> filmArrayList){
        RecyclerView mRecyclerView = this.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false);
        //TODO créer l'adapter
    }
}

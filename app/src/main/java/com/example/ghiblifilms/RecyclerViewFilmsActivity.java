package com.example.ghiblifilms;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;


public class RecyclerViewFilmsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO add checkbox
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_films);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
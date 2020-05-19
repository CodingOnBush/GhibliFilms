package com.example.ghiblifilms;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        ImageView totoro = findViewById(R.id.totoro);
        totoro.setImageResource(R.drawable.totoro_logo);
    }
}

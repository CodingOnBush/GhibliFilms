package com.example.ghiblifilms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        Button button_welcome = this.findViewById(R.id.welcome_button);
        button_welcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                navigateToRecyclerviewFilms();
            }
        });
    }

    public void navigateToRecyclerviewFilms(){
        Intent intent = new Intent(this, RecyclerviewFilms.class);
        this.startActivity(intent);
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}

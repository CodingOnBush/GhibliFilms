package com.example.ghiblifilms;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class WelcomeController {
    private WelcomeActivity welcomeActivity;

    public WelcomeController(WelcomeActivity welcomeActivity) {
        this.welcomeActivity = welcomeActivity;
    }

    public void onStart(){
        Button button_welcome = welcomeActivity.findViewById(R.id.welcome_button);
        button_welcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                navigateToRecyclerviewFilms();
            }
        });
    }

    public void navigateToRecyclerviewFilms(){
        Intent intent = new Intent(welcomeActivity, RecyclerViewFilmsActivity.class);
        welcomeActivity.startActivity(intent);
        welcomeActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        //TODO Ajouter une animation pour revenir en arrière avec un swipe
    }

}

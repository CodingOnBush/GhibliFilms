package com.example.ghiblifilms;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

class WelcomeController {
    private WelcomeActivity welcomeActivity;

    WelcomeController(WelcomeActivity welcomeActivity) {
        this.welcomeActivity = welcomeActivity;
    }

    void onStart(){
        Button button_welcome = welcomeActivity.findViewById(R.id.welcome_button);
        button_welcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                navigateToRecyclerviewFilms();
            }
        });
    }

    private void navigateToRecyclerviewFilms(){
        Intent intent = new Intent(welcomeActivity, RecyclerViewFilmsActivity.class);
        welcomeActivity.startActivity(intent);
        welcomeActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        //TODO Ajouter une animation pour revenir en arrière avec un swipe
    }

}

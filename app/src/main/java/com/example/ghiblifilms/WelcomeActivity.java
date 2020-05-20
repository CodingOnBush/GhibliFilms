package com.example.ghiblifilms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button button_welcome = (Button) findViewById(R.id.welcome_button);
        button_welcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!isNetworkAvailable()){
                    Toast.makeText(getApplicationContext(), "You need a first connection to get API text", Toast.LENGTH_LONG).show();
                }else{
                    navigateToRecyclerviewFilms();
                }
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void navigateToRecyclerviewFilms(){
        Intent intent = new Intent(this, FilmsActivity.class);
        this.startActivity(intent);
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        //TODO Ajouter une animation pour revenir en arrière avec un swipe
    }
}

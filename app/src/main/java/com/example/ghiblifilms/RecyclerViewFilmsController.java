package com.example.ghiblifilms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RecyclerViewFilmsController {
    private FilmsActivity view;
    private ArrayList<Film> filmArrayList;
    private Gson gson;

    RecyclerViewFilmsController(FilmsActivity view, ArrayList<Film> filmArrayList) {
        this.view = view;
        this.filmArrayList = filmArrayList;
    }

    void onStart(){
        gson = new GsonBuilder()
                .setLenient()
                .create();

        makeApiCall();
    }

    private void makeApiCall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GhibliApi ghibliApi = retrofit.create(GhibliApi.class);

        Call<ArrayList<Film>> call = ghibliApi.getFilm();

        call.enqueue(new Callback<ArrayList<Film>>() {
            @Override
            public void onResponse(Call<ArrayList<Film>> call, Response<ArrayList<Film>> response) {
                if(response.isSuccessful() && response.body() != null){
                    filmArrayList = response.body();
                    view.showFilmList(filmArrayList);
                    System.out.println("Api call SUCCESS");
                    Toast.makeText(view,"SUCCESS", Toast.LENGTH_SHORT).show();
                }else{
                    System.out.println("response is not successful or response.body is null");
                    Toast.makeText(view,"ERROR 1", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Film>> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(view,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void navigateToDetail() {
        Intent intent = new Intent(view, DetailActivity.class);
        view.startActivity(intent);
        view.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void saveCurrentFilm(Film currentFilm) {
        String jsonString = gson.toJson(currentFilm);

        SharedPreferences settings = view.getSharedPreferences("CURFILM", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove("currentFilm");
        editor.putString("currentFilm", currentFilm.getTitle());
        editor.apply();
    }
}

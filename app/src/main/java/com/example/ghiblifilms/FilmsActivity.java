package com.example.ghiblifilms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.r0adkll.slidr.Slidr;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FilmsActivity extends Activity {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO add checkbox
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_films);

        Slidr.attach(this);

        ApiFilmsResponse allFilms = new ApiFilmsResponse();
        ArrayList<Film> arrayList = new ArrayList<Film>();

        sharedPreferences = getSharedPreferences("saveFilms", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();

        arrayList = getDataFromCache();

        if(getDataFromCache() != null){
            showFilmList(arrayList);
        }else{
            makeApiCall();
        }
    }

    public ArrayList<Film> getDataFromCache() {
        String jsonFilms = sharedPreferences.getString("jsonFilmList", null);
        //retourne null si il n'y a rien dans jsonFilmList

        if(jsonFilms == null){
            return null;
        }else {
            Type listType = new TypeToken<ArrayList<Film>>(){}.getType();
            // On déserialise la liste
            return gson.fromJson(jsonFilms, listType);
        }
    }


    public void showFilmList(ArrayList<Film> filmArrayList) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);// Pour augmenter un petit peu les perf
        layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);


        listAdapter = new ListAdapter(filmArrayList, this);
        recyclerView.setAdapter(listAdapter);

    }

    private void makeApiCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GhibliApi ghibliApi = retrofit.create(GhibliApi.class);

        Call<ArrayList<Film>> call = ghibliApi.getFilm();

        call.enqueue(new Callback<ArrayList<Film>>() {
            @Override
            public void onResponse(Call<ArrayList<Film>> call, Response<ArrayList<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Film> filmsResponse = response.body();
                    saveList(filmsResponse);
                    showFilmList(filmsResponse);
                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR 1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Film>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR :" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveList(ArrayList<Film> filmArrayList) {
        String jsonString = gson.toJson(filmArrayList);

        sharedPreferences
                .edit()
                .putString("jsonFilmList", jsonString)
                .apply();

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
    }

    public void navigateToDetail() {
        Intent intent = new Intent(this, DetailActivity.class);
        this.startActivity(intent);

        //this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}

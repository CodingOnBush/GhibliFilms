package com.example.ghiblifilms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerViewFilmsController {
    private RecyclerViewFilmsActivity view;
    private ArrayList<Film> filmArrayList;

    public RecyclerViewFilmsController(RecyclerViewFilmsActivity view) {
        this.view = view;
    }

    public void onStart(){
        makeApiCall();
        view.showFilmList(filmArrayList);
    }

    public void makeApiCall(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GhibliApi ghibliApi = retrofit.create(GhibliApi.class);

        Call<RestGhibliFilmsResponse> call = ghibliApi.getRestGhibliFilmsResponse();
        call.enqueue(new Callback<RestGhibliFilmsResponse>() {
            @Override
            public void onResponse(Call<RestGhibliFilmsResponse> call, Response<RestGhibliFilmsResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    filmArrayList = response.body().films;
                    System.out.println("Api call SUCCESS");
                }else{
                    System.out.println("response is not successful or response.body is null");
                }
            }

            @Override
            public void onFailure(Call<RestGhibliFilmsResponse> call, Throwable t) {
                System.out.println("Api call failed");
            }
        });
    }
}

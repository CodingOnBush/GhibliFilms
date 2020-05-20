package com.example.ghiblifilms;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {
    @GET("/films")

    Call<ArrayList<Film>> getFilm();
}

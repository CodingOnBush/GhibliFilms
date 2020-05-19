package com.example.ghiblifilms;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {
    @GET("/films")
    Call<RestGhibliFilmsResponse> getRestGhibliFilmsResponse();
}

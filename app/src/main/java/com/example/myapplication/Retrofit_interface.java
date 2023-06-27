package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
//api 설정
public interface Retrofit_interface {
    @GET("posts/{UserID}")
    Call<data_model> test_api_get(
            @Path("UserID") String userid);
}
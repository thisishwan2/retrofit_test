package com.example.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_client {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";


    //retrofit 클래스로 interface 객체 구현
    public static Retrofit_interface getApiService(){
        return getInstance().create(Retrofit_interface.class);}

    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        /*
        통신 시 JSON 사용과 해당 객체의 파싱을 위해 생성
        개인적으로 <List><객체>> 부분을 불러올 때 이 부분이 없으면
        IllegalArgumentException 이 발생하는 것으로 판단됨.
        */

        return new Retrofit.Builder() //retrofit 객체 생성
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))// JSON 데이터를 Gson 라이브러리로 파싱하고 데이터를 Model에 자동으로 담는 converter
                .build();
    }

}

package com.example.photogallery.api;

import retrofit2.Retrofit;

public class FetchItemTask {
    private static final String BASE_URL = "https://api.flickr.com/";
    private static Retrofit retrofit = null;

//    public static Retrofit getRetrofit() {
//        if (retrofit == null) {
//            Gson gson = new GsonBuilder()
//                    .setLenient()
//                    .create();
//
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build();
//            return retrofit;
//        }
//        return retrofit;
//    }
}
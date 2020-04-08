package com.example.photogallery;

import android.app.Application;

import com.example.photogallery.api.FlickrFetch;
import com.example.photogallery.db.PhotoDB;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static FlickrFetch flickrFetch;
    private Retrofit retrofit;
    private static PhotoDB db;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.flickr.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        flickrFetch = retrofit.create(FlickrFetch.class); //Создаем объект, при помощи которого будем выполнять запросы

        db = PhotoDB.getDatabase(this);
    }

//    public PhotoDB getDb() { return db; }
    public static PhotoDB getDb() {
        return db;
    }
    public static FlickrFetch getApi() {
        return flickrFetch;
    }



}

package com.example.photogallery;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogallery.model.Photo;
import com.example.photogallery.model.PhotosResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoGallery extends AppCompatActivity {

    RecyclerView recyclerView;
//    List<PhotosResponse> photosResponses;
    List<Photo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        photos = new ArrayList<Photo>();

//        photosResponses = new ArrayList<PhotosResponse>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        PhotoAdapter adapter = new PhotoAdapter(photos);
        recyclerView.setAdapter(adapter);



        App.getApi().getRecent().enqueue(new Callback<PhotosResponse>() {
            @Override
            public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                //photosResponses.add(response.body());

                photos.addAll(response.body().getPhotos().getPhoto());

                recyclerView.getAdapter().notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<PhotosResponse> call, Throwable t) {
                Toast.makeText(PhotoGallery.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                Log.i("ERROR", t.toString());
                Log.i("ERROR", t.getStackTrace().toString());
            }
        });

    }
}
package com.example.photogallery.api;

import com.example.photogallery.model.PhotosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface FlickrFetch {
    @GET("services/rest/?method=flickr.photos.getRecent&api_key=f305fb1fdd58b5114ca2efbe2a7851d9&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getRecent();
    @GET("services/rest/?method=flickr.photos.search&api_key=f305fb1fdd58b5114ca2efbe2a7851d9&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getSearchPhotos(@Query("text") String keyWord);

}
package com.example.photogallery;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photogallery.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<Photo> photos;


    public PhotoAdapter(List<Photo> posts) {
        this.photos = posts;
    }

    //photosResponses.get(0).getPhotos().getPhoto();
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item2, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Photo photo = photos.get(position);
        String url = "https://farm" +  photo.getFarm() + ".staticflickr.com/" + photo.getServer() + "/" +
                photo.getId() + "_" + photo.getSecret() + ".jpg";


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            Picasso.get().load(url).into(holder.image);

            Log.i("PHOTO", url);
        } else {

        }

    }

    @Override
    public int getItemCount() {
        if (photos == null)
            return 0;
        return photos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("POS", Integer.toString(getAdapterPosition()));
                    App.getDb().photoDao().insertPhoto(photos.get(getAdapterPosition()));
                }
            });
        }
    }
}
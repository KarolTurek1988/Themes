package com.example.karollo.themes;

import android.app.WallpaperManager;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.karollo.themes.com.example.karollo.themes.entity.Theme;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;

public class UnsplashImage extends AsyncTask<Void, Void, Void> {
    private String photoId;
    private Context context;

    public UnsplashImage(String photoId, Context context) {
        this.photoId = photoId;
        this.context = context;
    }

    private InputStream getBitmapFromURL(String src) {
        HttpURLConnection connection = null;
        try {
            java.net.URL url = new java.net.URL(src);
            connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.i("THEME", this.photoId);
        boolean isUnique = false;
        while (!isUnique){
            List<Theme> themes = null;
            try {
                themes = Theme.find(Theme.class,"pictureId = ?", this.photoId);
            }catch (NullPointerException ex){

            }
            if(themes == null){
                isUnique = true;
            }
        }
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this.context);
        try {
            wallpaperManager.setStream(this.getBitmapFromURL(this.photoId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

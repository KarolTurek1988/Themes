package com.example.karollo.themes;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.karollo.themes.com.example.karollo.themes.entity.Theme;
import com.kc.unsplash.Unsplash;
import com.kc.unsplash.models.Download;
import com.kc.unsplash.models.Photo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String photoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getUnsplashPhoto();
    }

    private void getUnsplashPhoto(){
        getApplicationContext();
        Unsplash unsplash = new Unsplash("cf48d996cc2604fcb8e35014e5a396ecd9dc38e15d591bf82e36e7e325849b9f");
        unsplash.getRandomPhoto(null, null, null, null, null, null, null,
                new Unsplash.OnPhotoLoadedListener() {
                    @Override
                    public void onComplete(Photo photo) {
                        Unsplash unsplash = new Unsplash("cf48d996cc2604fcb8e35014e5a396ecd9dc38e15d591bf82e36e7e325849b9f");
                        unsplash.getPhotoDownloadLink(photo.getId(), new Unsplash.OnLinkLoadedListener() {
                            @Override
                            public void onComplete(Download downloadLink) {
                                UnsplashImage unsplashImage = new UnsplashImage(downloadLink.getUrl(), getApplicationContext());
                                unsplashImage.execute();
                            }

                            @Override
                            public void onError(String error) {

                            }
                        });
                    }

                    @Override
                    public void onError(String error) {
                    }
                });
    }


}

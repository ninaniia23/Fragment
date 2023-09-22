package com.example.fragapp;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DownloadImage extends AsyncTaskLoader<Bitmap[]> {
    private ArrayList<String> imageUrls;

    public DownloadImage(Context context, ArrayList<String> imageUrls) {
        super(context);
        this.imageUrls = imageUrls;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Bitmap[] loadInBackground() {
        Bitmap[] bitmaps = new Bitmap[imageUrls.size()];
        for (int i = 0; i < imageUrls.size(); i++) {
            try {
                URL url = new URL(imageUrls.get(i));
                URLConnection connection = url.openConnection();
                connection.setUseCaches(true);
                InputStream in = url.openStream();
                bitmaps[i] = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmaps;
    }
}
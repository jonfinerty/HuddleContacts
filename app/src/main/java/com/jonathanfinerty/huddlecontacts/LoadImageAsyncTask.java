package com.jonathanfinerty.huddlecontacts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class LoadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;

    public LoadImageAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... args) {
        try {
            return BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

        } catch (Exception e) {
            Log.e("LoadImageAsyncTask", "Error loading image", e);
            return null;
        }
    }

    protected void onPostExecute(Bitmap image) {
        if (image != null) {
            imageView.setImageBitmap(image);
        }
    }
}


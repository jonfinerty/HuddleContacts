package com.jonathanfinerty.huddlecontacts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import java.io.InputStream;

public class LoadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;

    public LoadImageAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... args) {

        int userId = 1425259;

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
            HttpGet httpGet = new HttpGet(args[0]);
            httpGet.setHeader("Authorization", "OAuth2 {'iss':'auth.huddle.dev', 'exp': 1986681600, 'urn:huddle.claims.userid': " + userId + "}");

            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            InputStream inputStream = entity.getContent();

            return BitmapFactory.decodeStream(inputStream);

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


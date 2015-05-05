package com.jonathanfinerty.huddlecontacts;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetFriendsAsyncTask extends AsyncTask<String, Void, List<Contact>> {

    private final ListActivity listActivity;

    public GetFriendsAsyncTask(ListActivity listActivity) {
        this.listActivity = listActivity;
    }

    @Override
    protected List<Contact> doInBackground(String... params) {

        int userId = 1425259;

        DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
        HttpGet httpGet = new HttpGet("https://api.huddle.dev/users/" + userId + "/friends");
        httpGet.setHeader("Accept", "application/vnd.huddle.data+json");
        httpGet.setHeader("Authorization", "OAuth2 {'iss':'auth.huddle.dev', 'exp': 1986681600, 'urn:huddle.claims.userid': " + userId + "}");

        InputStream inputStream = null;
        String result = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            inputStream = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line).append("\n");
            }
            result = sb.toString();

            JSONObject friendsJson = new JSONObject(result);

            JSONArray friends = friendsJson.getJSONArray("users");

            List<Contact> contacts = new ArrayList<>();

            for (int i = 0; i < friends.length(); i++) {
                JSONObject friendJson = friends.getJSONObject(i);
                JSONObject profileJson = friendJson.getJSONObject("profile");

                String name = profileJson.getJSONObject("personal").getString("displayName");

                String jobTitle = "Unknown job title";
                if (profileJson.has("company")) {
                    jobTitle = profileJson.getJSONObject("company").getString("role");
                }

                JSONArray linksArrayJson = friendJson.getJSONArray("links");

                String avatarUri = "https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg";

                for (int j = 0; j < linksArrayJson.length(); j++) {
                    JSONObject linkJson = linksArrayJson.getJSONObject(j);
                    if (linkJson.getString("rel").equals("avatar")) {
                        avatarUri = linkJson.getString("href");
                        break;
                    }
                }

                contacts.add(new Contact(name, jobTitle, avatarUri));
            }

            return contacts;

        } catch (Exception e) {
            Log.e("GetFriendsAsyncTask", "Error ", e);
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<Contact> contacts) {
        listActivity.setContacts(contacts);
    }
}

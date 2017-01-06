package com.ideas.simple.simplisticapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

public class FetchProfilesAsyncTask extends AsyncTask<String, String, JSONObject> {
    private FetchDataFromRemote fetchDataFromRemote;

    public FetchProfilesAsyncTask(FetchDataFromRemote delegate) {
        this.fetchDataFromRemote = delegate;
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        RemoteConnection connection = new RemoteConnection();
        JSONObject jsonObject = connection.fetchJSON();

        Log.d(this.getClass().getName(), String.valueOf(jsonObject));

        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);

        fetchDataFromRemote.onTaskComplete(result);
    }
}

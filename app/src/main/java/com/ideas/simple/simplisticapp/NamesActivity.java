package com.ideas.simple.simplisticapp;

import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class NamesActivity extends AppCompatActivity {
    ListView firstListView;
    List<Profile> profiles = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        firstListView = (ListView) findViewById(R.id.contactsListView);

        FetchProfilesAsyncTask asyncTask = new FetchProfilesAsyncTask(new FetchDataFromRemote() {
            @Override
            public void onTaskComplete(JSONObject response) {
                parseDataFromRemoteServer(response);
            }
        });

        asyncTask.execute();
    }

    private void parseDataFromRemoteServer(JSONObject response) {
        JSONArray data;

        profiles = new ArrayList<>();
        try {
            data = response.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject result = data.getJSONObject(i);
                Log.d(this.getClass().getName(), String.valueOf(result));
                // {"name":"Chisoni Mtingwi","phoneNumber":"0999985805","gender":"Male"}

                Profile currentProfile = new Profile();

                currentProfile.setGender(result.getString("gender"));
                currentProfile.setName(result.getString("name"));
                currentProfile.setPhoneNumber(result.getString("phoneNumber"));

                profiles.add(currentProfile);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        firstListView.setAdapter(new MyListAdapter(NamesActivity.this, profiles));
    }

}

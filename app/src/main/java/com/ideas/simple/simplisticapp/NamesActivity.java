package com.ideas.simple.simplisticapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class NamesActivity extends AppCompatActivity {
    ListView firstListView;

    String[][] contacts = new String[][]{
            {"Chisoni Mtingwi", "0999985805", "Male"},
            {"Edmond Kachale", "0881234717", "male"},
            {"Chisoni Mtingwi", "0999447621", "Male"},
            {"My Lilongwe Friend", "00881234717", "Female"},
            {"Chisoni Mtingwi", "0999985805", "Male"},
            {"Edmond Kachale", "0881234717", "male"},
            {"Chisoni Mtingwi", "0999447621", "Male"},
            {"My Lilongwe Friend", "00881234717", "Female"},
            {"Chisoni Mtingwi", "0999985805", "Male"},
            {"Edmond Kachale", "0881234717", "male"},
            {"Chisoni Mtingwi", "0999447621", "Male"},
            {"My Lilongwe Friend", "00881234717", "Female"},
            {"Chisoni Mtingwi", "0999985805", "Male"},
            {"Edmond Kachale", "0881234717", "male"},
            {"Chisoni Mtingwi", "0999447621", "Male"},
            {"My Lilongwe Friend", "00881234717", "Female"},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        firstListView = (ListView) findViewById(R.id.contactsListView);

        firstListView.setAdapter(new MyListAdapter(getApplicationContext(), contacts));
    }
}

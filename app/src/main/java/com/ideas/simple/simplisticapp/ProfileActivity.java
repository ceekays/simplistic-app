package com.ideas.simple.simplisticapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView profileNameTextView = (TextView) findViewById(R.id.profileNameTextView);
        TextView genderTextView = (TextView) findViewById(R.id.genderTextView);
        TextView phoneNumberTextView = (TextView) findViewById(R.id.phoneNumberTextView);
        TextView positionTextView = (TextView) findViewById(R.id.positionTextView);

        Intent intent = getIntent();

        if (intent != null) {
            String profileName = intent.getStringExtra("profileName");
            String gender = intent.getStringExtra("gender");
            String phoneNumber = intent.getStringExtra("phoneNumber");
            String position = intent.getStringExtra("position");

            phoneNumberTextView.setText(phoneNumber);
            profileNameTextView.setText(profileName);
            genderTextView.setText(gender);
            positionTextView.setText(position);
        }
    }
}

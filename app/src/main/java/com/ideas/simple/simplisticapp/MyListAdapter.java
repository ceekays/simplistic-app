package com.ideas.simple.simplisticapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MyListAdapter extends BaseAdapter {
    Context context;
    List<Profile> contacts;

    public MyListAdapter(Context context, List<Profile> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return this.contacts != null ? this.contacts.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return contacts != null ? contacts.get(position) : null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.contact_details, viewGroup, false);
        }

        final TextView iconTextView = (TextView) view.findViewById(R.id.iconTextView);
        final TextView contactNameTextView = (TextView) view.findViewById(R.id.contactNameTextView);
        final TextView phoneNumberTextView = (TextView) view.findViewById(R.id.phoneNumberTextView);
        final TextView genderTextView = (TextView) view.findViewById(R.id.genderTextView);

        final Profile contact = (Profile) getItem(position);

        iconTextView.setText(Integer.toString(position + 1));
        contactNameTextView.setText(contact.getName());
        phoneNumberTextView.setText(contact.getPhoneNumber());
        genderTextView.setText(contact.getGender());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileActivityIntent = new Intent(context, ProfileActivity.class);

                profileActivityIntent.putExtra("profileName", contactNameTextView.getText());
                profileActivityIntent.putExtra("gender", genderTextView.getText());
                profileActivityIntent.putExtra("phoneNumber", phoneNumberTextView.getText());
                profileActivityIntent.putExtra("position", iconTextView.getText());

                context.startActivity(profileActivityIntent);
            }
        });

        return view;
    }
}

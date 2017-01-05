package com.ideas.simple.simplisticapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by E.Kachale on 11/17/2016.
 */

public class MyListAdapter extends BaseAdapter {
    Context context;
    String[][] contacts;

    public MyListAdapter(Context context, String[][] contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return this.contacts.length;
    }

    @Override
    public Object getItem(int position) {
        return contacts[position];
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

        final String[] contact = (String[]) getItem(position);

        iconTextView.setText(Integer.toString(position + 1));
        contactNameTextView.setText(contact[0]);
        phoneNumberTextView.setText(contact[1]);
        genderTextView.setText(contact[2]);

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

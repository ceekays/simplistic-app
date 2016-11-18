package com.ideas.simple.simplisticapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        TextView iconTextView = (TextView) view.findViewById(R.id.iconTextView);
        final TextView contactNameTextView = (TextView) view.findViewById(R.id.contactNameTextView);
        final TextView phoneNumberTextView = (TextView) view.findViewById(R.id.phoneNumberTextView);
        final TextView genderTextView = (TextView) view.findViewById(R.id.genderTextView);

        String[] contact = (String[]) getItem(position);

        iconTextView.setText(Integer.toString(position + 1));
        contactNameTextView.setText(contact[0]);
        phoneNumberTextView.setText(contact[1]);
        genderTextView.setText(contact[2]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle(R.string.app_name);
                alertDialog.setMessage(String.format("Name:%s, Phone:%s, Gender:%s", contactNameTextView.getText(), phoneNumberTextView.getText(), genderTextView.getText()));
                alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"Done",Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        return view;
    }
}

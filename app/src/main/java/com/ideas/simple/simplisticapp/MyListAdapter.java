package com.ideas.simple.simplisticapp;

import android.content.Context;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bundle_item, parent, false);
        }

        if (null != bundlesList) {
            TextView lblBundleHeader = (TextView) convertView.findViewById(R.id.lblBundleHeader);
            TextView lblBundleDetails = (TextView) convertView.findViewById(R.id.lblBundleDetails);

            PrepaidBundle prepaidBundle = bundlesList[position];
            lblBundleHeader.setText(prepaidBundle.getBundleName());
            lblBundleDetails.setText(prepaidBundle.getBundleDescription());
        }

        return convertView;
    }
}

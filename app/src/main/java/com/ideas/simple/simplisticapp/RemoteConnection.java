package com.ideas.simple.simplisticapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by E.Kachale on 06/01/2017.
 */

public class RemoteConnection {

    JSONObject fetchJSON() {
        URL webServiceURL = null;
        HttpURLConnection connection = null;
        String data = null;
        JSONObject JSONResponse = null;

        try {
            String resourceURL = Config.WEB_SERVICE_BASE_URL + "account-profiles.php";
            webServiceURL = new URL(resourceURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            if (webServiceURL != null) {
                connection = (HttpURLConnection) webServiceURL.openConnection();
                connection.setReadTimeout(1000);
                connection.setConnectTimeout(500);
                connection.setRequestMethod("GET");

                connection.connect();

                InputStream stream = connection.getInputStream();
                data = convertStreamToString(stream);

                try {
                    JSONResponse = new JSONObject(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JSONResponse;
    }

    private String convertStreamToString(InputStream stream) {
        java.util.Scanner s = new Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
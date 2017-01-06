package com.ideas.simple.simplisticapp;

import org.json.JSONObject;

public interface FetchDataFromRemote {
    void onTaskComplete(JSONObject response);
}

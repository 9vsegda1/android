package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.sandwichclub.model.Sandwich;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
//        Log.i("JSONitem", json);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Sandwich temp = gson.fromJson(json, Sandwich.class);
//        Log.i("ITEM", temp.getMainName() + temp.getImage() + temp.getAlsoKnownAs());
        return temp;
    }
}

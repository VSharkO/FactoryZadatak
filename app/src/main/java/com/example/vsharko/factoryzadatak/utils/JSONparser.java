package com.example.vsharko.factoryzadatak.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONparser{

    public JSONArray stringToJSONArray(String string){
        try {
            JSONObject jsonObject = new JSONObject(string);
            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            return jsonArray;
        }catch (JSONException exp){
            return null;
        }
    }
}

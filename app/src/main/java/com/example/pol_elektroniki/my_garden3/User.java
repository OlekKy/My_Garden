package com.example.pol_elektroniki.my_garden3;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class User extends StringRequest {



    private static final String LOGIN_REQUEST_URL = "http://192.168.0.102:8080/userdata";
    private Map<String, String> params;

    public User(int id, Response.Listener<String> listener){

        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", id + "");

    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }


}

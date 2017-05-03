package com.example.pol_elektroniki.my_garden3;


import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class Globals {

    public static int id;
    public static int gold;
    public static int seeds;
    public static TextView textView;
    public static User user ;
    public static Response.Listener<String> listener;
    public static User request(){
        return new User(id, listener);
    }

    public Globals() {
        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");


                    if (success) {

                        String username = jsonResponse.getString("username");
                        Globals.id = jsonResponse.getInt("id");
                        Globals.gold = jsonResponse.getInt("gold");
                        Globals.seeds = jsonResponse.getInt("seeds");


                    } else {
                        //Toast.makeText(getApplicationContext(),"ERROR KURWA", Toast.LENGTH_SHORT).show();
                   /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.class);
                    builder.setMessage("Login Failed")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show(); */
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

  /*  User idRequest = new LoginRequest(id, responseListener );
    RequestQueue queue = Volley.newRequestQueue(User.this);
                queue.add(idRequest);

*/
        user =  new User(id, listener);
    }

}

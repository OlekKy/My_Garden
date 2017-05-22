package com.example.pol_elektroniki.my_garden3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btn_storage;
    Button btn_buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView welcomeMessage = (TextView) findViewById(R.id.welcome_msg);
        final TextView gold_view = (TextView) findViewById(R.id.gold_view);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final Button btn_sell = (Button) findViewById(R.id.btn_sell);


        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        String message = username + " Welcome kurwa w twoim garden " + Globals.id;
        welcomeMessage.setText(message);
        etUsername.setText(username);

        //Globals.gold = jsonResponse.getInt("gold");
        String gold_message = "Your have " + Globals.gold + " gold";
        gold_view.setText(gold_message);

    }
}

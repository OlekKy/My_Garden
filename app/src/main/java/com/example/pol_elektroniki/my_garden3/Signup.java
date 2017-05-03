package com.example.pol_elektroniki.my_garden3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

public class Signup extends AppCompatActivity {

    EditText edit_username;
    EditText edit_email;
    EditText edit_pass;
    Button btn_sign;

    private static final String REGISTER_URL="http://192.168.0.101:8080/";
    private final String USER_AGENT = "Mozilla/5.0";
    String body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edit_username = (EditText) findViewById(R.id.id_username);
        edit_email = (EditText) findViewById(R.id.id_email);
        edit_pass = (EditText) findViewById(R.id.id_pass);
        btn_sign = (Button) findViewById(R.id.btn_signup);
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser() {

        String username = edit_username.getText().toString().trim().toLowerCase();
        String email = edit_email.getText().toString().trim().toLowerCase();
        String password = edit_pass.getText().toString().trim().toLowerCase();
        register(username,email,password);
    }
    private void register (String username,String password,String email){
       // String urlSuffix = "?username=" + username + "&password=" + password + "&email=" + email;
        String urlSuffix = "?username=" + username;
        class RegisterUser extends AsyncTask <String, Void,String>{
        ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(Signup.this,"Please Wait",null, true, true);
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),body, Toast.LENGTH_SHORT).show();
            }



            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferReader = null;
                try {

                    URL url = new URL(REGISTER_URL + s);

                   // URLConnection con = url.openConnection();

                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                    //

                    con.setRequestMethod("POST");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

                    String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(urlParameters);
                    wr.flush();
                    wr.close();

                    int responseCode = con.getResponseCode();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    //

                    /*
                    InputStream in = con.getInputStream();

                    String encoding = con.getContentEncoding();

                    encoding = encoding == null ? "UTF-8" : encoding;

                    body = IOUtils.toString(in, encoding);
                    System.out.println(body);
                    */
                    body = response.toString();
                    return body;
                   // return responseCode;


                } catch (Exception e) {
                   // Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                } finally {
                    Intent i = new Intent(Signup.this, MainActivity.class);
                    startActivity(i);
                    //Toast.makeText(getApplicationContext(),body, Toast.LENGTH_SHORT).show();
                }

            }
        }
        RegisterUser ur=new RegisterUser();
        ur.execute(urlSuffix);
    }
}

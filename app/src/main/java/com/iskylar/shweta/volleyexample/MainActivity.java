package com.iskylar.shweta.volleyexample;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.BASE_URL+Constants.JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("Output Response",response);
                        Toast.makeText(MainActivity.this, "Output from Server - "+response, Toast.LENGTH_SHORT).show();

                        jsonParsing(response);



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Output Errror",error.getMessage());
                Toast.makeText(MainActivity.this, "Error from Server - "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void jsonParsing(String response) {
        JSONObject object = null;
        JSONArray jsonArray = null;
        JSONObject jsonObject= null;
        try {
            object = new JSONObject(response);
            jsonArray = object.getJSONArray("Try");
            Log.e("Array - Result ",jsonArray.toString());

            for(int i=0;i<jsonArray.length();i++){
                jsonObject = jsonArray.getJSONObject(i);
                String longName  = jsonObject.getString("name");
               /* String shortName = jsonObject.getString("short_name");
                String types = jsonObject.getString("types");*/

              //  String result = longName + " " +shortName+ " "+ types;
            //    Log.e("Long Name ",result);

                Log.e("Long Name ",longName);
               /* Log.e("Short Name ",shortName);
                Log.e("Types ",types);*/


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

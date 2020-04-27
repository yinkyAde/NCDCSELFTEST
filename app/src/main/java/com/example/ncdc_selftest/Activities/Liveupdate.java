package com.example.ncdc_selftest.Activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ncdc_selftest.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Liveupdate extends AppCompatActivity {
    private String url = "https://corona.lmao.ninja/v2/countries";
    private TextView Totalconfirmed, TotalDeaths, TotalRecovered, TotalNewCases;
    private Context mContext;
    private Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liveupdate);
        Totalconfirmed = findViewById(R.id.total);
        TotalDeaths = findViewById(R.id.deaths);
        TotalRecovered = findViewById(R.id.discharged);
        TotalNewCases = findViewById(R.id.newcases);
        mContext = getApplicationContext();
        mActivity = Liveupdate.this;
        Toast.makeText(mContext, "Loading....", Toast.LENGTH_LONG).show();

        // Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        // Process the JSON
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject cases = response.getJSONObject(i);

                                // Get the current cases (json object) data
                                String COUNTRY = cases.getString("country");

                                if (COUNTRY.equals("Nigeria")) {
                                    String confrimedC = cases.getString("cases");
                                    String DeathsC = cases.getString("deaths");
                                    String recovered = cases.getString("recovered");
                                    String NewCases = cases.getString("todayCases");

                                    // Display the formatted json data in text view
                                    Totalconfirmed.setText(confrimedC);
                                    TotalDeaths.setText(DeathsC);
                                    TotalRecovered.setText(recovered);
                                    TotalNewCases.setText(NewCases);

                                    Toast.makeText(mContext, "Live Update Successful", Toast.LENGTH_SHORT).show();


                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(mContext, "Error... Please Check Internet Connection", Toast.LENGTH_LONG).show();
                        error.printStackTrace();

                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }

}


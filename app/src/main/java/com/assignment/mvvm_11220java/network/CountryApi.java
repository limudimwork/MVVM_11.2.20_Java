package com.assignment.mvvm_11220java.network;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.assignment.mvvm_11220java.model.Country;

import java.util.List;


public class CountryApi {


    private RequestQueue requestQueue;
    private final static String GET_ALL_COUNTRIES_URL = "https://restcountries.eu/rest/v2/all";
    private List<Country> countryList;

    public CountryApi(Application application) {
        requestQueue = Volley.newRequestQueue(application);
    }

    public List<Country> getCountryList(OnServerResponseListener onServerResponseListener) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, GET_ALL_COUNTRIES_URL,
                null,
                response -> {
                    onServerResponseListener.OnServerResponse(true, response);
                },

                error -> {
                    onServerResponseListener.OnServerResponse(false, null);
                }

        );

        requestQueue.add(jsonArrayRequest);

        return countryList;
    }
}

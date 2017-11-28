package com.asmjahid.djangoretrofit.Api;

import com.asmjahid.djangoretrofit.Model.RetrofitApi;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class RetrofitInterface {

    private String service_url = "https://drf-demo.herokuapp.com";

    public interface GetAllAPI {
        @GET("/api/universities/?format=json")
        List<RetrofitApi> getUniversity();
    }

    public List<RetrofitApi> GetUniversity() {

        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(service_url)
                .setConverter(new GsonConverter(gson))
                .build();

        GetAllAPI service = restAdapter.create(GetAllAPI.class);

        List<RetrofitApi> Universitylist = service.getUniversity();

        return Universitylist;
    }

}
package com.syntex_error.simplegraph_ql_firebase.api;

import com.syntex_error.simplegraph_ql_firebase.models.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public  interface api {
    @Headers("Content-Type: application/json")
    @GET("graphql")
    Call<model> query(@Query("query") String order);
}

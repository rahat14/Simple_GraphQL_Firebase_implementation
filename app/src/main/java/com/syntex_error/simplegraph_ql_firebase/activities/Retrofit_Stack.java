package com.syntex_error.simplegraph_ql_firebase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.syntex_error.simplegraph_ql_firebase.R;
import com.syntex_error.simplegraph_ql_firebase.adapter.RecyclerViewAdapter;
import com.syntex_error.simplegraph_ql_firebase.api.api;
import com.syntex_error.simplegraph_ql_firebase.models.dataModel;
import com.syntex_error.simplegraph_ql_firebase.models.donorModel;
import com.syntex_error.simplegraph_ql_firebase.models.model;


import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Stack extends AppCompatActivity {

    private static final String BASE_URL ="http://192.168.1.214:4000/" ;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(); // i made two different adapter just for learning purposes
        recyclerView.setAdapter(adapter);


        OkHttpClient client = new OkHttpClient.Builder().build();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .client(client )
                .build();


     api service = retrofit.create(api.class);

    String q = "query{\n" +
            "  donors{\n" +
            "    namee\n" +
            "    ph\n" +
            "  }\n" +
            "  \n" +
            "  }" ;


    Call<model> call = service.query(q) ;

    call.enqueue(new Callback<model>() {
        @Override
        public void onResponse(Call<model> call, Response<model> response) {
            if(response.code() == 200)
            {
                model list = response.body();

                dataModel data = list.getData() ;

                List<donorModel> donorModelsl = new ArrayList<>();
                donorModelsl = data.getDonors() ;

                Log.d("TAG", "onResponse: " + donorModelsl.size());

                // pass the adapter
                adapter.setResults(donorModelsl);

                Log.d("TAG", "onResponse: "  +  call.request().url());

            }
            else {

                Log.d("TAG", "onResponse: " + response.code() + " " + response.errorBody().toString()  + response.message().toLowerCase());
            }
            Log.d("TAG", "onResponse: "  +  call.request().url());

        }

        @Override
        public void onFailure(Call<model> call, Throwable t) {
            Log.d("TAG", "onResponse: " + t.getMessage() );
        }
    }) ;



    }
}
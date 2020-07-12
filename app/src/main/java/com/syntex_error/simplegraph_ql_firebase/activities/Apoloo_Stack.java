package com.syntex_error.simplegraph_ql_firebase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;

import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.simplegraph_ql_firebase.AllDonorsQuery;
import com.syntex_error.simplegraph_ql_firebase.R;
import com.syntex_error.simplegraph_ql_firebase.adapter.donorListAdapter;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class Apoloo_Stack extends AppCompatActivity {

    ApolloClient apolloClient ;


    private donorListAdapter adapter;

    private Button searchButton;
    List<AllDonorsQuery.Donor> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoloo__stack);

        RecyclerView recyclerView = findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new donorListAdapter();
        recyclerView.setAdapter(adapter);
//    viewModel = ViewModelProviders.of(this).get(DonorViewModel.class);


        String ur = "http://192.168.1.214:4000/graphql";
        apolloClient = ApolloClient.builder()
                .serverUrl(ur)
                .build();


        apolloClient.query(AllDonorsQuery.builder().build())
                .enqueue(new ApolloCall.Callback<AllDonorsQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull final Response<AllDonorsQuery.Data> dataResponse) {


                                list = dataResponse.getData().donors() ;
//                        for (AllDonorsQuery.Donor feed : dataResponse.data().donors())
//                        {
//                            buffer.append("name:" + feed.namee());
//                            buffer.append(" ph: " + feed.ph());
//                        }


                        // onResponse returns on a background thread. If you want to make UI updates make sure they are done on the Main Thread.

                        Apoloo_Stack.this.runOnUiThread(new Runnable() {
                            public void run() {
                                adapter.setResults(list);
                            }
                        });

                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d("TAG", "run: " + e.getMessage());
                    }
                });


    }


}

package com.syntex_error.simplegraph_ql_firebase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syntex_error.simplegraph_ql_firebase.R;

public class Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);

        findViewById(R.id.apollo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent o = new Intent(getApplicationContext() , Retrofit_Stack.class);
                startActivity(o);
            }
        });

        findViewById(R.id.apollo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent o = new Intent(getApplicationContext() , Apoloo_Stack.class);
                startActivity(o);
            }
        });

    }
}
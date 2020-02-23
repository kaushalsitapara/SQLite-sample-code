package com.example.newone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityNavigationAdmin extends AppCompatActivity {

    private String TAB = "ActivityNavigationAdmin";
    private Button add_ngo;
    private Button add_event;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_admin);

        initComponent();
    }


    private void initComponent() {

        add_ngo = findViewById(R.id.add_ngo);
        add_event = findViewById(R.id.add_event);



        add_ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( ActivityNavigationAdmin.this, AddNGO.class);
                startActivity(intent);



            }
        });


        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( ActivityNavigationAdmin.this, AddEvent.class);
                startActivity(intent);



            }
        });




    }}

package com.example.newone.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.newone.AdapterViewNGO;
import com.example.newone.NGONameModel;
import com.example.newone.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<NGONameModel> ngoNameModelsList = new ArrayList<NGONameModel>();
    Adapter adapter;
    ViewPager viewPager;
    AdapterViewNGO adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        for (int i = 0; i <= 1000; i++) {

            NGONameModel ngoNameModel = new NGONameModel();
            ngoNameModel.setNgoName(String.valueOf(i));
            ngoNameModelsList.add(ngoNameModel);
        }



        Log.e("size", String.valueOf(ngoNameModelsList.size()));

        recyclerView = findViewById(R.id.recycler_view);
       adapterView = new AdapterViewNGO( ngoNameModelsList, HomeActivity.this );
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapterView);


    }
}
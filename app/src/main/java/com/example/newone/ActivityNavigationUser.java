package com.example.newone;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.newone.SQLiteDemo.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class ActivityNavigationUser extends Fragment {
    RecyclerView recyclerView;
    List<NGONameModel> ngoNameModelsList = new ArrayList<NGONameModel>( );
    Adapter adapter;
    ViewPager viewPager;
    AdapterViewNGO adapterView;
    View rootView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    SQLiteDatabase sqLiteDatabaseObj1;
    MySQLiteHelper db ;
    ArrayList<String> words;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate( R.layout.fragment_home, container, false );

        for (int i = 0; i <= 1000; i++) {

            NGONameModel ngoNameModel = new NGONameModel( );
            ngoNameModel.setNgoName( String.valueOf( i ) );
            ngoNameModelsList.add( ngoNameModel );
        }



        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );




    }

}


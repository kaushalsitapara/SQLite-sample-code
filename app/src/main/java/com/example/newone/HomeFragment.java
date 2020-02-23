package com.example.newone;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newone.SQLiteDemo.SQLDataSourceHelper;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    EditText et_name, et_emailid, et_mobile, et_address, et_city, et_state, et_pincode, et_ngotype, et_description;
    Button btn_add;
    SQLDataSourceHelper gcmMessageDataSource;
    RecyclerView mRecyclerView;
    List<NGONameModel> NGONameModelArrayList = new ArrayList<>( );
    AdapterViewNGO adapterView;
    private String TAG = "HomeFragment";
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate( R.layout.fragment_home, container, false );
        Log.e( TAG, "HomeFragment called......" );

        Toast.makeText( getActivity( ), "", Toast.LENGTH_SHORT ).show( );
        gcmMessageDataSource = new SQLDataSourceHelper( getActivity( ) );
        gcmMessageDataSource.open( );

        initComponent( );

        return rootView;
    }

    private void initComponent() {
        mRecyclerView = rootView.findViewById( R.id.recycler_view );
        try {
            NGONameModelArrayList = gcmMessageDataSource.get( "1000" );

            Log.e( TAG, "NGONameModelArrayList.size()  " + NGONameModelArrayList.size( ) );
            Toast.makeText( getActivity( ), String.valueOf( NGONameModelArrayList.size( ) ), Toast.LENGTH_SHORT ).show( );

            adapterView = new AdapterViewNGO( NGONameModelArrayList, getActivity( ) );
            mRecyclerView.setLayoutManager( new LinearLayoutManager( mRecyclerView.getContext( ) ) );
            mRecyclerView.setAdapter( adapterView );

        } catch (Exception e) {
            Log.e( TAG, "Exception.size()  " + e );


        }


    }
}
















 


package com.example.newone.ui.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.newone.R;
import com.example.newone.ui.home.HomeViewModel;

public class AboutusFragment extends Fragment {
    private AboutusViewModel aboutusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutusViewModel =
                ViewModelProviders.of( this ).get( AboutusViewModel.class );
        View root = inflater.inflate( R.layout.fragment_aboutus, container, false );
        // final TextView textView = root.findViewById( R.id.text_home );
        // homeViewModel.getText( ).observe( this, new Observer<String>( ) {
        //   @Override
        // public void onChanged(@Nullable String s) {
        //   textView.setText( s );
        //}
        //} );
        return root;
    }

}

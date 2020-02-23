package com.example.newone.ui.aboutus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutusViewModel() {
        mText = new MutableLiveData<>( );
        mText.setValue( "This is aboutus fragment" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}
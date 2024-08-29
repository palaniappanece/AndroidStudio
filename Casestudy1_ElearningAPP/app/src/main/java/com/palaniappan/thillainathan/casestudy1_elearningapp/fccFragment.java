package com.palaniappan.thillainathan.casestudy1_elearningapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class fccFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fcc,container,false);
        WebView wv1=view.findViewById(R.id.webfcc);
        wv1.loadUrl("https://www.freecodecamp.org/");
        return view;
    }
}
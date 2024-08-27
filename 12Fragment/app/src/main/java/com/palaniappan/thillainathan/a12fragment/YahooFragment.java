package com.palaniappan.thillainathan.a12fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class YahooFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view =inflater.inflate(R.layout.fragment_yahoo,container,false);
    WebView wv2=view.findViewById(R.id.web2);
    wv2.loadUrl("https://www.yahoo.com/");
    return view;
    }

}
package com.inomera.kasap.androidrottentomatoesapp.common.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inomera.kasap.androidrottentomatoesapp.R;

/**
 * Created by Menaf on 03.07.2015
 */
public class MovieFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        return v;
    }
}

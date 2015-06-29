package com.inomera.kasap.androidrottentomatoesapp.common.fragments;

/**
 * Created by Menaf on 17.06.2015
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InTheatersFragment extends BaseFragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return createView(inflater, container, "linear", 3);
    }
}
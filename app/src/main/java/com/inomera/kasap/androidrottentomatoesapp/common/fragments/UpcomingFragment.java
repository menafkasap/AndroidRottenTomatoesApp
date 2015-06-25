package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 17.06.2015
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.MyAdapter;

import java.util.ArrayList;

public class UpcomingFragment extends Fragment {

    private static final int SPAN_COUNT = 2;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_upcoming,container,false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // use a grid layout manager
        mLayoutManager = new GridLayoutManager(getActivity(),SPAN_COUNT);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> input = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        mAdapter = new MyAdapter(input);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.remove("Test1");
        return v;
    }
}
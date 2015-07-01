package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 29.06.2015
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.MyAdapter;
import com.inomera.kasap.androidrottentomatoesapp.network.Movie;
import com.orhanobut.wasp.WaspError;

import java.util.List;

public abstract class BaseFragment extends Fragment {

    protected static final int SPAN_COUNT = 2;
    protected static final String LAYOUT_TYPE_GRID = "grid";
    protected static final String LAYOUT_TYPE_LINEAR = "linear";
    protected RecyclerView mRecyclerView;

    protected abstract String  getLayoutType();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_base, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // use a linear or grid layout manager
        if (getLayoutType() == LAYOUT_TYPE_GRID) {
            GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
            mRecyclerView.setLayoutManager(mLayoutManager);
        } else {
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
        }
        return v;
    }

    protected void setAdapter(List<Movie> movieList) {
        MyAdapter mAdapter = new MyAdapter(movieList, getLayoutType());
        mRecyclerView.setAdapter(mAdapter);
    }

    protected void showToast(WaspError error) {
        Toast toast = Toast.makeText(getActivity(), error.getErrorMessage(), Toast.LENGTH_SHORT);
        toast.show();
    }




}

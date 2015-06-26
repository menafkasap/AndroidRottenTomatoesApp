package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 22.06.2015
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.MyAdapter;
import com.inomera.kasap.androidrottentomatoesapp.network.Movie;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.App;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

public class OpeningFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_opening,container,false);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        getOpening();
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> input = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        MyAdapter mAdapter = new MyAdapter(input);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    private void getOpening() {
        App.getService().getOpening(new CallBack<List<Movie>>() {

            @Override
            public void onSuccess(List<Movie> movies) {
                Toast toast = Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void onError(WaspError error) {
                Toast toast = Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
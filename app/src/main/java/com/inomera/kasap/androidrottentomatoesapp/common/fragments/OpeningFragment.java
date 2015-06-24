package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 22.06.2015
 */
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.MyAdapter;
import com.inomera.kasap.androidrottentomatoesapp.common.WASP.Movie;
import com.inomera.kasap.androidrottentomatoesapp.common.WASP.WaspApplication;
import com.inomera.kasap.androidrottentomatoesapp.common.view.DividerItemDecoration;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

import java.util.ArrayList;
import java.util.List;

public class OpeningFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_opening,container,false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> input = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(input);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.remove("Test1");
        return v;
    }

    private void getOpening() {

        WaspApplication.getService().getOpening("n594qzwyec5cdgr3tdrpfee3", new CallBack<Movie>() {
            private Context applicationContext;

            public Context getApplicationContext() {
                return applicationContext;
            }

            @Override
            public void onSuccess(Movie movie) {
                Toast.makeText(getApplicationContext(), movie.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(WaspError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
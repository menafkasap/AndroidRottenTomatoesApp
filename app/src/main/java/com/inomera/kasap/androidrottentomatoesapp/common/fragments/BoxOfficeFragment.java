package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 17.06.2015
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.App;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.MyAdapter;
import com.inomera.kasap.androidrottentomatoesapp.network.MovieResponse;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

public class BoxOfficeFragment extends BaseFragment {

    private static final int SPAN_COUNT = 2;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_base,container,false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a grid layout manager
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        mRecyclerView.setLayoutManager(mLayoutManager);
        getBoxOffice();
        return v;
    }

    private void getBoxOffice() {
        App.getService().getBoxOffice(new CallBack<MovieResponse>() {

            @Override
            public void onSuccess(MovieResponse movieResponse) {
                MyAdapter mAdapter = new MyAdapter(movieResponse.getMovies());
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onError(WaspError error) {
                Toast toast = Toast.makeText(getActivity(), error.getErrorMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
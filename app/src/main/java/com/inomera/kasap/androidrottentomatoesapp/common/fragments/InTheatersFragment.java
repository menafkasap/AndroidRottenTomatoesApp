package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 17.06.2015
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.App;
import com.inomera.kasap.androidrottentomatoesapp.network.MovieResponse;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

public class InTheatersFragment extends BaseFragment {

    @Override
    protected String getLayoutType() {
        return LAYOUT_TYPE_LINEAR;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getInTheaters();
    }

    private void getInTheaters() {
        App.getService().getInTheaters(new CallBack<MovieResponse>() {

            @Override
            public void onSuccess(MovieResponse movieResponse) {
                setAdapter(movieResponse.getMovies());
            }

            @Override
            public void onError(WaspError error) {
                showToast(error);
            }
        });
    }
}
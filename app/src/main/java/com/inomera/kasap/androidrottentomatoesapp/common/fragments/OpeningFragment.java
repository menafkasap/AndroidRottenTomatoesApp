package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 22.06.2015
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.App;
import com.inomera.kasap.androidrottentomatoesapp.network.models.MovieResponse;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

public class OpeningFragment extends BaseFragment {

    @Override
    protected String getLayoutType() {
        return LAYOUT_TYPE_LINEAR;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getOpening();
    }

    private void getOpening() {
        App.getService().getOpening(new CallBack<MovieResponse>() {

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
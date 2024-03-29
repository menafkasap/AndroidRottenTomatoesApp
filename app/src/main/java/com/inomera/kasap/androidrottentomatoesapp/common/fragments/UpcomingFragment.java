package com.inomera.kasap.androidrottentomatoesapp.common.fragments;
/**
 * Created by Menaf on 17.06.2015
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.App;
import com.inomera.kasap.androidrottentomatoesapp.network.models.MovieResponse;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

public class UpcomingFragment extends BaseFragment {

    @Override
    protected String getLayoutType() {
        return LAYOUT_TYPE_GRID;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getUpcoming();
    }

    private void getUpcoming() {
        App.getService().getUpcoming(new CallBack<MovieResponse>() {

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
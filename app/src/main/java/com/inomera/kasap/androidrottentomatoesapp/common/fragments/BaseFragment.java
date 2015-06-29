package com.inomera.kasap.androidrottentomatoesapp.common.fragments;

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
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.App;
import com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp.MyAdapter;
import com.inomera.kasap.androidrottentomatoesapp.network.Movie;
import com.inomera.kasap.androidrottentomatoesapp.network.MovieResponse;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

import java.util.List;

/**
 * @author Emmar Kardeslik
 */
public abstract class BaseFragment extends Fragment {

    protected static final int SPAN_COUNT = 2;
    protected RecyclerView mRecyclerView;


    public View createView(LayoutInflater inflater, @Nullable ViewGroup container, String layout, int tabNumber) {
        View v = inflater.inflate(R.layout.fragment_base, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear or grid layout manager
        if (layout.equals("grid")) {
            GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
            mRecyclerView.setLayoutManager(mLayoutManager);
        } else {
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
        }

        //call methods by tab number
        if (tabNumber == 1) {
            getBoxOffice();
        } else if (tabNumber == 2) {
            getUpcoming();
        } else if (tabNumber == 3) {
            getInTheaters();
        } else {
            getOpening();
        }
        return v;
    }


    public void setAdapter(List<Movie> movieList) {
        MyAdapter mAdapter = new MyAdapter(movieList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showToast(WaspError error) {
        Toast toast = Toast.makeText(getActivity(), error.getErrorMessage(), Toast.LENGTH_SHORT);
        toast.show();
    }

    private void getBoxOffice() {
        App.getService().getBoxOffice(new CallBack<MovieResponse>() {

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

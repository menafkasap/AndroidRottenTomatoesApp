package com.inomera.kasap.androidrottentomatoesapp.common.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.network.models.Reviews;

/**
 * Created by Menaf on 13.07.2015
 */
public class ReviewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_review, container, false);

        Reviews reviews = getActivity().getIntent().getParcelableExtra("Reviews");
        getActivity().setTitle(getActivity().getIntent().getStringExtra("Title"));

        ListView list = (ListView) v.findViewById(R.id.list_view);

        ((TextView) v.findViewById(R.id.name)).setText(reviews.getCritic() + "/" + reviews.getFreshness());
        ((TextView) v.findViewById(R.id.date)).setText(reviews.getDate() + "/" + reviews.getPublication());
        ((TextView) v.findViewById(R.id.quote)).setText(reviews.getQuote());

        return v;
    }


}

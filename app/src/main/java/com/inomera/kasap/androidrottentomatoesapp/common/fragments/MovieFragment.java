package com.inomera.kasap.androidrottentomatoesapp.common.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.network.models.Movie;
import com.squareup.picasso.Picasso;

/**
 * Created by Menaf on 03.07.2015
 */
public class MovieFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movie, container, false);

        Movie myMovie = getActivity().getIntent().getParcelableExtra("Movie");
        getActivity().setTitle(myMovie.getTitle());

        Picasso.with(v.getContext()).load("http://" + myMovie.getPosters().getOriginal().replaceAll(".*=/...../", "")).resize(650, 960).into((ImageView) v.findViewById(R.id.poster));

        ((TextView) v.findViewById(R.id.rating)).setText("Score: " + myMovie.getRatings().getCriticsScore() + "/100");
        ((TextView) v.findViewById(R.id.mpaaRating)).setText("Mpaa Rating: " + myMovie.getMpaaRating());
        ((TextView) v.findViewById(R.id.consensus)).setText(myMovie.getCriticsConsensus());

        ((TextView) v.findViewById(R.id.synopsis)).setText("Synopsis: " + myMovie.getSynopsis());

        if (myMovie.getAbridgedDirectors() != null)
            ((TextView) v.findViewById(R.id.director)).setText("Director: " + myMovie.getAbridgedDirectors().get(0).getName());

        if (myMovie.getAbridgedCast() != null) {
            String cast = "Cast: \n";
            for (int i = 0; i < myMovie.getAbridgedCast().size(); i++) {
                cast = cast + myMovie.getAbridgedCast().get(i).getName() + "\t";
                if (myMovie.getAbridgedCast().get(i).getCharacters() != null)
                    cast = cast + myMovie.getAbridgedCast().get(i).getCharacters().toString();
                cast = cast + "\n";
            }
            ((TextView) v.findViewById(R.id.cast)).setText(cast);
        }


        return v;
    }

}

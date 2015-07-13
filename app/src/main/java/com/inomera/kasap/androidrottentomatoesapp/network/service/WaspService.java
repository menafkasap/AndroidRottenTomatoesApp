package com.inomera.kasap.androidrottentomatoesapp.network.service;

/**
 * Created by Menaf on 19.06.2015
 */

import com.inomera.kasap.androidrottentomatoesapp.network.models.MovieResponse;
import com.inomera.kasap.androidrottentomatoesapp.network.models.Reviews;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Path;
import com.orhanobut.wasp.http.Query;

import java.util.List;

public interface WaspService {

    @GET("/movies.json")
    void getMovies(
            @Query("q") String searchQuery,
            CallBack<MovieResponse> callBack
    );

    @GET("/lists/movies/box_office.json")
    void getBoxOffice(
            CallBack<MovieResponse> callBack
    );

    @GET("/lists/movies/upcoming.json")
    void getUpcoming(
            CallBack<MovieResponse> callBack
    );

    @GET("/lists/movies/in_theaters.json")
    void getInTheaters(
            CallBack<MovieResponse> callBack
    );

    @GET("/lists/movies/opening.json")
    void getOpening(
            CallBack<MovieResponse> callBack
    );

    @GET("/movies/{id}/reviews.json")
    void getReviews(
            @Path("id") String id,
            CallBack<List<Reviews>> callBack
    );
}
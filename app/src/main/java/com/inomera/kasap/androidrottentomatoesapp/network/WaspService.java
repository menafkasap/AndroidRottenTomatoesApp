package com.inomera.kasap.androidrottentomatoesapp.network;

/**
 * Created by Menaf on 19.06.2015
 */
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.DELETE;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Query;

import java.util.List;

public interface WaspService {

    @GET("/api/public/v1.0/movie.json")
    void getMovies(
            @Query("q") String searchQuery,
            CallBack<List<Movie>> callBack
    );

    /*@GET("/api/public/v1.0/id.json")
    void getMovie(
            @Query("apikey") String apikey,
            CallBack<Movie> callBack
    );*/

    @GET("/api/public/v1.0/lists/movies/box_office.json")
    void getBoxOffice(
            @Query("apikey") String apikey,
            CallBack<Movie> callBack
    );

    @GET("/api/public/v1.0/lists/movies/upcoming.json")
    void getUpcoming(
            @Query("apikey") String apikey,
            CallBack<Movie> callBack
    );

    @GET("/movies/in_theaters.json")
    void getInTheaters(
            @Query("apikey") String apikey,
            CallBack<Movie> callBack
    );

    @GET("/lists/movies/opening.json")
    void getOpening(
            CallBack<List<Movie>> callBack
    );

    @DELETE("/delete")
    @GET("/get")
    void get(
            @Query("test test2") String value,
            CallBack<Movie> callBack
    );

}
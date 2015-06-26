package com.inomera.kasap.androidrottentomatoesapp.network;

/**
 * Created by Menaf on 19.06.2015
 */
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Path;
import com.orhanobut.wasp.http.Query;

public interface WaspService {

    @GET("/api/public/v1.0/movie.json")
    void getMovies(
            @Query("q") String searchQuery,
            CallBack<MovieResponse> callBack
    );

    @GET("/movies/{id}.json")
    void getMovie(
            @Path("id") String id,
            CallBack<Movie> callBack
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
}
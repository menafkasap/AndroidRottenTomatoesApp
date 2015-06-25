package com.inomera.kasap.androidrottentomatoesapp.common.WASP;

/**
 * Created by Menaf on 19.06.2015
 */
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.Auth;
import com.orhanobut.wasp.http.Body;
import com.orhanobut.wasp.http.BodyMap;
import com.orhanobut.wasp.http.DELETE;
import com.orhanobut.wasp.http.EndPoint;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Header;
import com.orhanobut.wasp.http.Mock;
import com.orhanobut.wasp.http.POST;
import com.orhanobut.wasp.http.PUT;
import com.orhanobut.wasp.http.QueryMap;
import com.orhanobut.wasp.http.Query;

import java.util.List;
import java.util.Map;

public interface MyService {

    @Auth
    @GET("/api/public/v1.0/movie.json")
    void getMovies(
            @Query("apikey") String apikey,
            @Query("q") String q,
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

    @GET("/api/public/v1.0/lists/movies/in_theaters.json")
    void getInTheaters(
            @Query("apikey") String apikey,
            CallBack<Movie> callBack
    );

    @GET("/api/public/v1.0/lists/movies/opening.json")
    void getOpening(
            @Query("apikey") String apikey,
            CallBack<Movie> callBack
    );

    @EndPoint("http://api.rottentomatoes.com")
    @DELETE("/delete")

    @GET("/get")
    void get(
            @Query("test test2") String value,
            CallBack<Movie> callBack
    );

}
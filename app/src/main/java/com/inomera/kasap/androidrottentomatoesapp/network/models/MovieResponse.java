package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Menaf on 26.06.2015
 */
public class MovieResponse implements Parcelable {
    int total;
    List<Movie> movies;
    Links links;

    public Links getLinks() {
        return links;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeTypedList(movies);
        dest.writeParcelable(this.links, 0);
    }

    public MovieResponse() {
    }

    protected MovieResponse(Parcel in) {
        this.total = in.readInt();
        this.movies = in.createTypedArrayList(Movie.CREATOR);
        this.links = in.readParcelable(Links.class.getClassLoader());
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        public MovieResponse createFromParcel(Parcel source) {
            return new MovieResponse(source);
        }

        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}

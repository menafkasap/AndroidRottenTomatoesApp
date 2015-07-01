package com.inomera.kasap.androidrottentomatoesapp.network;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Menaf on 17.06.2015
 */
public class Movie implements Parcelable {

    int id;
    String title;
    int year;
    @SerializedName("mpaa_rating") String mpaaRating;
    String runtime;
    @SerializedName("critics_consensus") String criticsConsensus;
    Ratings rating;
    String synopsis;
    Poster posters;
    @SerializedName("abridged_cast") ArrayList<Cast> abridgedCast;
    @SerializedName("abridged_directors") ArrayList<Director> abridgedDirectors;
    String studio;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public Ratings getRating() {
        return rating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Poster getPosters() {
        return posters;
    }

    public ArrayList<Cast> getAbridgedCast() {
        return abridgedCast;
    }

    public ArrayList<Director> getAbridgedDirectors() {
        return abridgedDirectors;
    }

    public String getStudio() { return studio; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.year);
        dest.writeString(this.mpaaRating);
        dest.writeString(this.runtime);
        dest.writeString(this.criticsConsensus);
        dest.writeParcelable(this.rating, 0);
        dest.writeString(this.synopsis);
        dest.writeParcelable(this.posters, 0);
        dest.writeTypedList(abridgedCast);
        dest.writeTypedList(abridgedDirectors);
        dest.writeString(this.studio);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.year = in.readInt();
        this.mpaaRating = in.readString();
        this.runtime = in.readString();
        this.criticsConsensus = in.readString();
        this.rating = in.readParcelable(Ratings.class.getClassLoader());
        this.synopsis = in.readString();
        this.posters = in.readParcelable(Poster.class.getClassLoader());
        this.abridgedCast = in.createTypedArrayList(Cast.CREATOR);
        this.abridgedDirectors = in.createTypedArrayList(Director.CREATOR);
        this.studio = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
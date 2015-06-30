package com.inomera.kasap.androidrottentomatoesapp.network;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Menaf on 17.06.2015
 */
public class Movie implements Parcelable {

    int id;
    String title;
    int year;
    String mpaa_rating;
    int runtime;
    String critics_consensus;
    Ratings rating;
    String synopsis;
    Posters poster;
    ArrayList<Cast> abridged_cast;
    ArrayList<Director> abridged_directors;
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

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getCritics_consensus() {
        return critics_consensus;
    }

    public Ratings getRating() {
        return rating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Posters getPoster() {
        return poster;
    }

    public ArrayList<Cast> getAbridged_cast() {
        return abridged_cast;
    }

    public ArrayList<Director> getAbridged_directors() {
        return abridged_directors;
    }

    public String getStudio() {
        return studio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.year);
        dest.writeString(this.mpaa_rating);
        dest.writeInt(this.runtime);
        dest.writeString(this.critics_consensus);
        dest.writeParcelable(this.rating, 0);
        dest.writeString(this.synopsis);
        dest.writeParcelable(this.poster, 0);
        dest.writeTypedList(abridged_cast);
        dest.writeTypedList(abridged_directors);
        dest.writeString(this.studio);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.year = in.readInt();
        this.mpaa_rating = in.readString();
        this.runtime = in.readInt();
        this.critics_consensus = in.readString();
        this.rating = in.readParcelable(Ratings.class.getClassLoader());
        this.synopsis = in.readString();
        this.poster = in.readParcelable(Posters.class.getClassLoader());
        this.abridged_cast = in.createTypedArrayList(Cast.CREATOR);
        this.abridged_directors = in.createTypedArrayList(Director.CREATOR);
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
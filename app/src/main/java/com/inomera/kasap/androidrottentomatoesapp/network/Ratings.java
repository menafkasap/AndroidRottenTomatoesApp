package com.inomera.kasap.androidrottentomatoesapp.network;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Menaf on 30.06.2015
 */
public class Ratings implements Parcelable{
    String critics_rating;
    int critics_score;
    String audience_rating;
    int audience_score;

    public String getCritics_rating() {
        return critics_rating;
    }

    public int getCritics_score() {
        return critics_score;
    }

    public String getAudience_rating() {
        return audience_rating;
    }

    public int getAudience_score() {
        return audience_score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.critics_rating);
        dest.writeInt(this.critics_score);
        dest.writeString(this.audience_rating);
        dest.writeInt(this.audience_score);
    }

    public Ratings() {
    }

    protected Ratings(Parcel in) {
        this.critics_rating = in.readString();
        this.critics_score = in.readInt();
        this.audience_rating = in.readString();
        this.audience_score = in.readInt();
    }

    public static final Creator<Ratings> CREATOR = new Creator<Ratings>() {
        public Ratings createFromParcel(Parcel source) {
            return new Ratings(source);
        }

        public Ratings[] newArray(int size) {
            return new Ratings[size];
        }
    };
}

package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Menaf on 13.07.2015
 */
public class Reviews implements Parcelable {

    String critic;
    String date;
    String freshness;
    String publication;
    String quote;
    @SerializedName("original_score") String originalScore;

    public String getCritic() {
        return critic;
    }

    public String getDate() {
        return date;
    }

    public String getFreshness() {
        return freshness;
    }

    public String getPublication() {
        return publication;
    }

    public String getQuote() {
        return quote;
    }

    public String getOriginalScore() {
        return originalScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.critic);
        dest.writeString(this.date);
        dest.writeString(this.freshness);
        dest.writeString(this.publication);
        dest.writeString(this.quote);
        dest.writeString(this.originalScore);
    }

    public Reviews() {
    }

    protected Reviews(Parcel in) {
        this.critic = in.readString();
        this.date = in.readString();
        this.freshness = in.readString();
        this.publication = in.readString();
        this.quote = in.readString();
        this.originalScore = in.readString();
    }

    public static final Parcelable.Creator<Reviews> CREATOR = new Parcelable.Creator<Reviews>() {
        public Reviews createFromParcel(Parcel source) {
            return new Reviews(source);
        }

        public Reviews[] newArray(int size) {
            return new Reviews[size];
        }
    };
}

package com.inomera.kasap.androidrottentomatoesapp.network;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Menaf on 30.06.2015
 */
public class Ratings implements Parcelable{
    @SerializedName("critics_rating") String criticsRating;
    @SerializedName("critics_score") int criticsScore;
    @SerializedName("audience_rating") String audienceRating;
    @SerializedName("audience_score") int audienceScore;

    public String getCriticsRating() {
        return criticsRating;
    }

    public int getCriticsScore() {
        return criticsScore;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public int getAudienceScore() {
        return audienceScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.criticsRating);
        dest.writeInt(this.criticsScore);
        dest.writeString(this.audienceRating);
        dest.writeInt(this.audienceScore);
    }

    public Ratings() {
    }

    protected Ratings(Parcel in) {
        this.criticsRating = in.readString();
        this.criticsScore = in.readInt();
        this.audienceRating = in.readString();
        this.audienceScore = in.readInt();
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

package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Menaf on 14.07.2015
 */
public class Links implements Parcelable {

    String self;
    String alternate;
    String cast;
    String clips;
    String reviews;
    String similar;

    public String getSelf() {
        return self;
    }

    public String getAlternate() {
        return alternate;
    }

    public String getCast() {
        return cast;
    }

    public String getReviews() {
        return reviews;
    }

    public String getClips() {
        return clips;
    }

    public String getSimilar() {
        return similar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.alternate);
        dest.writeString(this.cast);
        dest.writeString(this.clips);
        dest.writeString(this.reviews);
        dest.writeString(this.similar);
    }

    public Links() {
    }

    protected Links(Parcel in) {
        this.self = in.readString();
        this.alternate = in.readString();
        this.cast = in.readString();
        this.clips = in.readString();
        this.reviews = in.readString();
        this.similar = in.readString();
    }

    public static final Parcelable.Creator<Links> CREATOR = new Parcelable.Creator<Links>() {
        public Links createFromParcel(Parcel source) {
            return new Links(source);
        }

        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
}

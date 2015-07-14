package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Menaf on 14.07.2015
 */
public class AlternateIds implements Parcelable {
    String imdb;

    public String getImdb() {
        return imdb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imdb);
    }

    public AlternateIds() {
    }

    protected AlternateIds(Parcel in) {
        this.imdb = in.readString();
    }

    public static final Parcelable.Creator<AlternateIds> CREATOR = new Parcelable.Creator<AlternateIds>() {
        public AlternateIds createFromParcel(Parcel source) {
            return new AlternateIds(source);
        }

        public AlternateIds[] newArray(int size) {
            return new AlternateIds[size];
        }
    };
}

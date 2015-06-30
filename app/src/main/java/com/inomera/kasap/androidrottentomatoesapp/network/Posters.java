package com.inomera.kasap.androidrottentomatoesapp.network;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Menaf on 30.06.2015
 */
public class Posters implements Parcelable {

    String original;

    public String getOriginal() {
        return original;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.original);
    }

    public Posters() {
    }

    protected Posters(Parcel in) {
        this.original = in.readString();
    }

    public static final Creator<Posters> CREATOR = new Creator<Posters>() {
        public Posters createFromParcel(Parcel source) {
            return new Posters(source);
        }

        public Posters[] newArray(int size) {
            return new Posters[size];
        }
    };
}

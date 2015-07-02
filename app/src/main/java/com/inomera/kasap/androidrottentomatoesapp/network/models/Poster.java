package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Menaf on 30.06.2015
 */
public class Poster implements Parcelable {

    String thumbnail;
    String profile;
    String detailed;
    String original;

    public String getOriginal() {
        return original;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getProfile() {
        return profile;
    }

    public String getDetailed() {
        return detailed;
    }

    public Poster() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.thumbnail);
        dest.writeString(this.profile);
        dest.writeString(this.detailed);
        dest.writeString(this.original);
    }

    protected Poster(Parcel in) {
        this.thumbnail = in.readString();
        this.profile = in.readString();
        this.detailed = in.readString();
        this.original = in.readString();
    }

    public static final Creator<Poster> CREATOR = new Creator<Poster>() {
        public Poster createFromParcel(Parcel source) {
            return new Poster(source);
        }

        public Poster[] newArray(int size) {
            return new Poster[size];
        }
    };
}

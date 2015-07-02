package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Menaf on 30.06.2015
 */
public class Director implements Parcelable {

    String name;

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public Director() {
    }

    protected Director(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Director> CREATOR = new Creator<Director>() {
        public Director createFromParcel(Parcel source) {
            return new Director(source);
        }

        public Director[] newArray(int size) {
            return new Director[size];
        }
    };
}

package com.inomera.kasap.androidrottentomatoesapp.network;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Menaf on 30.06.2015
 */
public class Cast implements Parcelable{

    String name;
    ArrayList<String> characters;

    public String getName() {
        return name;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeStringList(this.characters);
    }

    public Cast() {
    }

    protected Cast(Parcel in) {
        this.name = in.readString();
        this.characters = in.createStringArrayList();
    }

    public static final Creator<Cast> CREATOR = new Creator<Cast>() {
        public Cast createFromParcel(Parcel source) {
            return new Cast(source);
        }

        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };
}

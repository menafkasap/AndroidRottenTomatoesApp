package com.inomera.kasap.androidrottentomatoesapp.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Menaf on 30.06.2015
 */
public class Cast implements Parcelable{

    int id;
    String name;
    ArrayList<String> characters;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public Cast() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeStringList(this.characters);
    }

    protected Cast(Parcel in) {
        this.id = in.readInt();
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

package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Basic implements Parcelable {

    public static final String ARG = "BASIC";

    public String title;
    public ArrayList<Text> paragraphs;
    public ArrayList<Text> checkpoints;

    public Basic() {
    }

    protected Basic(Parcel in) {
        title = in.readString();
        paragraphs = in.readArrayList(Text.class.getClassLoader());
        checkpoints = in.readArrayList(Text.class.getClassLoader());
    }

    public static final Creator<Guard> CREATOR = new Creator<Guard>() {
        @Override
        public Guard createFromParcel(Parcel in) {
            return new Guard(in);
        }

        @Override
        public Guard[] newArray(int size) {
            return new Guard[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeList(paragraphs);
        dest.writeList(checkpoints);
    }
}

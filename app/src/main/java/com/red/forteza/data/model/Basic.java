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

    public static final Creator<Basic> CREATOR = new Creator<Basic>() {
        @Override
        public Basic createFromParcel(Parcel in) {
            return new Basic(in);
        }

        @Override
        public Basic[] newArray(int size) {
            return new Basic[size];
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

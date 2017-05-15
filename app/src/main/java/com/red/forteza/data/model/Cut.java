package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cut implements Parcelable {

    public static final String ARG = "CUTS";

    public String term;
    public String translation;
    public String meaning;

    public Cut() {
    }

    protected Cut(Parcel in) {
        term = in.readString();
        translation = in.readString();
        meaning = in.readString();
    }

    public static final Creator<Cut> CREATOR = new Creator<Cut>() {
        @Override
        public Cut createFromParcel(Parcel in) {
            return new Cut(in);
        }

        @Override
        public Cut[] newArray(int size) {
            return new Cut[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(term);
        dest.writeString(translation);
        dest.writeString(meaning);
    }
}

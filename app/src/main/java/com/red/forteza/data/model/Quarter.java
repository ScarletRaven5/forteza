package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Quarter implements Parcelable {

    public static final String ARG = "CUTS";

    public String quarter;
    public String description;

    public Quarter() {
    }

    protected Quarter(Parcel in) {
        quarter = in.readString();
        description = in.readString();
    }

    public static final Creator<Quarter> CREATOR = new Creator<Quarter>() {
        @Override
        public Quarter createFromParcel(Parcel in) {
            return new Quarter(in);
        }

        @Override
        public Quarter[] newArray(int size) {
            return new Quarter[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(quarter);
        dest.writeString(description);
    }
}

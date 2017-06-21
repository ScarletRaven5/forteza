package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Step implements Parcelable {
    public String text;
    public String gif;

    public Step() {

    }

    protected Step(Parcel in) {
        text = in.readString();
        gif = in.readString();
    }

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(gif);
    }
}

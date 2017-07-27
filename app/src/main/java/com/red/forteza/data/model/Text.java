package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Text implements Parcelable {
    public String text;

    public Text() {
    }

    protected Text(Parcel in) {
        text = in.readString();
    }

    public static final Creator<Text> CREATOR = new Creator<Text>() {
        @Override
        public Text createFromParcel(Parcel in) {
            return new Text(in);
        }

        @Override
        public Text[] newArray(int size) {
            return new Text[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
    }

}

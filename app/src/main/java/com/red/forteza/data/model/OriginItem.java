package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class OriginItem implements Parcelable {

    public static final String ARG = "ORIGIN";

    public String section;
    public ArrayList<Text> paragraphs;

    public OriginItem() {
    }

    protected OriginItem(Parcel in) {
        section = in.readString();
        paragraphs = in.readArrayList(Text.class.getClassLoader());
    }

    public static final Creator<OriginItem> CREATOR = new Creator<OriginItem>() {
        @Override
        public OriginItem createFromParcel(Parcel in) {
            return new OriginItem(in);
        }

        @Override
        public OriginItem[] newArray(int size) {
            return new OriginItem[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(section);
        dest.writeList(paragraphs);
    }
}

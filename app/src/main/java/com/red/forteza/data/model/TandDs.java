package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TandDs implements Parcelable {

    public static final String ARG = "TANDD";

    public String intro;
    public List<TandD> terms;
    public List<Text> paragraphs;


    public TandDs() {
    }

    protected TandDs(Parcel in) {
        intro = in.readString();
        terms = in.readArrayList(TandD.class.getClassLoader());
        paragraphs = in.readArrayList(Text.class.getClassLoader());
    }

    public static final Creator<TandDs> CREATOR = new Creator<TandDs>() {
        @Override
        public TandDs createFromParcel(Parcel in) {
            return new TandDs(in);
        }

        @Override
        public TandDs[] newArray(int size) {
            return new TandDs[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(intro);
        dest.writeList(terms);
        dest.writeList(paragraphs);
    }
}

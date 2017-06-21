package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Drill implements Parcelable {

    public static final String ARG = "DRILL";

    public String title;
    //TODO can use String instead of Text?
    public ArrayList<Text> paragraphs;
    public ArrayList<Step> steps;
    public String sequence;

    public Drill() {

    }

    protected Drill(Parcel in) {
        title = in.readString();
        paragraphs = in.readArrayList(Text.class.getClassLoader());
        steps = in.readArrayList(Step.class.getClassLoader());
        sequence = in.readString();
    }

    public static final Creator<Drill> CREATOR = new Creator<Drill>() {
        @Override
        public Drill createFromParcel(Parcel in) {
            return new Drill(in);
        }

        @Override
        public Drill[] newArray(int size) {
            return new Drill[size];
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
        dest.writeList(steps);
        dest.writeString(sequence);
    }
}
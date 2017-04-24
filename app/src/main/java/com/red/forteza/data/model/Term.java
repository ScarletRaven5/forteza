package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Term implements Parcelable {

    public static final String ARG = "TERM";

    public String term;
    public String plural;
    public String noun;
    public String modernItalian;
    public String pronunciation;
    public String translation;
    public String definition;
    public boolean isExpanded;

    public Term(){

    }

    protected Term(Parcel in) {
        term= in.readString();
        plural = in.readString();
        noun= in.readString();
        modernItalian = in.readString();
        pronunciation = in.readString();
        translation= in.readString();
        definition = in.readString();
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
        dest.writeString(term);
        dest.writeString(plural);
        dest.writeString(noun);
        dest.writeString(modernItalian);
        dest.writeString(pronunciation);
        dest.writeString(translation);
        dest.writeString(definition);
    }
}

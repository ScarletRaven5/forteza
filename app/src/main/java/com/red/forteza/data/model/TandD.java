package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TandD implements Parcelable {

    public String term;
    public String meaning;
    public String image;

    public TandD() {
    }

    protected TandD(Parcel in) {
        term = in.readString();
        meaning = in.readString();
        image = in.readString();
    }

    public static final Creator<TandD> CREATOR = new Creator<TandD>() {
        @Override
        public TandD createFromParcel(Parcel in) {
            return new TandD(in);
        }

        @Override
        public TandD[] newArray(int size) {
            return new TandD[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(term);
        dest.writeString(meaning);
        dest.writeString(image);
    }
}

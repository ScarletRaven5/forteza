package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Guard implements Parcelable {

    public static final String ARG = "GUARD";

    public String guardImage;
    public String italianGuardName;
    public String englishGuardName;

    public Guard() {

    }

    protected Guard(Parcel in) {
        guardImage = in.readString();
        italianGuardName = in.readString();
        englishGuardName = in.readString();
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
        dest.writeString(guardImage);
        dest.writeString(italianGuardName);
        dest.writeString(englishGuardName);
    }
}

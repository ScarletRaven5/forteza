package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Guard implements Parcelable {

    public static final String ARG = "GUARD";

    public String italianName;
    public String englishName;
    public String description;
    public String imageRefId;

    public Guard() {

    }

    protected Guard(Parcel in) {
        italianName = in.readString();
        englishName = in.readString();
        description = in.readString();
        imageRefId = in.readString();
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
        dest.writeString(italianName);
        dest.writeString(englishName);
        dest.writeString(description);
        dest.writeString(imageRefId);
    }
}

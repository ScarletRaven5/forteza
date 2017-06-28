package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Guard implements Parcelable {

    public static final String ARG = "GUARD";

    public String italianName;
    public String englishName;
    public String type;
    public String fioreQuote;
    public String description;
    public String fioreImage;
    public ArrayList<Photo> photos;

    public Guard() {

    }

    protected Guard(Parcel in) {
        italianName = in.readString();
        englishName = in.readString();
        type = in.readString();
        fioreQuote = in.readString();
        description = in.readString();
        fioreImage = in.readString();
        photos = in.readArrayList(Photo.class.getClassLoader());
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
        dest.writeString(type);
        dest.writeString(fioreQuote);
        dest.writeString(description);
        dest.writeString(fioreImage);
        dest.writeList(photos);
    }
}

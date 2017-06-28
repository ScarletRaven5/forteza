package com.red.forteza.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Photo implements Parcelable {

    public static final String ARG = "PHOTO";

    public String photo;
    public String photoDetail;

    public Photo() {
    }

    protected Photo(Parcel in) {
        photo = in.readString();
        photoDetail = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photo);
        dest.writeString(photoDetail);
    }

}

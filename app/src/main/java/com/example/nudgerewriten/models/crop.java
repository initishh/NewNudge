package com.example.nudgerewriten.models;

import android.os.Parcel;
import android.os.Parcelable;

public class crop implements Parcelable {

    private String cropname;
    private int cropimage;

    public crop(String cropname, int cropimage) {
        this.setCropname(cropname);
        this.setCropimage(cropimage);
    }

    protected crop(Parcel in) {
        cropname = in.readString();
        cropimage = in.readInt();
    }

    public static final Creator<crop> CREATOR = new Creator<crop>() {
        @Override
        public crop createFromParcel(Parcel in) {
            return new crop(in);
        }

        @Override
        public crop[] newArray(int size) {
            return new crop[size];
        }
    };

    public String getCropname() {
        return cropname;
    }

    public void setCropname(String cropname) {
        this.cropname = cropname;
    }

    public int getCropimage() {
        return cropimage;
    }

    public void setCropimage(int cropimage) {
        this.cropimage = cropimage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cropname);
        dest.writeInt(cropimage);
    }
}
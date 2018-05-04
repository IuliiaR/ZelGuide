package com.example.android.zelguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
    private String mName;
    private String mType;

    private String mAddress;
    private String mPhone;
    private String mUrl;
    private String mOpenHours;
    private String mFees;

    private String mDescription;
    private int mImageId;

    protected Place(Parcel in) {
        mName = in.readString();
        mType = in.readString();
        mDescription = in.readString();
        mOpenHours = in.readString();
        mFees = in.readString();
        mAddress = in.readString();
        mPhone = in.readString();
        mUrl = in.readString();
        mImageId = in.readInt();
    }

    public Place(String placeName, String type, String address, String phone, String url, String openHours, String fees, String description) {
        mName = placeName;
        mType = type;
        mOpenHours = openHours;
        mFees = fees;
        mAddress = address;
        mPhone = phone;
        mUrl = url;
        mDescription = description;
    }

    public Place(String placeName, String type, String address, String phone, String url, String openHours, String fees, String description, int imageId) {
        mName = placeName;
        mType = type;
        mOpenHours = openHours;
        mFees = fees;
        mAddress = address;
        mPhone = phone;
        mUrl = url;
        mDescription = description;
        mImageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mType);
        parcel.writeString(mDescription);
        parcel.writeString(mOpenHours);
        parcel.writeString(mFees);
        parcel.writeString(mAddress);
        parcel.writeString(mPhone);
        parcel.writeString(mUrl);
        parcel.writeInt(mImageId);
    }

    public String getName(){
        return mName;
    }

    public String getType() {
        return mType;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getFees() {
        return mFees;
    }

    public String getOpenHours() {
        return mOpenHours;
    }

    public int getImageId() {
        return mImageId;
    }
}

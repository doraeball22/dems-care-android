package com.dems_care.demscare.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bon on 18/9/2560.
 */

public class ArticleItemDao implements Parcelable {
    // ใช้ เว็บ jsonschema2pojo.org for generate ได้ json -> gson

    // Retrofit ดึงข้อมูลจาก server  json เป็น string เราต้องใช้ Retrofit coverter แปลง String เป็น DAO อีกรอบ
    @SerializedName("_id")                private String id;
    @SerializedName("title")              private String title;
    @SerializedName("bodyUrl")            private String bodyUrl;
    @SerializedName("imageUrl")           private String imageUrl;
    @SerializedName("author")             private String author;

    protected ArticleItemDao(Parcel in) {
        id = in.readString();
        title = in.readString();
        bodyUrl = in.readString();
        imageUrl = in.readString();
        author = in.readString();
    }

    public static final Creator<ArticleItemDao> CREATOR = new Creator<ArticleItemDao>() {
        @Override
        public ArticleItemDao createFromParcel(Parcel in) {
            return new ArticleItemDao(in);
        }

        @Override
        public ArticleItemDao[] newArray(int size) {
            return new ArticleItemDao[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyUrl() {
        return bodyUrl;
    }

    public void setBodyUrl(String bodyUrl) {
        this.bodyUrl = bodyUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(bodyUrl);
        dest.writeString(imageUrl);
        dest.writeString(author);
    }
}

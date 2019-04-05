package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Post {

    private String title;

    private int userId;

    private int id;

    @SerializedName("body")
    private String text;

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}

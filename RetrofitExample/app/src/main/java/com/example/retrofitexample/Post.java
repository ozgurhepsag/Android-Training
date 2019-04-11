package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Post {

    private String title;

    private int userId;

    private Integer id; // Integer is nullable

    @SerializedName("body")
    private String text;

    public Post(String title, int userId, String text) {
        this.title = title;
        this.userId = userId;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
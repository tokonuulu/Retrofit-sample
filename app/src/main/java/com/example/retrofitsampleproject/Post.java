package com.example.retrofitsampleproject;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;

    /**
     *  ID is generated on the server so it should be nullable
     *  so that Json object does not include this field
     */
    private Integer id;

    private String title;

    @SerializedName("body")
    private String text;

    /**
     * ID is not included
     * because it should be omitted when creating Json object
     */
    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserID() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

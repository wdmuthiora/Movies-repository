
package com.moringaschool.android_ip_1.Models.SearchEndPoint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Company() {
    }

    /**
     * 
     * @param image
     * @param id
     * @param title
     */
    public Company(String title, Object image, String id) {
        super();
        this.title = title;
        this.image = image;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

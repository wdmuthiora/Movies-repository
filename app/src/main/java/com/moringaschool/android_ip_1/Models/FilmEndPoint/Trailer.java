
package com.moringaschool.android_ip_1.Models.FilmEndPoint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trailer {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trailer() {
    }

    /**
     * 
     * @param link
     * @param id
     */
    public Trailer(String id, String link) {
        super();
        this.id = id;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}


package com.moringaschool.android_ip_1.Models.FilmEndPoint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cast {

    @SerializedName("actor")
    @Expose
    private String actor;
    @SerializedName("actor_id")
    @Expose
    private String actorId;
    @SerializedName("character")
    @Expose
    private String character;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cast() {
    }

    /**
     * 
     * @param actor
     * @param character
     * @param actorId
     */
    public Cast(String actor, String actorId, String character) {
        super();
        this.actor = actor;
        this.actorId = actorId;
        this.character = character;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

}

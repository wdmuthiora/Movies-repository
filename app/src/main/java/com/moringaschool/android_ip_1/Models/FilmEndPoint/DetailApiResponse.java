package com.moringaschool.android_ip_1.Models.FilmEndPoint;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailApiResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rating_votes")
    @Expose
    private String ratingVotes;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("trailer")
    @Expose
    private Trailer trailer;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = null;
    @SerializedName("technical_specs")
    @Expose
    private List<List<String>> technicalSpecs = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DetailApiResponse() {
    }

    /**
     * 
     * @param trailer
     * @param cast
     * @param year
     * @param ratingVotes
     * @param plot
     * @param technicalSpecs
     * @param length
     * @param rating
     * @param id
     * @param title
     * @param poster
     */
    public DetailApiResponse(String id, String title, String year, String length, String rating, String ratingVotes, String poster, String plot, Trailer trailer, List<Cast> cast, List<List<String>> technicalSpecs) {
        super();
        this.id = id;
        this.title = title;
        this.year = year;
        this.length = length;
        this.rating = rating;
        this.ratingVotes = ratingVotes;
        this.poster = poster;
        this.plot = plot;
        this.trailer = trailer;
        this.cast = cast;
        this.technicalSpecs = technicalSpecs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingVotes() {
        return ratingVotes;
    }

    public void setRatingVotes(String ratingVotes) {
        this.ratingVotes = ratingVotes;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<List<String>> getTechnicalSpecs() {
        return technicalSpecs;
    }

    public void setTechnicalSpecs(List<List<String>> technicalSpecs) {
        this.technicalSpecs = technicalSpecs;
    }

}

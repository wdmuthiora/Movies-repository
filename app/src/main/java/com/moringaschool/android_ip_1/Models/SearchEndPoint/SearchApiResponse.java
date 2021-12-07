package com.moringaschool.android_ip_1.Models.SearchEndPoint;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchApiResponse {

    @SerializedName("titles")
    @Expose
    private List<SearchArrayObject> titles = null;
    @SerializedName("names")
    @Expose
    private List<SearchArrayObject> names = null;
    @SerializedName("companies")
    @Expose
    private List<SearchArrayObject> companies = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchApiResponse() {
    }

    /**
     * 
     * @param companies
     * @param names
     * @param titles
     */
    public SearchApiResponse(List<SearchArrayObject> titles, List<SearchArrayObject> names, List<SearchArrayObject> companies) {
        super();
        this.titles = titles;
        this.names = names;
        this.companies = companies;
    }

    public List<SearchArrayObject> getTitles() {
        return titles;
    }

    public void setTitles(List<SearchArrayObject> titles) {
        this.titles = titles;
    }

    public List<SearchArrayObject> getNames() {
        return names;
    }

    public void setNames(List<SearchArrayObject> names) {
        this.names = names;
    }

    public List<SearchArrayObject> getCompanies() {
        return companies;
    }

    public void setCompanies(List<SearchArrayObject> companies) {
        this.companies = companies;
    }

}

package com.moringaschool.android_ip_1.Models.SearchEndPoint;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchApiResponse {

    @SerializedName("titles")
    @Expose
    private List<SearchApiObject> titles = null;
    @SerializedName("names")
    @Expose
    private List<SearchApiObject> names = null;
    @SerializedName("companies")
    @Expose
    private List<SearchApiObject> companies = null;

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
    public SearchApiResponse(List<SearchApiObject> titles, List<SearchApiObject> names, List<SearchApiObject> companies) {
        super();
        this.titles = titles;
        this.names = names;
        this.companies = companies;
    }

    public List<SearchApiObject> getTitles() {
        return titles;
    }

    public void setTitles(List<SearchApiObject> titles) {
        this.titles = titles;
    }

    public List<SearchApiObject> getNames() {
        return names;
    }

    public void setNames(List<SearchApiObject> names) {
        this.names = names;
    }

    public List<SearchApiObject> getCompanies() {
        return companies;
    }

    public void setCompanies(List<SearchApiObject> companies) {
        this.companies = companies;
    }

}

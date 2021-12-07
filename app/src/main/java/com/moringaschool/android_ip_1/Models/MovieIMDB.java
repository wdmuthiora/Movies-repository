
package com.moringaschool.android_ip_1.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieIMDB {

    @SerializedName("titles")
    @Expose
    private List<Title> titles = null;
    @SerializedName("names")
    @Expose
    private List<Name> names = null;
    @SerializedName("companies")
    @Expose
    private List<Company> companies = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MovieIMDB() {
    }

    /**
     * 
     * @param companies
     * @param names
     * @param titles
     */
    public MovieIMDB(List<Title> titles, List<Name> names, List<Company> companies) {
        super();
        this.titles = titles;
        this.names = names;
        this.companies = companies;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}

package com.sara.springmvcdemomaven.FormTagsDataBinding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String, String> countryOptions;
    private String[] languages;
    private String[] operatingSystems;

    private String favoriteLanguage;
    public Student() {
        // populate country options; use iso country code
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("US", "United States");
        countryOptions.put("UK", "United Kingdom");

        languages = new String[4];
        languages[0] = "Java";
        languages[1] = "C#";
        languages[2] = "PHP";
        languages[3] = "Ruby";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }
}

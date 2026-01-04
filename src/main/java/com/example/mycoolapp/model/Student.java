package com.example.mycoolapp.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String language;

    private List<String> favSystems;

    public Student() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getFavSystems() {
        return favSystems;
    }

    public void setFavSystems(List<String> favSystems) {
        this.favSystems = favSystems;
    }

}

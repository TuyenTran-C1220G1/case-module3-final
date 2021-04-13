package com.company.model;

public class City {
    private int idCity;
    private String nameCity;
    private String descriptionCity;
    private String imageCity;

    public City() {
    }

    public City(int idCity, String nameCity, String descriptionCity, String imageCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.descriptionCity = descriptionCity;
        this.imageCity = imageCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getDescriptionCity() {
        return descriptionCity;
    }

    public void setDescriptionCity(String descriptionCity) {
        this.descriptionCity = descriptionCity;
    }

    public String getImageCity() {
        return imageCity;
    }

    public void setImageCity(String imageCity) {
        this.imageCity = imageCity;
    }
}

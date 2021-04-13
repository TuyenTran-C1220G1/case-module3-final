package com.company.model;

public class Hotel {
    private int idHotel;
    private String nameHotel;
    private String descriptionHotel;
    private String imageHotel;
    private int idCity;

    public Hotel() {
    }

    public Hotel(int idHotel, String nameHotel, String descriptionHotel, String imageHotel, int idCity) {
        this.idHotel = idHotel;
        this.nameHotel = nameHotel;
        this.descriptionHotel = descriptionHotel;
        this.imageHotel = imageHotel;
        this.idCity = idCity;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getDescriptionHotel() {
        return descriptionHotel;
    }

    public void setDescriptionHotel(String descriptionHotel) {
        this.descriptionHotel = descriptionHotel;
    }

    public String getImageHotel() {
        return imageHotel;
    }

    public void setImageHotel(String imageHotel) {
        this.imageHotel = imageHotel;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel=" + idHotel +
                ", nameHotel='" + nameHotel + '\'' +
                ", descriptionHotel='" + descriptionHotel + '\'' +
                ", imageHotel='" + imageHotel + '\'' +
                ", idCity=" + idCity +
                '}';
    }
}
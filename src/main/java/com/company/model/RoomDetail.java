package com.company.model;

public class RoomDetail {
    private int idRoom;
    private String nameRoom;
    private String descriptionRoom ;
    private double price;
    private String imageRoom;
    private String nameHotel;
    private int idHotel;
    private String nameCate;

    public RoomDetail(int idRoom, String nameRoom, String descriptionRoom, double price, String imageRoom, String nameHotel,int idHotel, String nameCate) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.descriptionRoom = descriptionRoom;
        this.price = price;
        this.imageRoom = imageRoom;
        this.nameHotel = nameHotel;
        this.idHotel = idHotel;
        this.nameCate = nameCate;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getDescriptionRoom() {
        return descriptionRoom;
    }

    public void setDescriptionRoom(String descriptionRoom) {
        this.descriptionRoom = descriptionRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageRoom() {
        return imageRoom;
    }

    public void setImageRoom(String imageRoom) {
        this.imageRoom = imageRoom;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public String toString() {
        return "RoomDetail{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", descriptionRoom='" + descriptionRoom + '\'' +
                ", price=" + price +
                ", imageRoom='" + imageRoom + '\'' +
                ", nameHotel='" + nameHotel + '\'' +
                ", nameCate='" + nameCate + '\'' +
                '}';
    }
}
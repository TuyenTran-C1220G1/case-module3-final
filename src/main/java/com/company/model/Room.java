package com.company.model;

public class Room {
    private int idRoom;
    private String nameRoom;
    private String descriptionRoom ;
    private double price;
    private String imageRoom;
    private int idCate;
    private int idHotel;

    public Room(){}

    public Room(int idRoom, String nameRoom, String descriptionRoom, double price, String imageRoom, int idCate, int idHotel) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.descriptionRoom = descriptionRoom;
        this.price = price;
        this.imageRoom = imageRoom;
        this.idCate = idCate;
        this.idHotel = idHotel;
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

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", descriptionRoom='" + descriptionRoom + '\'' +
                ", price=" + price +
                ", imageRoom='" + imageRoom + '\'' +
                ", idCate=" + idCate +
                ", idHotel=" + idHotel +
                '}';
    }
}

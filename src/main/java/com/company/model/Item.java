package com.company.model;

public class Item {
    private int idItem;
    private RoomDetail room;
    private double price;

    public Item() {
    }

    public Item(int idItem, RoomDetail room, double price) {
        this.idItem = idItem;
        this.room = room;
        this.price = price;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public RoomDetail getRoom() {
        return room;
    }

    public void setRoom(RoomDetail room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

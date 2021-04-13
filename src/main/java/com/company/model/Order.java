package com.company.model;

import java.time.LocalDate;

public class Order {
    private int idOrder;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int idCustomer;
    private int idRoom;

    public Order() {
    }

    public Order(int idOrder, LocalDate fromDate, LocalDate toDate, int idCustomer, int idRoom) {
        this.idOrder = idOrder;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.idCustomer = idCustomer;
        this.idRoom = idRoom;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }
}

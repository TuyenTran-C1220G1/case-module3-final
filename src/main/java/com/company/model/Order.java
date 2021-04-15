package com.company.model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int idOrder;
    private Date fromDate;
    private Date toDate;
    private int idCustomer;
    private int idRoom;

    public Order() {
    }

    public Order(int idOrder, Date fromDate, Date toDate, int idCustomer, int idRoom) {
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
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

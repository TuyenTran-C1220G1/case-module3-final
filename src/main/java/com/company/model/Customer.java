package com.company.model;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private String address;
    private String phone;

    public Customer() {
    }

    public Customer(int idCustomer, String nameCustomer, String address, String phone) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phone = phone;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.company.model;

public class Customer {
    private int idCustomer;
    private String user;
    private String password;
    private String nameCustomer;
    private String address;
    private int phone;
    private int isSell;
    private int isAdmin;

    public Customer() {
    }

    public Customer(int idCustomer, String user, String password, String nameCustomer, String address, int phone, int isSell, int isAdmin) {
        this.idCustomer = idCustomer;
        this.user = user;
        this.password = password;
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phone = phone;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

}

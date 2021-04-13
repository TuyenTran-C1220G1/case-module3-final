package com.company.model;

public class Category {
    int idCate;
    String nameCate;

    public Category() {
    }

    public Category(int idCate, String nameCate) {
        this.idCate = idCate;
        this.nameCate = nameCate;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }
}

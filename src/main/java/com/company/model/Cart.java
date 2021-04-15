package com.company.model;

import java.util.List;

public class Cart {
    private int idCart;
    private Customer customer;
    private List<Item> itemList;

    public Cart() {
    }

    public Cart(int idCart, Customer customer, List<Item> itemList) {
        this.idCart = idCart;
        this.customer = customer;
        this.itemList = itemList;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}

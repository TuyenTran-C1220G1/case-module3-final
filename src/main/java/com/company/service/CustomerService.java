package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void addNewCustomer(String nameCustomer, String address, int phone) {
        String sql = "insert into customer(name_customer,address,phone) values(?,?,?)";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameCustomer);
            ps.setString(2, address);
            ps.setInt(3, phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findIdCustomerByName(String nameCustomer) {
        String sql = "select id_customer from customer where name_customer=?";
        int idCustomer=0;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameCustomer);
            rs = ps.executeQuery();
            while (rs.next()) {
                idCustomer = rs.getInt("id_customer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCustomer;
    }
}

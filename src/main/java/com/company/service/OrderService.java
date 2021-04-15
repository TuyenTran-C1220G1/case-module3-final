package com.company.service;

import com.company.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderService {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void addNewOrder(Date fromDate, Date toDate, int idCustomer, int idRoom){
        String sql = "insert into orders(fromDate,toDate,id_Customer,id_Room) values(?,?,?,?)";
        try {
            conn= DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) fromDate);
            ps.setDate(2, (java.sql.Date) toDate);
            ps.setInt(3,idCustomer);
            ps.setInt(4,idRoom);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

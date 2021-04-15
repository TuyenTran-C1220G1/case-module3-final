package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpService {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Customer checkCustomer(String user){
        String sql = "select * from customer where user = ?";
        try {
            conn= DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_customer");
                String user1 = rs.getString("user");
                String pass1 = rs.getString("password");
                String name = rs.getString("name_customer");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                int isSell= rs.getInt("isSell");
                int isAdmin = rs.getInt("isAdmin");
                return new Customer(id,user1,pass1,name,address,phone,isSell,isAdmin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return null;
    }
    public void signUp(String name,String user,String pass,String address,int phone){
        String sql = "insert into customer(name_customer,user,password,address,phone) values(?,?,?,?,?)";
        try {
            conn= DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,user);
            ps.setString(3,pass);
            ps.setString(4,address);
            ps.setInt(5,phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

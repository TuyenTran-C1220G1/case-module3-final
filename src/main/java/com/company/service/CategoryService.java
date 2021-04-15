package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.Category;
import com.company.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Category findCategoryById(int idCate){
        String sql ="select * from category where id_Cate=?";
        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idCate);
            rs = ps.executeQuery();
            while (rs.next()){
                idCate = rs.getInt("id_cate");
                String nameCate= rs.getString("name_cate");
                return new Category(idCate,nameCate);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

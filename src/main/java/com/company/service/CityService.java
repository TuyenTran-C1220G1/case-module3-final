package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<City> getAllCity(){
        List<City> cities = new ArrayList<>();
        String sql ="select * from city";

        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_city");
                String name= rs.getString("name_city");
                String description = rs.getString("description_city");
                String image= rs.getString("image_city");
                cities.add(new City(id,name,description,image));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cities;
    }

    public City findCityById(int idCity){
        String sql ="select * from city where id_City=?";
        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idCity);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_city");
                String name= rs.getString("name_city");
                String description = rs.getString("description_city");
                String image= rs.getString("image_city");
                return new City(id,name,description,image);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
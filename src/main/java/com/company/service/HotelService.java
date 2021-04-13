package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.City;
import com.company.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Hotel> findHotelByCity(int idCity) {
        List<Hotel> hotelList = new ArrayList<>();
        String sql = "select id_hotel,name_hotel,description_hotel,image_hotel,hotel.id_city from hotel join city on city.id_city=hotel.id_city where hotel.id_City=?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCity);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idHotel = rs.getInt("id_hotel");
                String nameHotel = rs.getString("name_hotel");
                String descriptionHotel = rs.getString("description_hotel");
                String imageHotel = rs.getString("image_hotel");
                idCity = rs.getInt("id_city");
                hotelList.add(new Hotel(idHotel, nameHotel, descriptionHotel, imageHotel, idCity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hotelList;
    }
}
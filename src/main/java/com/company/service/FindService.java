package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.Room;
import com.company.model.RoomDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<RoomDetail> findRoom(int idCate, int id_city, Date checkin ,Date checkout) {
        List<RoomDetail> list = new ArrayList<>();
        String sql ="select * from room join hotel using (id_hotel)\n" +
                "join city using (id_city) join category using(id_cate)\n" +
                "where id_cate = ? and id_city = ? and id_room NOT IN (\n" +
                "   SELECT DISTINCT id_room\n" +
                "   FROM orders\n" +
                "   WHERE todate >= ? AND fromdate <= ?);";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCate);
            ps.setInt(2,id_city);
            ps.setDate(3, (java.sql.Date) checkin);
            ps.setDate(4, (java.sql.Date) checkout);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_room");
                String name = rs.getString("name_room");
                String description = rs.getString("description_room");
                int price = rs.getInt("price");
                String image = rs.getString("image_room");
                String namecate = rs.getString("name_cate");
                String nameHotel = rs.getString("name_hotel");
                list.add(new RoomDetail(id, name, description, price, image,nameHotel,namecate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<RoomDetail> findEmptyRoom(Date checkin ,Date checkout) {
        List<RoomDetail> list = new ArrayList<>();
//        String sql ="select * from room join hotel using (id_hotel)\n" +
//                "join city using (id_city) join category using(id_cate)\n" +
//                "where name_cate = ? and name_hotel = ? and id_room NOT IN (\n" +
//                "   SELECT DISTINCT id_room\n" +
//                "   FROM orders\n" +
//                "   WHERE todate >= ? AND fromdate <= ?);";

        String sql= "select * from room join hotel using (id_hotel) join category using(id_cate) where id_room NOT IN (SELECT DISTINCT id_room FROM orders WHERE todate >=? AND fromdate <=?);";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
//            ps.setString(1, nameCate);
//            ps.setString(2,nameHotel);
            ps.setDate(1, (java.sql.Date) checkin);
            ps.setDate(2, (java.sql.Date) checkout);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_room");
                String name = rs.getString("name_room");
                String description = rs.getString("description_room");
                int price = rs.getInt("price");
                String image = rs.getString("image_room");
                String namecate = rs.getString("name_cate");
                String nameHotel = rs.getString("name_hotel");
                list.add(new RoomDetail(id, name, description, price, image,nameHotel,namecate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
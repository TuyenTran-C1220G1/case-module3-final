package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.Hotel;
import com.company.model.Room;
import com.company.model.RoomDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<RoomDetail> findRoomByHotel(int idHotel) {
        List<RoomDetail> list = new ArrayList<>();
        String sql = "select * from room join hotel using(id_hotel) join category using(id_cate) where room.id_Hotel=?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHotel);
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

    public RoomDetail getRoomById(int idRoom) {
        String sql = "select * from room join hotel using(id_hotel) join category using(id_cate) where room.id_Room=?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idRoom);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_room");
                String name = rs.getString("name_room");
                String description = rs.getString("description_room");
                int price = rs.getInt("price");
                String image = rs.getString("image_room");
                String namecate = rs.getString("name_cate");
                String nameHotel = rs.getString("name_hotel");
                return new RoomDetail(id, name, description, price, image,nameHotel,namecate);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}



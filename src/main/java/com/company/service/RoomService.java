package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.Hotel;
import com.company.model.Room;

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

    public List<Room> findRoomByHotel(int idHotel) {
        List<Room> roomList = new ArrayList<>();
        String sql = "select * from room where room.id_Hotel=?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHotel);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idRoom = rs.getInt("id_room");
                String nameRoom = rs.getString("name_room");
                String descriptionRoom = rs.getString("description_room");
                Double price = rs.getDouble("price");
                String imageRoom = rs.getString("image_room");
                int idCate = rs.getInt("id_Cate");
                roomList.add(new Room(idRoom,nameRoom,descriptionRoom,price,imageRoom,idCate,idHotel));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }
}



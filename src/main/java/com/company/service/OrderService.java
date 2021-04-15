
package com.company.service;

import com.company.dao.DBConnection;
import com.company.model.Customer;
import com.company.model.Hotel;
import com.company.model.Order;
import com.company.model.Room;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Hotel findNameHotelByIdRoom(int idRoom) throws SQLException {
        String sql = "SELECT * FROM hotel JOIN room using(id_hotel) WHERE id_room = ?";
        try {
        conn = DBConnection.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idRoom);
        rs = ps.executeQuery();
        while (rs.next()) {
            int idHotel = rs.getInt("id_hotel");
            String nameHotel = rs.getString("name_hotel");
            String descriptionHotel = rs.getString("description_hotel");
            String imageHotel = rs.getString("image_hotel");
            int idCity = rs.getInt("id_city");
            return new Hotel(idHotel,nameHotel,descriptionHotel,imageHotel,idCity);
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();}
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {return  null;}
        }
        return null;
    }

    public Room findNameRoomById(int idRoom) throws SQLException {
        String sql = "SELECT * FROM room WHERE id_room = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idRoom);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nameRoom = rs.getString("name_room");
                String descriptionRoom = rs.getString("description_room");
                Double price = rs.getDouble("price");
                String imageRoom = rs.getString("image_room");
                int idCate = rs.getInt("id_Cate");
                int idHotel = rs.getInt("id_Hotel");
                return new Room(idRoom,nameRoom,descriptionRoom,price,imageRoom,idCate,idHotel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();}
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {return  null;}
        }
        return null;
    }

    public void insertCustomer(Customer customer) throws SQLException {
        String sql = "insert into customer (name_customer,address,phone) values (?,?,?)";
        try {
            conn = DBConnection.getConnection();
//            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getNameCustomer());
            ps.setString(2, customer.getAddress());
            ps.setString(3,customer.getPhone());
            System.out.println(ps);
            ps.executeUpdate();
//            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
//            if (conn != null) {conn.rollback();}
        }
    }
}

package com.company.controller;

import com.company.model.*;
import com.company.service.CategoryService;
import com.company.service.HotelService;
import com.company.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {
    private RoomService roomService=new RoomService();
    private CategoryService categoryService=new CategoryService();
    private HotelService hotelService=new HotelService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idHotel = Integer.parseInt(request.getParameter("idHotel"));
        List<RoomDetail> roomList = roomService.findRoomByHotel(idHotel);
        request.setAttribute("rooms", roomList);
        request.getRequestDispatcher("hotel/room.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

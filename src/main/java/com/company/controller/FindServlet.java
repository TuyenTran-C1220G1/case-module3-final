package com.company.controller;

import com.company.model.RoomDetail;
import com.company.service.FindService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "FindServlet", value = "/find")
public class FindServlet extends HttpServlet {
    private FindService findService = new FindService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idcate"));
        System.out.println(id);
        int city = Integer.parseInt(request.getParameter("city"));
        System.out.println(city);
        Date checkin = java.sql.Date.valueOf(request.getParameter("checkin"));
        Date checkout = java.sql.Date.valueOf(request.getParameter("checkout"));
        List<RoomDetail> list = findService.findRoomFromAddress(id, city, checkin, checkout);

        request.setAttribute("rooms", list);
        request.getRequestDispatcher("/hotel/room.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
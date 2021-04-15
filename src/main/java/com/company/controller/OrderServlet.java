package com.company.controller;

import com.company.model.RoomDetail;
import com.company.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    private RoomService roomService=new RoomService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("name");
        if(action==null){
            action="";
        }
        switch (action){
            default:
                int idRoom = Integer.parseInt(request.getParameter("idRoom"));
                System.out.println(idRoom);
                RoomDetail roomDetail= roomService.getRoomById(idRoom);
                request.setAttribute("room",roomDetail);
                request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("name");
        if(action==null){
            action="";
        }
        switch (action){
            case "add":
                String nameCustomer = request.getParameter("nameCustomer");
                System.out.println(nameCustomer);

                int phone = Integer.parseInt(request.getParameter("phone"));
                System.out.println(phone);

                String address=request.getParameter("address");
                System.out.println(address);

                Date checkin = java.sql.Date.valueOf(request.getParameter("fromDate"));
                Date checkout = java.sql.Date.valueOf(request.getParameter("toDate"));

                System.out.println(checkin);
                System.out.println(checkout);

                request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
        }
    }
}

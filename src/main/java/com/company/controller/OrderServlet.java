package com.company.controller;

import com.company.model.RoomDetail;
import com.company.service.CustomerService;
import com.company.service.FindService;
import com.company.service.OrderService;
import com.company.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", value ="/order")
public class OrderServlet extends HttpServlet {

    private RoomService roomService = new RoomService();
    private FindService findService = new FindService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("name");
        if (action == null) action = "";
        switch (action){
            default:
                request.getRequestDispatcher("hotel/order.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("name");
        if (action == null) action = "";
        switch (action){
            case "add":
                int idRoom = Integer.parseInt(request.getParameter("idRoom"));
                RoomDetail roomDetail = roomService.getRoomById(idRoom);
                int idHotel = roomDetail.getIdHotel();

                String nameCustomer = request.getParameter("nameCustomer");
                int phone = Integer.parseInt(request.getParameter("phone"));
                String address = request.getParameter("address");
                Date fromDate = java.sql.Date.valueOf(request.getParameter("checkin"));
                Date toDate = java.sql.Date.valueOf(request.getParameter("checkout"));

                List<RoomDetail> listEmptyRoom = findService.findEmptyRoom(idHotel,fromDate, toDate);
                boolean addable = false;
                for (RoomDetail room : listEmptyRoom) {
                    if (room.getIdRoom() == roomDetail.getIdRoom()) {
                        addable = true;
                        break;
                    }
                }
                if (addable) {
                    request.setAttribute("nameCustomer", nameCustomer);
                    request.setAttribute("phone", phone);
                    request.setAttribute("address", address);
                    request.setAttribute("fromDate", fromDate);
                    request.setAttribute("toDate", toDate);
                    request.setAttribute("message1", "Order success!!");
                    request.getRequestDispatcher("/hotel/order.jsp").forward(request, response);
                } else {
                    request.setAttribute("advise", listEmptyRoom);
                    String message = "Ph&#242;ng" + roomDetail.getNameRoom() + " &#273;&#227; c&#243; kh&#225;ch thu&#234; trong kho&#7843;ng th&#7901;i gian tr&#234;n";
                    request.setAttribute("message1", message);
                    request.getRequestDispatcher("/hotel/order.jsp").forward(request, response);
                }
                break;
        }

    }




    }






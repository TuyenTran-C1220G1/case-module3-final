package com.company.controller;

import com.company.model.City;
import com.company.model.Customer;
import com.company.model.Hotel;
import com.company.model.Room;
import com.company.service.CityService;
import com.company.service.HotelService;
import com.company.service.OrderService;
import com.company.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                showOrder(request,response);
    }

    private void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRoom = Integer.parseInt(request.getParameter("idRoom"));
        try {
            Hotel hotel = orderService.findNameHotelByIdRoom(idRoom);
            request.setAttribute("hotel", hotel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Room room = orderService.findNameRoomById(idRoom);
            request.setAttribute("room", room);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    showOrder(request,response);
                    insertCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String nameCustomer = request.getParameter("name_customer");
        String address = request.getParameter("adress_customer");
        String phone = request.getParameter("phone_customer");
        Customer customer = new Customer(nameCustomer, address, phone);
        orderService.insertCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotel/order.jsp");
        dispatcher.forward(request, response);
    }
}


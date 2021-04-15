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

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {

    private RoomService roomService = new RoomService();
    private CustomerService customerService = new CustomerService();
    private OrderService orderService = new OrderService();
    private FindService findService = new FindService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("name");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                int idRoom = Integer.parseInt(request.getParameter("idRoom"));
                RoomDetail roomDetail = roomService.getRoomById(idRoom);
                request.setAttribute("room", roomDetail);
                request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("name");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                int idRoom = Integer.parseInt(request.getParameter("idRoom"));
                RoomDetail roomDetail = roomService.getRoomById(idRoom);
                request.setAttribute("room", roomDetail);

                String nameCustomer = request.getParameter("nameCustomer");
                int phone = Integer.parseInt(request.getParameter("phone"));
                String address = request.getParameter("address");

                Date fromDate = java.sql.Date.valueOf(request.getParameter("checkin"));
                Date toDate = java.sql.Date.valueOf(request.getParameter("checkout"));

                List<RoomDetail> listEmptyRoom = findService.findEmptyRoom(fromDate, toDate);
                System.out.println(listEmptyRoom.size());
                boolean addable = false;
                for (RoomDetail room : listEmptyRoom) {
                    if (room.getIdRoom() == roomDetail.getIdRoom()) {
                        addable = true;
                        break;
                    }
                }

                request.setAttribute("nameCustomer",nameCustomer);
                request.setAttribute("phone",phone);
                request.setAttribute("address",address);
                request.setAttribute("fromDate",fromDate);
                request.setAttribute("toDate",toDate);

                if (addable) {
                    customerService.addNewCustomer(nameCustomer, address, phone);
                    int idCustomer = customerService.findIdCustomerByName(nameCustomer);
                    orderService.addNewOrder(fromDate, toDate, idCustomer, idRoom);
                    long days = (toDate.getTime() - fromDate.getTime()) / (24 * 60 * 60 * 1000);
                    Double total = days * roomDetail.getPrice();
                    request.setAttribute("days", days);
                    request.setAttribute("total", total);
                    request.setAttribute("message", "B&#7841;n &#273;&#227; &#273;&#7863;t ph&#242;ng th&#224;nh c&#244;ng!");
                    request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
                }
                else {
                    String message="Ph&#242;ng" +roomDetail.getNameRoom()+" &#273;&#227; c&#243; kh&#225;ch thu&#234; trong kho&#7843;ng th&#7901;i gian tr&#234;n";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("hotel/order-error.jsp").forward(request, response);
                }
                break;
            case"find":
                idRoom = Integer.parseInt(request.getParameter("idRoom"));
                roomDetail = roomService.getRoomById(idRoom);
                request.setAttribute("room", roomDetail);

                nameCustomer = request.getParameter("nameCustomer");
                phone = Integer.parseInt(request.getParameter("phone"));
                address = request.getParameter("address");

                fromDate = java.sql.Date.valueOf(request.getParameter("checkin"));
                toDate = java.sql.Date.valueOf(request.getParameter("checkout"));

                listEmptyRoom = findService.findEmptyRoom(fromDate, toDate);
                System.out.println(listEmptyRoom.size());
                addable = false;
                for (RoomDetail room : listEmptyRoom) {
                    if (room.getIdRoom() == roomDetail.getIdRoom()) {
                        addable = true;
                        break;
                    }
                }

                request.setAttribute("nameCustomer",nameCustomer);
                request.setAttribute("phone",phone);
                request.setAttribute("address",address);
                request.setAttribute("fromDate",fromDate);
                request.setAttribute("toDate",toDate);

                if (addable) {
                    request.setAttribute("message", "B&#7841;n &#273;&#227; &#273;&#7863;t ph&#242;ng th&#224;nh c&#244;ng!");
                    request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
                }
                else {
                    String message="Ph&#242;ng" +roomDetail.getNameRoom()+" &#273;&#227; c&#243; kh&#225;ch thu&#234; trong kho&#7843;ng th&#7901;i gian tr&#234;n";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("hotel/order-error.jsp").forward(request, response);
                }
                break;
        }
    }
}



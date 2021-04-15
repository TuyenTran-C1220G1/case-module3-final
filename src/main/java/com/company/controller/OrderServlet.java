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
                int idHotel=findService.getIdHotel(idRoom);

                List<RoomDetail> listEmptyRoom = findService.findEmptyRoom(idHotel,fromDate, toDate);
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
                    request.setAttribute("add","active");
                    request.setAttribute("message", "B&#7841;n &#273;&#227; &#273;&#7863;t ph&#242;ng th&#224;nh c&#244;ng!");
                    request.getRequestDispatcher("hotel/order-detail.jsp").forward(request, response);
                }
                else {
                    String message="Ph&#242;ng " +roomDetail.getNameRoom()+" &#273;&#227; c&#243; kh&#225;ch thu&#234; trong kho&#7843;ng th&#7901;i gian tr&#234;n";
                    request.setAttribute("message", message);
                    request.setAttribute("add","");
                    request.getRequestDispatcher("hotel/order-error.jsp").forward(request, response);
                }
                break;

            case"find":
                idRoom = Integer.parseInt(request.getParameter("idRoom"));
                roomDetail = roomService.getRoomById(idRoom);
                request.setAttribute("room", roomDetail);

                fromDate = java.sql.Date.valueOf(request.getParameter("checkin"));
                toDate = java.sql.Date.valueOf(request.getParameter("checkout"));
                idHotel=findService.getIdHotel(idRoom);

                listEmptyRoom = findService.findEmptyRoom(idHotel,fromDate, toDate);
                addable = false;
                for (RoomDetail room : listEmptyRoom) {
                    if (room.getIdRoom() == roomDetail.getIdRoom()) {
                        addable = true;
                        break;
                    }
                }


                request.setAttribute("fromDate",fromDate);
                request.setAttribute("toDate",toDate);

                if (addable) {
                    String message="Ph&#242;ng " +roomDetail.getNameRoom()+" c&#242;n tr&#7889;ng";
                    request.setAttribute("message", message);
                    request.setAttribute("add","active");
                    request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
                    System.out.println("ok");
                }
                else {
                    String message="Ph&#242;ng" +roomDetail.getNameRoom()+" &#273;&#227; c&#243; kh&#225;ch thu&#234; trong kho&#7843;ng th&#7901;i gian tr&#234;n." +
                            "Vui l&#242;ng ch&#7885;n ph&#242;ng kh&#225;c &#7903; ph&#237;a d&#432;&#7899;i";
                    request.setAttribute("message", message);
                    request.setAttribute("rooms",listEmptyRoom);
                    request.setAttribute("add","disabled");
                    request.getRequestDispatcher("hotel/order.jsp").forward(request, response);
                }
                break;
        }
    }
}



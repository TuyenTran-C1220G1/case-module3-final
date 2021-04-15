package com.company.controller;

import com.company.model.Cart;
import com.company.model.Item;
import com.company.model.RoomDetail;
import com.company.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    RoomService roomService = new RoomService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idRoom"));
        RoomDetail roomDetail = roomService.getRoomById(id);
        if (roomDetail!=null){
            HttpSession session = request.getSession();
            if (session.getAttribute("cart")!=null){
                Cart cart = new Cart();
                List<Item> itemList = new ArrayList<>();
                Item item = new Item();
                item.setIdItem(roomDetail.getIdRoom());
                item.setRoom(roomDetail);
                item.setPrice(roomDetail.getPrice());
                itemList.add(item);
                cart.setItemList(itemList);
                session.setAttribute("cart",cart);
            }else {
                Cart cart =(Cart) session.getAttribute("cart");
                List<Item> itemList = cart.getItemList();
                boolean check = false;
                for (Item item : itemList){
                    if (item.getRoom().getIdRoom() == roomDetail.getIdRoom()) {
                        check = true;
                        break;
                    }
                }
                if (check = false){
                    Item item = new Item();
                    item.setIdItem(roomDetail.getIdRoom());
                    item.setRoom(roomDetail);
                    item.setPrice(roomDetail.getPrice());
                    itemList.add(item);

                }

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

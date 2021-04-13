package com.company.controller;

import com.company.model.City;
import com.company.model.Hotel;
import com.company.service.CityService;
import com.company.service.HotelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet2", value = "/hotel")
public class HotelServlet extends HttpServlet {
    private HotelService hotelService = new HotelService();
    private CityService cityService = new CityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCity = Integer.parseInt(request.getParameter("idCity"));
        System.out.println(idCity);
        List<Hotel> hotelList = hotelService.findHotelByCity(idCity);
        for (Hotel hotel : hotelList) {
            System.out.println(hotel);
        }
        City city = cityService.findCityById(idCity);
        request.setAttribute("city", city);
        request.setAttribute("hotels", hotelList);
        request.getRequestDispatcher("hotel/hotel.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

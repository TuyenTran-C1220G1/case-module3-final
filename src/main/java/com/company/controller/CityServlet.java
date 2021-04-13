package com.company.controller;

import com.company.model.City;
import com.company.service.CityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/city")
public class CityServlet extends HttpServlet {
    private CityService cityService = new CityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cityList = cityService.getAllCity();
        request.setAttribute("cities",cityList);
        request.getRequestDispatcher("hotel/home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

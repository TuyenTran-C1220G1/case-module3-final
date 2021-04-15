package com.company.controller;

import com.company.model.Customer;
import com.company.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("pass");
        Customer customer = loginService.logIn(user, password);
        if (customer == null) {
            request.setAttribute("mess", "Wrong user or password");
            request.getRequestDispatcher("/hotel/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            request.getRequestDispatcher("/city").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

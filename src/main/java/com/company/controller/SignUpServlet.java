package com.company.controller;

import com.company.model.Customer;
import com.company.service.SignUpService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {
    SignUpService service = new SignUpService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameCus");
        String user = request.getParameter("userCus");
        String pass = request.getParameter("passCus");
        String address = request.getParameter("addCus");
        int phone = Integer.parseInt(request.getParameter("phone"));
        Customer customer =service.checkCustomer(user);
        if (customer==null) {
            service.signUp(name, user, pass, address, phone);
            request.getRequestDispatcher("/hotel/login.jsp").forward(request, response);
        }else {
            request.setAttribute("messsignup","Customer is already exist");
            request.getRequestDispatcher("/hotel/signup.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

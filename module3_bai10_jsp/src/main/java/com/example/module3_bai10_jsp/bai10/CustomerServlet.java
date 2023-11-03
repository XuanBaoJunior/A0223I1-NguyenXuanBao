package com.example.module3_bai10_jsp.bai10;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private List<Customer> customers;
    @Override
    public void init() throws ServletException {
        customers.add(new Customer(1L, "H", new Date(), "11 Do Quang", null));
        customers.add(new Customer(2L, "B", new Date(), "11 Ham Nghi", null));
        customers.add(new Customer(3L, "C", new Date(), "11 Le Dinh Ly", null));
        customers.add(new Customer(4L, "R", new Date(), "11 Nguyen Hoang", null));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customers.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

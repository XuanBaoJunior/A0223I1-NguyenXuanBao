package com.example.ss10_list_of_customers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private List<Customer> customerList;
    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1L, "K", new Date(), "11 Do Quang", "image/ip.jpg"));
        customerList.add(new Customer(2L, "A", new Date(), "22 Ham Nghi", "image/ip.jpg"));
        customerList.add(new Customer(3L, "G", new Date(), "33 Nguyen Van Linh", "image/ip.jpg"));
        customerList.add(new Customer(4L, "L", new Date(), "44 Le Dinh Ly", "image/ip.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        request.setAttribute("customers", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customers.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

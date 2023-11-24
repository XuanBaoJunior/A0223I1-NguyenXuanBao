package com.example.case_study_final.controller;

import com.example.case_study_final.model.Customer;
import com.example.case_study_final.service.impl.CustomerService;
import com.example.case_study_final.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = "/FuramaServlet")
public class FuramaServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "searchCustomer":
                searchByCustomer(request, response);
                break;
            default:
                findAllCustomer(request, response);
                break;
        }
    }

    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String keyword = request.getParameter("keyword");
//        List<Customer> customerList = customerService.findAll();
//        request.setAttribute("customerList", customerList);
//        request.setAttribute("keyword", keyword);
//        try {
//            request.getRequestDispatcher("/list.jsp").forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.example.demo.controller;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }
        switch (action){
            case "list":
                goProductList(request, response);
            case "create" :
                showNewProduct(request,response);
                break;
            default:
                goProductList(request, response);
                break;
        }
    }

    private void showNewProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goProductList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productList", ProductDAO.getListProduct());
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                registerNewProduct(request, response);
                break;
        }
    }

    private void registerNewProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = (int) (Math.random() *1000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");

        Product product = new Product(id, name, price, describe, producer);

        ProductDAO.save(product);
        request.setAttribute("message", "Register new product successfully");
        goProductList(request, response);
    }
}

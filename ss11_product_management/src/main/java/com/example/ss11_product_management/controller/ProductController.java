package com.example.ss11_product_management.controller;

import com.example.ss11_product_management.model.Product;
import com.example.ss11_product_management.repository.impl.ProductRepository;
import com.example.ss11_product_management.servicer.IProductServicer;
import com.example.ss11_product_management.servicer.impl.ProductServicer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private ProductServicer productServicer = new ProductServicer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> products = productServicer.getAll();
//        request.setAttribute("products", products);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/list.jsp");
//        dispatcher.forward(request, response);
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case  "create":
                response.sendRedirect("create.jsp");
            default:
                goProductList(request, response);
                break;
        }
    }

    private void goProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productServicer.getAll());
        request.getRequestDispatcher("/products/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "case":
                registerNewProduct(request,response);
                break;
        }
    }

    private void registerNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = (int) (Math.random() *1000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");

        Product product = new Product(id, name, price, describe, producer);

        ProductRepository.save(product);
        request.setAttribute("message", "Register new product successfully");
        goProductList(request, response);
    }
}

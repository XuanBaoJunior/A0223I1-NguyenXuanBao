package com.example.demodb.controller;

import com.example.demodb.model.Product;
import com.example.demodb.servicer.IProductService;
import com.example.demodb.servicer.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                request.getRequestDispatcher("create.jsp").forward(request, response);
            }
            default: {
                request.setAttribute("name", "iphone");
                List<Product> products = productService.getAll();
                request.setAttribute("products", products);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                Integer id = (int) (Math.random() * 1000);
                String name = request.getParameter("name");
                Double price = Double.valueOf(request.getParameter("price"));
                String describe = request.getParameter("describe");
                String producer = request.getParameter("producer");

                Product product = new Product(id, name, price, describe, producer);
                productService.addProduct(product);
                response.sendRedirect("/ProductController");
            }
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                productService.deleteById(id);
                response.sendRedirect("/ProductController");
            }
        }

    }
}


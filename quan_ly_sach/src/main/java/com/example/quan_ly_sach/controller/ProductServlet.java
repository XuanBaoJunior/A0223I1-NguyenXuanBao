package com.example.quan_ly_sach.controller;

import com.example.quan_ly_sach.model.Product;
import com.example.quan_ly_sach.servicer.IProductServicer;
import com.example.quan_ly_sach.servicer.impl.ProductServicer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductServicer iProductServicer = new ProductServicer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(request, response);
                break;
            case "transfer" :
                transfer(request,response);
                break;
            case "information" :
                informationvcProduct(request,response);
                break;
            default:
                getAllProduct(request,response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void informationvcProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
        request.setAttribute("list",iProductServicer.getAllProduct());
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    private void transfer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idupdate"));
        List<Product> product = iProductServicer.getAllProduct().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
        request.setAttribute("list", product);
        try {
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                getAllProduct(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String author = request.getParameter("author");
        String describeBook = request.getParameter("describeBook");
        iProductServicer.createProduct(new Product(name, price, author, describeBook));
        try {
            response.sendRedirect("/ProductServlet?action=null");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price"));
        String author = request.getParameter("author");
        String describeBook = request.getParameter("describeBook");
        iProductServicer.updateProduct(new Product(id, name, price, author,describeBook));
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int iddelete = Integer.parseInt(request.getParameter("idHidden"));
        iProductServicer.deleteProduct(iddelete);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("searchProduct"));
        List<Product> list = iProductServicer.getAllProduct().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

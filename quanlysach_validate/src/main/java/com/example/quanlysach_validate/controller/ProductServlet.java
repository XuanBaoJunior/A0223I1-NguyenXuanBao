package com.example.quanlysach_validate.controller;

import com.example.quanlysach_validate.model.Product;
import com.example.quanlysach_validate.service.CategoryService;
import com.example.quanlysach_validate.service.ICategoryService;
import com.example.quanlysach_validate.service.IProductService;
import com.example.quanlysach_validate.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();
    private ICategoryService iCategoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCreate":
                showCreate(request, response);
                break;
            case "showEdit":
                showEdit(request, response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = iProductService.display();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                createProduct(request, response);
                break;
            case "editProduct":
                editProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
            case "searchList":
                searchList(request, response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void searchList(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        List<Product> list = iProductService.searchName(nameSearch);
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
    }
}

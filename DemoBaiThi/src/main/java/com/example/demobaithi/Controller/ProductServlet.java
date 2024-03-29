package com.example.demobaithi.Controller;

import com.example.demobaithi.Model.Category;
import com.example.demobaithi.Model.Product;
import com.example.demobaithi.Service.CategoryService;
import com.example.demobaithi.Service.ICategoryService;
import com.example.demobaithi.Service.IProductService;
import com.example.demobaithi.Service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
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
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product product = iProductService.edit(id);
        Category category = iCategoryService.findIdCategory(categoryId);
        List<Category> categoryList = iCategoryService.find(categoryId);
        request.setAttribute("product", product);
        request.setAttribute("category", category);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = iCategoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            case "searchPrice":
                searchPrice(request, response);
            default:
                showListProduct(request, response);
        }
    }

    private void searchPrice(HttpServletRequest request, HttpServletResponse response) {
        Double priceSearch = Double.parseDouble(request.getParameter("priceSearch"));
        List<Product> list = iProductService.searchByPrice(priceSearch);
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        int product_id = Integer.parseInt(request.getParameter("id_product"));
        iProductService.delete(product_id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int number = Integer.parseInt(request.getParameter("number"));
        String color = request.getParameter("color");
        String mota = request.getParameter("mota");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category category = new Category(category_id);
        Product product = new Product(id_product, name, price, number, color, mota, category);
        iProductService.update(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int number = Integer.parseInt(request.getParameter("number"));
        String color = request.getParameter("color");
        String mota = request.getParameter("mota");
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = new Category(id);
        Product product = new Product(name, price, number, color, mota, category);
        iProductService.create(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


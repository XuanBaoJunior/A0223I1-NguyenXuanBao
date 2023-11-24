package com.example.product_bank.Controller;

import com.example.product_bank.Model.Bank;
import com.example.product_bank.Model.Product;
import com.example.product_bank.Service.BankService;
import com.example.product_bank.Service.IBankService;
import com.example.product_bank.Service.IProductService;
import com.example.product_bank.Service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();
    private IBankService iBankService = new BankService();
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

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.edit(id);

        int bankId = product.getBank().getId();
        Bank bank = iBankService.findIdBank(bankId);

        List<Bank> bankList = iBankService.find(bankId);

        request.setAttribute("product", product);
        request.setAttribute("bank", bank);
        request.setAttribute("bankList", bankList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Bank> bankList = iBankService.findAll();
        request.setAttribute("bankList", bankList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
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
                break;
        }
    }

    private void searchList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int product_id = Integer.parseInt(request.getParameter("id_product"));
        iProductService.delete(product_id);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("number"));
        String mota = request.getParameter("mota");

        String bankName = request.getParameter("bankName");
        Bank bank = iBankService.findName(bankName);

        Product product = new Product(id_product, name, number, mota, bank);
        iProductService.update(product);

        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int number =Integer.parseInt(request.getParameter("number"));
        String mota = request.getParameter("mota");
        int id = Integer.parseInt(request.getParameter("id"));
        Bank bank = new Bank(id);
        Product product = new Product(name, number, mota, bank);
        iProductService.create(product);
        try {
            response.sendRedirect("ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

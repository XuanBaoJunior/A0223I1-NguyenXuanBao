package com.example.baithimd3.Controller;

import com.example.baithimd3.Model.NguoiThue;
import com.example.baithimd3.Model.PhongTro;
import com.example.baithimd3.Service.INguoiThueService;
import com.example.baithimd3.Service.IPhongTroService;
import com.example.baithimd3.Service.NguoiThueService;
import com.example.baithimd3.Service.PhongTroService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongTroServlet", value = "/PhongTroServlet")
public class PhongTroServlet extends HttpServlet {
    private IPhongTroService iPhongTroService = new PhongTroService();
    private INguoiThueService iNguoiThueService = new NguoiThueService();
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
//            case "showEdit":
//                showEdit(request, response);
//                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<NguoiThue> list = iNguoiThueService.display();
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

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> phongTroList = iPhongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
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
            case "createPT":
                createPhongTro(request, response);
                break;
//            case "editLoaiXe":
//                editLoaiXe(request, response);
//                break;
            case "deletePT":
                deletePhongTro(request, response);
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
        String nameSearch = request.getParameter("nameSearch");
        List<NguoiThue> list = iNguoiThueService.searchName(nameSearch);
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

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) {
        String id_nguoi_thue = request.getParameter("id_nguoi_thue");
        iNguoiThueService.delete(id_nguoi_thue);
        try {
            response.sendRedirect("/PhongTroServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createPhongTro(HttpServletRequest request, HttpServletResponse response) {
        String id_nguoi_thue = request.getParameter("id_nguoi_thue");
        String ten_nguoi_thue = request.getParameter("ten_nguoi_thue");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String ngay_thue = request.getParameter("ngay_thue");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ghi_chu = request.getParameter("ghi_chu");
        PhongTro phongTro = new PhongTro(id, ghi_chu);
        NguoiThue nguoiThue = new NguoiThue(id_nguoi_thue ,ten_nguoi_thue, so_dien_thoai, ngay_thue, phongTro);
        iNguoiThueService.create(nguoiThue);
        try {
            response.sendRedirect("/PhongTroServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

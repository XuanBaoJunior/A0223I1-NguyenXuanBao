package com.example.democar.Controller;

import com.example.democar.Model.Loai_xe;
import com.example.democar.Model.San_xuat;
import com.example.democar.Service.ILoai_xeService;
import com.example.democar.Service.ISan_xuatService;
import com.example.democar.Service.Loai_xeService;
import com.example.democar.Service.San_xuatService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoaiXeServlet", value = "/LoaiXeServlet")
public class LoaiXeServlet extends HttpServlet {
    private ISan_xuatService iSan_xuatService = new San_xuatService();
    private ILoai_xeService iLoai_xeService = new Loai_xeService();
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

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id_loai_xe = Integer.parseInt(request.getParameter("id_loai_xe"));
        int id = Integer.parseInt(request.getParameter("id"));
        Loai_xe loai_xe = iLoai_xeService.edit(id_loai_xe);
        San_xuat san_xuat = iSan_xuatService.findIdSX(id_loai_xe);
        List<San_xuat> san_xuatList = iSan_xuatService.find(id);
        request.setAttribute("loai_xe", loai_xe);
        request.setAttribute("san_xuat", san_xuat);
        request.setAttribute("san_xuatList", san_xuatList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Loai_xe> list = iLoai_xeService.display();
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
        List<San_xuat> san_xuatList = iSan_xuatService.findAll();
        request.setAttribute("san_xuatList", san_xuatList);
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
            case "createLoaiXe":
                createLoaiXe(request, response);
                break;
            case "editLoaiXe":
                editLoaiXe(request, response);
                break;
            case "deleteProduct":
                deleteLoaiXe(request, response);
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
        List<Loai_xe> list = iLoai_xeService.searchName(nameSearch);
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

    private void deleteLoaiXe(HttpServletRequest request, HttpServletResponse response) {
        Integer id_loai_xe = Integer.parseInt(request.getParameter("id_loai_xe"));
        iLoai_xeService.delete(id_loai_xe);
        try {
            response.sendRedirect("/LoaiXeServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editLoaiXe(HttpServletRequest request, HttpServletResponse response) {
        Integer id_loai_xe = Integer.parseInt(request.getParameter("id_loai_xe"));
        String name = request.getParameter("name");
        Double gia_xe = Double.parseDouble(request.getParameter("gia_xe"));
        Integer nam_san_xuat = Integer.parseInt(request.getParameter("nam_san_xuat"));
        String color = request.getParameter("color");
        String mota = request.getParameter("mota");
        Integer id_san_xuat = Integer.parseInt(request.getParameter("id_san_xuat"));
        San_xuat san_xuat = new San_xuat(id_san_xuat);
        Loai_xe loai_xe = new Loai_xe(id_loai_xe, name, gia_xe, nam_san_xuat, color, mota, san_xuat);
        iLoai_xeService.update(loai_xe);
        try {
            response.sendRedirect("/LoaiXeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createLoaiXe(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double gia_xe = Double.parseDouble(request.getParameter("gia_xe"));
        Integer nam_san_xuat = Integer.parseInt(request.getParameter("nam_san_xuat"));
        String color = request.getParameter("color");
        String mota = request.getParameter("mota");
        Integer id = Integer.parseInt(request.getParameter("id"));
        San_xuat san_xuat = new San_xuat(id);
        Loai_xe loai_xe = new Loai_xe(name, gia_xe, nam_san_xuat, color, mota, san_xuat);
        iLoai_xeService.create(loai_xe);
        try {
            response.sendRedirect("/LoaiXeServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

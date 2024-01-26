package com.example.xe_co.Controller;

import com.example.xe_co.Model.Loai_xe;
import com.example.xe_co.Model.San_xuat;
import com.example.xe_co.Service.ILoai_xeService;
import com.example.xe_co.Service.ISan_xuatService;
import com.example.xe_co.Service.Loai_xeService;
import com.example.xe_co.Service.San_xuatService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoaiXeServlet", value = "/LoaiXeServlet")
public class LoaiXeServlet extends HttpServlet {
    private ILoai_xeService iLoai_xeService = new Loai_xeService();
    private ISan_xuatService iSan_xuatService = new San_xuatService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCreate":
                break;
            case "showEdit":
                showEdit(request, response);
                break;
            default:
                showListXe(request, response);
                break;
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id_loai_xe = Integer.parseInt(request.getParameter("id_loai_xe"));
        String id_loai_xe_param = request.getParameter("id_loai_xe");
        int id_loai_xe = (id_loai_xe_param != null && !id_loai_xe_param.isEmpty()) ? Integer.parseInt(id_loai_xe_param) : 0;
        Loai_xe loai_xe = iLoai_xeService.edit(id_loai_xe);

//        int id_nuoc_san_xuat = Integer.parseInt(request.getParameter("id_nuoc_san_xuat"));
        String id_nuoc_san_xuat_param = request.getParameter("id_nuoc_san_xuat");
        int id_nuoc_san_xuat = (id_nuoc_san_xuat_param != null && !id_nuoc_san_xuat_param.isEmpty()) ? Integer.parseInt(id_nuoc_san_xuat_param) : 0;
        San_xuat san_xuat = iSan_xuatService.findIdSX(id_nuoc_san_xuat);

        List<San_xuat> SXlist = iSan_xuatService.find(id_nuoc_san_xuat);

        request.setAttribute("loai_xe", loai_xe);
        request.setAttribute("san_xuat", san_xuat);
        request.setAttribute("SXlist", SXlist);

        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showListXe(HttpServletRequest request, HttpServletResponse response) {
        List<Loai_xe> list = iLoai_xeService.display();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createLX":
                break;
            case "editLX":
                editLX(request, response);
                break;
            default:
                showListXe(request, response);
                break;
        }
    }

    private void editLX(HttpServletRequest request, HttpServletResponse response) {
        int id_loai_xe = Integer.parseInt(request.getParameter("id_loai_xe"));
        String ten_loai_xe = request.getParameter("ten_loai_xe");
        Double gia_xe = Double.parseDouble(request.getParameter("gia_xe"));
        int nam_san_xuat = Integer.parseInt(request.getParameter("nam_san_xuat"));

        String nuoc_san_xuat = request.getParameter("nuoc_san_xuat");
        San_xuat san_xuat = iSan_xuatService.findName(nuoc_san_xuat);

        Loai_xe loai_xe = new Loai_xe(id_loai_xe, ten_loai_xe, gia_xe, nam_san_xuat, san_xuat);
        iLoai_xeService.update(loai_xe);

        try {
            response.sendRedirect("/LoaiXeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

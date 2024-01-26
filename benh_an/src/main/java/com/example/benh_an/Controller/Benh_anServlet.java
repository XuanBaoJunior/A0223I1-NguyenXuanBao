package com.example.benh_an.Controller;

import com.example.benh_an.Model.Benh_an;
import com.example.benh_an.Model.Benh_nhan;
import com.example.benh_an.Service.Benh_anService;
import com.example.benh_an.Service.Benh_nhanService;
import com.example.benh_an.Service.IBenh_anService;
import com.example.benh_an.Service.IBenh_nhanService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Benh_anServlet", urlPatterns = "/BVServlet")
public class Benh_anServlet extends HttpServlet {
    private IBenh_anService iBenh_anService = new Benh_anService();
    private IBenh_nhanService iBenh_nhanService = new Benh_nhanService();
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
            default:
                showDisplay(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {

        List<Benh_nhan> benhNhanList = iBenh_nhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDisplay(HttpServletRequest request, HttpServletResponse response) {
        List<Benh_an> list = iBenh_anService.display();
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
            case "create":
                create(request, response);
                break;
            default:
                showDisplay(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Date ngay_nhap_vien;
        String getDateHtml = request.getParameter("ngaynhapvien");
        ngay_nhap_vien = java.sql.Date.valueOf(LocalDate.parse(getDateHtml, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Date ngay_ra_vien = java.sql.Date.valueOf(LocalDate.parse(request.getParameter("ngayravien"),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        String ly_do = request.getParameter("lydo");
        String id_benh_nhan = request.getParameter("tenBN");
        String ten_benh_nhan = iBenh_nhanService.getNameBN(id_benh_nhan);
        Benh_nhan benh_nhan = new Benh_nhan(id_benh_nhan);
        Benh_an benh_an = new Benh_an(ngay_nhap_vien, ngay_ra_vien, ly_do, benh_nhan);
        Boolean isAdded= iBenh_anService.create(benh_an);
        String addInfo = new String();
        if(isAdded){
             addInfo = "Thêm thành công!";
        }else{
             addInfo = "Thêm thất bại!";
        }
        request.setAttribute("addInfo", addInfo);
    }
}

package com.example.quan_ly_bookk.Controller;

import com.example.quan_ly_bookk.DTO.TheMuonSachDTO;
import com.example.quan_ly_bookk.Service.TheMuonSachService;
import com.example.quan_ly_bookk.Service.impl.TheMuonSachServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TheMuonSachServlet", urlPatterns = "/TheMuonSachServlet")
public class TheMuonSachServlet extends HttpServlet {
    private TheMuonSachService theMuonSachService = new TheMuonSachServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "findAll":
                findAllTheMuonSach(request, response);
                break;
            case "searchByMM":
                searchByTheMuonSach(request, response);
            case "delete":
                deleteByMM(request, response);
                break;
            case "create":
                showCreate(request, response);
                break;
            default:
                findAllTheMuonSach(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        String maMuon = request.getParameter("maMuon");
        String trangThai = request.getParameter("trangThai");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngayMuon = request.getParameter("ngayMuon");
        String ngayTra = request.getParameter("ngayTra");
        Date dateTra = new Date();
        Date dateMuon = new Date();
        try {
            dateTra = simpleDateFormat.parse(ngayTra);
            dateMuon = simpleDateFormat.parse(ngayMuon);
        } catch (ParseException e) {
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
            case "":
                break;
            default:
                findAllTheMuonSach(request, response);
                break;
        }
    }

    private void deleteByMM(HttpServletRequest request, HttpServletResponse response) {
        String deleteMM = request.getParameter("deleteMM");
        theMuonSachService.delete(deleteMM);
        try {
            response.sendRedirect("/TheMuonSachServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        String searchByMM = request.getParameter("searchByMaMuon");
        request.setAttribute("theMuonSachList", theMuonSachService.findById(searchByMM));
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAllTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("theMuonSachList", theMuonSachService.findAll());
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

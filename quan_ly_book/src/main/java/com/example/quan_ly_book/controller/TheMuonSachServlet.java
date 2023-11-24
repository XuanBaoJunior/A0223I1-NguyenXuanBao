package com.example.quan_ly_book.controller;

import com.example.quan_ly_book.model.Book;
import com.example.quan_ly_book.model.Student;
import com.example.quan_ly_book.model.The_muon_sach;
import com.example.quan_ly_book.service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TheMuonSachServlet", urlPatterns = "/TheMuonSachServlet")
public class TheMuonSachServlet extends HttpServlet {
    private The_muon_sachService the_muon_sachService = new The_muon_sachServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    private DetailService detailService = new DetailServiceImpl();
    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){

            case "searchByMM":
                searchByTheMuonSach(request, response);
                break;
            case "delete":
                deleteByMM(request, response);
                break;
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            case "searchById":
                showById(request, response);
                break;
            case "findAllTheMuon":
                findAllTheMuon(request, response);
            default:
                findAllTheMuonSach(request, response);
                break;
        }
    }

    private void findAllTheMuon(HttpServletRequest request, HttpServletResponse response) {
        List<The_muon_sach> theMuonSachList = the_muon_sachService.findAll();
        request.setAttribute("theMuonSachList",theMuonSachList );
        try {
            request.getRequestDispatcher("/listbook.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showById(HttpServletRequest request, HttpServletResponse response) {
        String searchByIdStr = request.getParameter("searchById");
        String bookid = request.getParameter("bookid");
        String studentid = request.getParameter("studentid");
        try {

            request.setAttribute("theMuonSachList", the_muon_sachService.findByIDSach(searchByIdStr, bookid, studentid));

            try {
                request.getRequestDispatcher("/list.jsp").forward(request, response);
//                response.sendRedirect("/listbook.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        String theID = request.getParameter("id");
        String bookid = request.getParameter("bookid");
        String studentid = request.getParameter("studentid");
        The_muon_sach theMuonSach = the_muon_sachService.findByIDSach(theID,bookid,studentid);

        request.setAttribute("bookToUpdate", theMuonSach);
        List<Book> books = bookService.findAll();
        List<Student> students = studentService.findAll();
        request.setAttribute("books",books);
        request.setAttribute("students",students);

        try {
            request.getRequestDispatcher("/muonsach.jsp").forward(request, response);
//            response.sendRedirect("/listbook.jsp");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }


    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Book> books = bookService.findAll();
        List<Student> students = studentService.findAll();
        request.setAttribute("books",books);
        request.setAttribute("students",students);
        try {
            request.getRequestDispatcher("/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteByMM(HttpServletRequest request, HttpServletResponse response) {
        String deleteMM = request.getParameter("deleteMM");
        the_muon_sachService.delete(deleteMM);
        try {
            response.sendRedirect("/TheMuonSachServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
//        String searchByMM = request.getParameter("searchByMaMuon");
//        request.setAttribute("theMuonSachList", the_muon_sachService.findByIDSach(searchByMM));
//        try {
//            request.getRequestDispatcher("/list.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void findAllTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        List<The_muon_sach> theMuonSachList = the_muon_sachService.findAll();
        request.setAttribute("theMuonSachList",theMuonSachList );
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
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
        if(action == null){
            action = "";
        }
        switch (action){

            case "searchByMM":
                searchByTheMuonSach(request, response);
                break;
            case "delete":
                deleteByMM(request, response);
                break;
            case "create":
                cretea(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "searchById":
                searchById(request, response);
                break;
            default:
                findAllTheMuonSach(request, response);
                break;
        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) {

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
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
        int bookID = Integer.parseInt(request.getParameter("bookSelect"));
        Book book = bookService.findById(bookID);
        int studentID = Integer.parseInt(request.getParameter("studentSelect"));
        Student student = studentService.findById(studentID);

        The_muon_sach updatedTheMuonSach = new The_muon_sach(maMuon, trangThai, dateTra, dateMuon, book, student);

        the_muon_sachService.update(updatedTheMuonSach);

        try {
            response.sendRedirect("/TheMuonSachServlet?action=list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void cretea(HttpServletRequest request, HttpServletResponse response) {
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
        int bookID = Integer.parseInt(request.getParameter("bookSelect"));
        Book book = bookService.findById(bookID);
        int studentID= Integer.parseInt(request.getParameter("studentSelect"));
        Student student = studentService.findById(studentID);

        The_muon_sach the_muon_sach = new The_muon_sach(maMuon,trangThai,dateTra,dateMuon,book,student);
        the_muon_sachService.create(the_muon_sach);
        try {
            response.sendRedirect("/TheMuonSachServlet?action=list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.example.ss10_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("calculator.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("numberA"));
        double b = Double.parseDouble(request.getParameter("numberB"));

        String action = request.getParameter("action");
        double rs = a + b;

        switch (action){
            case "+": {
                rs = a + b; break;
            }
            case "-": {
                rs = a - b; break;
            }
            case "x": {
                rs = a * b; break;
            }
            case "/": {
                rs = a / b; break;
            }
        }

        request.setAttribute("NUMBER_A", a);
        request.setAttribute("NUMBER_B", b);
        request.setAttribute("ACTION", action);
        request.setAttribute("RESULT", rs);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}

package com.example.car.controller;

import com.example.car.dto.CarDTO;
import com.example.car.model.Country;
import com.example.car.service.ICarService;
import com.example.car.service.ICountryService;
import com.example.car.service.impl.CarService;
import com.example.car.service.impl.CountryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "carServlet", value = "/carServlet")
public class CarServlet extends HttpServlet {
    private ICountryService iCountryService = new CountryService();
    private ICarService iCarService = new CarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action ="";
        }
        switch (action) {
            case "create":
                List<Country> countryList = iCountryService.getListCountry();
                request.setAttribute("countryList", countryList);
                request.setAttribute("car", iCarService.findAll());
                request.getRequestDispatcher("/car/create.jsp").forward(request, response);
                break;
            default:
                List<CarDTO> car = iCarService.findAllDTO();
                request.setAttribute("listCar", car);
                request.getRequestDispatcher("car/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action ="";
        }
        switch (action) {
            case "create":
                Integer id_car = Integer.valueOf(request.getParameter("id_car"));
                String name_car = request.getParameter("name_car");
                Integer year_of_manufacture = Integer.valueOf(request.getParameter("year_of_manufacture"));
                Double price = Double.parseDouble(request.getParameter("price"));
                String country_manufacture = request.getParameter("country_manufacture");
                CarDTO carDTO = new CarDTO(id_car, name_car, year_of_manufacture, price, country_manufacture);
                iCarService.save(carDTO);
                response.sendRedirect("/car");
                break;
        }
    }
}

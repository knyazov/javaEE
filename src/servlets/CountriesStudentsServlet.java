package servlets;

import DBManager.DBManager;
import Item.Countries;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/countriesStudents")
public class CountriesStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
           ArrayList<Countries> countries = DBManager.getCountries();
           req.setAttribute("countries", countries);
           req.getRequestDispatcher("/countriesStudents.jsp").forward(req, resp);
       }catch (Exception e){
           e.printStackTrace();
           resp.sendRedirect("404.jsp");
       }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

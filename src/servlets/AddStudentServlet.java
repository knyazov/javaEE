package servlets;

import DBManager.DBManager;
import Item.Countries;
import Item.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Countries> countries = DBManager.getCountries();
            req.setAttribute("countries", countries);
            req.getRequestDispatcher("/addStudent.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("404.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String date = req.getParameter("date");
        String city = req.getParameter("city");
        Long countryId = Long.parseLong(req.getParameter("country_id"));

        Countries cnt = DBManager.getCountry(countryId);
        if (cnt != null) {
            Students student = new Students(null, name, surname, date, city, cnt);
            DBManager.addStudent(student);
            resp.sendRedirect("/addStudent?success");
        }else {
            resp.sendRedirect("/addStudent?wrong");
        }

    }
}

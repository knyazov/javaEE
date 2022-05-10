package servlets;

import DBManager.DBManager;
import Footballer.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/third")
public class Chapter1_3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("f_name");
        String surname = req.getParameter("f_surname");
        String club = req.getParameter("c_name");
        int salary = Integer.parseInt(req.getParameter("f_salary"));
        int price = Integer.parseInt(req.getParameter("f_price"));

        Footballer footballer = new Footballer();
        footballer.setName(name);
        footballer.setSurname(surname);
        footballer.setClub(club);
        footballer.setSalary(salary);
        footballer.setTransferPrice(price);

        DBManager.addFootballer(footballer);

        resp.sendRedirect("/home");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

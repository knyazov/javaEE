package servlets;

import DBManager.DBManager;
import Item.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addStudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("date"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String city = req.getParameter("city");

        Students student = new Students(null, name, surname, date, city);
        DBManager.addStudent(student);

        resp.sendRedirect("/addStudent?success");
    }
}

package servlets;

import DBManager.DBManager;
import Item.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/details_student")
public class StudentsDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        Students student = DBManager.getStudent(id);

        if (student!=null){
            req.setAttribute("student", student);
            req.getRequestDispatcher("/details_student.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }

    }
}

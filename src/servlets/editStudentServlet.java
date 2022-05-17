package servlets;

import DBManager.DBManager;
import Item.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/editStudent")
public class editStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String date = req.getParameter("date");
        String city = req.getParameter("city");

        Students student = DBManager.getStudent(id);
        if (student != null) {
            student.setName(name);
            student.setSurname(surname);
            student.setBirth_date(date);
            student.setCity(city);

            if (DBManager.editStudent(student)) {

                resp.sendRedirect("/editStudent?id=" + id + "&success");
            }else {
                resp.sendRedirect("/editStudent?id=" + id + "&wrong");

            }
        } else {
            resp.sendRedirect("/");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = 0L;

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {

        }

        Students student = DBManager.getStudent(id);

        if (student != null) {
            req.setAttribute("student", student);
            req.getRequestDispatcher("/edit_student.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }
}

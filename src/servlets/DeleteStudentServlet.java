package servlets;

import DBManager.DBManager;
import Item.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long id = Long.parseLong(req.getParameter("id"));
            Students student = DBManager.getStudent(id);

            if (student != null) {
                if (DBManager.deleteStudent(student)) {
                    resp.sendRedirect("/");
                } else {
                    resp.sendRedirect("/editStudent?id=" + id + "&wrong");
                }
            } else {
                resp.sendRedirect("/");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/404.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
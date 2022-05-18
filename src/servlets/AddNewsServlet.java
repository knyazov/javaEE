package servlets;

import DBManager.DBManager;
import Item.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header = req.getParameter("header");
        String content = req.getParameter("content");
        String author = req.getParameter("author");
        String type = req.getParameter("type");

        News news = new News(null, header, content, author, type);
        DBManager.addNews(news);

        resp.sendRedirect("/addNews?success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addNews.jsp").forward(req, resp);
    }
}

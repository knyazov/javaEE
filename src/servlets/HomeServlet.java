package servlets;

import DBManager.DBManager;
import Item.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Item> allitems = DBManager.getAllitems();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Good Luck!</h1>");
        out.println("<table cellpadding = '20px'>");
        out.println("<thead>");
        out.println("<tr><th>ID</th><th>NAME</th><th>PRICE</th></tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (Item it :
                allitems) {
            out.println("<tr>");
            out.println("<td>" + it.getId() + "</td>");
            out.println("<td>" + it.getName() + "</td>");
            out.println("<td>" + it.getPrice() + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

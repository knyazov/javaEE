package servlets;

import DBManager.DBManagerFirstTask;
import first_task.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/first")
public class Chapter1_1_Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> users = DBManagerFirstTask.getUser();

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<form action = '/addUser' method = 'get'>");
        pw.println("Name : <input type='text' placeholder='name' name = 'user_name'>");
        pw.println("Surname : <input type=\"text\" placeholder=\"surname:\"  name = \"user_surname\">");
        pw.println("Food : <select name = 'food'><option>Burger</option><option>Hot Dog</option><option>Pizza</option></select><br><br>");
        pw.println("<button>ORDER FOOD</button>");
        pw.println("</form>");
        pw.println(users.get(0).getName() + " " + users.get(0).getSurname() + " ordered " + users.get(0).getFood());
    }
}

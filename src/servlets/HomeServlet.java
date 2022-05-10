package servlets;

import DBManager.DBManager;
import Footballer.Footballer;
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
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
        out.println("<div class = 'container'>");

        out.println("<h3>");
        out.println("First Task");
        out.println("</h3>");

        out.println("<form action = '/first_task' method = 'get'>");
        out.println("<label>");
        out.println("Name: ");
        out.println("</label>");
        out.println("<input type='text' name = 'user_name'>");
        out.println("<label>");
        out.println("Surname: ");
        out.println("<input type='text' name = 'user_surname'>");
        out.println("</label>");
        out.println("<label>");
        out.println("Food: ");
        out.println("</label>");
        out.println("<select name = 'food'>");
        out.println("<option>");
        out.println("Burger");
        out.println("</option>");
        out.println("<option>");
        out.println("Pizza");
        out.println("</option>");
        out.println("<option>");
        out.println("Hot dog");
        out.println("</option>");
        out.println("</select>");
        out.println("<button>");
        out.println("ORDER FOOD");
        out.println("</button>");
        out.println("</form>");



        out.println("<br>");
        out.println("<br>");
        out.println("<br>");

        out.println("<h3>");
        out.println("Third Task");
        out.println("</h3>");

        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<form action = '/third' method = 'post'>");
        out.println("Name: <input type = 'text' name = 'f_name'>");
        out.println("Surname: <input type = 'text' name = 'f_surname'>");
        out.println("Club: <select name = 'c_name'>");
        out.println("<option>");
        out.println("Man City");
        out.println("</option>");
        out.println("<option>");
        out.println("Man UTD");
        out.println("</option>");
        out.println("<option>");
        out.println("Liverpool");
        out.println("</option>");
        out.println("</select>");
        out.println("Salary: <input type = 'text' name = 'f_salary'>");
        out.println("Transfer price: <input type = 'text' name = 'f_price'>");
        out.println("<button>");
        out.println("Add footballer");
        out.println("</button>");
        out.println("</form>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<table cellpadding = '20px' class='table table-striped'>");
        out.println("<thead>");
        out.println("<tr><th>ID</th><th>NAME</th><th>Surname</th><th>Salary</th><th>Club</th><th>TransferPrice</th></tr>");
        out.println("</thead>");
        out.println("<tbody>");
        ArrayList<Footballer> getFootballers = DBManager.getFootballers();
        for (Footballer it: getFootballers) {
            out.println("<tr>");
            out.println("<td>" + it.getId() + "</td>");
            out.println("<td>" + it.getName() + "</td>");
            out.println("<td>" + it.getSurname() + "</td>");
            out.println("<td>" + it.getSalary() + "</td>");
            out.println("<td>" + it.getClub() + "</td>");
            out.println("<td>" + it.getTransferPrice() + "</td>");

            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table");

        out.println("<br>");
        out.println("<br>");
        out.println("<br>");

        out.println("<h3>");
        out.println("Second Task");
        out.println("</h3>");


        out.println("<form action = '/secondTask' method = 'get'>");
        out.println("FULL NAME: <input type = 'text' placeholder = 'Insert full name' name = 'user_name'>");
        out.println("AGE: <input type = 'text' placeholder = 'Insert age' name = 'user_age'>");
        out.println("GENDER : <input type = 'radio' name = 'gender_type'>");
        out.println("<label>");
        out.println("Male  ");
        out.println("</label>");
        out.println("<input type = 'radio' name = 'gender_type'>");
        out.println("<label>");
        out.println("Female");
        out.println("</label>");
        out.println("<button>");
        out.println("SUBMIT");
        out.println("</button>");
        out.println("</form>");

        out.println("<br>");
        out.println("<br>");
        out.println("<br>");

        out.println("<table cellpadding = '20px' class='table table-striped'>");
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
        out.println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

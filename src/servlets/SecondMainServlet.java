package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/secondTask")
public class SecondMainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("user_name");
        Integer age = Integer.parseInt(req.getParameter("user_age"));
        String gender = req.getParameter("gender_type");

        if (gender.equals("male") && age >= 18) {
            out.println("Hello Dear Mister " + name);
        }else if (gender.equals("male") && age < 18){
            out.println("Hello Dude Mister " + name);
        }else if (gender.equals("female") && age >= 18){
            out.println("Hello Dear Miss " + name);
        }else if (gender.equals("female") && age < 18){
            out.println("Hello Dude Miss " + name);
        }
    }
}

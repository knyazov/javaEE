package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cookiesStudents")
public class CookiesStudentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Cookie[] cookies = request.getCookies();
            String cookieValue = "NULL";

            if (cookies!=null){
                for (Cookie c:
                     cookies) {
                    if (c.getName().equals("cookie_name")){
                        cookieValue = c.getValue();
                        break;
                    }
                }
            }
            request.setAttribute("cookieValue", cookieValue);
            request.getRequestDispatcher("/cookiesStudents.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("/404.jsp");
        }
    }
}

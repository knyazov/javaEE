package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cookiesSecondTask")
public class CookiesSecondTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Cookie[] cookies = request.getCookies();
            String name = "";
            String surname = "";
            String age = "";
            String country = "";

            if (cookies!=null){
                for (Cookie c:
                     cookies) {
                    if (c.getName().equals("cookieName")){
                        name = c.getValue();

                    }else if (c.getName().equals("cookieSurname")){
                        surname = c.getValue();
                    }
                    else if (c.getName().equals("cookieAge")){
                        age = c.getValue();
                    }
                    else if (c.getName().equals("cookieCountry")){
                        country = c.getValue();
                    }
                }
            }

            request.setAttribute("uName",name);
            request.setAttribute("uSurname", surname);
            request.setAttribute("uAge", age);
            request.setAttribute("uCountry", country);
            request.getRequestDispatcher("/cookiesSecondTask.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/404.jsp");
        }

    }
}

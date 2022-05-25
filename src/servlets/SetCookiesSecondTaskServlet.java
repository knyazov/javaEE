package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/setCookiesSecondTask")
public class SetCookiesSecondTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Cookie cookieName = new Cookie("cookieName", name);
        Cookie cookieSurname = new Cookie("cookieSurname", surname);
        cookieName.setMaxAge(3600 * 24 * 30);
        cookieSurname.setMaxAge(3600 * 24 * 30);
        response.addCookie(cookieName);
        response.addCookie(cookieSurname);

        response.sendRedirect("/cookiesSecondTask");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

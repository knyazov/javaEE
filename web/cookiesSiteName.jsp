<%@ page import="java.util.ArrayList" %>
<%@ page import="Footballer.Footballer" %>
<%@ page import="Item.*" %><%--
  Created by IntelliJ IDEA.
  User: Akzhol
  Date: 11.05.2022
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String siteName = (String) request.getAttribute("cookieValue");
    %>
    <title><%=siteName%></title>
    <%@include file="vendor/header.jsp"
    %>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <%@include file="vendor/navber_students.jsp" %>
        <div class="col-sm-6 offset-3">
            <h3>
               <%

               %>

            </h3>
            <form action="/setSiteNameCookies" method="post">
                <div class="form-group">
                    <label>
                        SITE NAME :
                    </label>
                    <input type="text" name="cookie_value" class="form-control">
                </div>
                <button class="btn btn-warning mt-3"> SET SITE NAME BY COOKIE </button>
            </form>
            <form action="/deleteSiteNameCookies" method="post">
                <button class="btn btn-danger ml-10">
                    DELETE COOKIE
                </button>
            </form>
        </div>
    </div>
</div>
<div class="footer">
    <%@include file="vendor/footer.jsp" %>
</div>
</body>
</html>

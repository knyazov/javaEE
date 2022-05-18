<%@ page import="java.util.ArrayList" %>
<%@ page import="Footballer.Footballer" %>
<%@ page import="Item.Students" %><%--
  Created by IntelliJ IDEA.
  User: Akzhol
  Date: 11.05.2022
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/headerNews.jsp"
    %>
</head>
<body>


<%@include file="vendor/navbar_news.jsp" %>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">

            <%
                String success = request.getParameter("success");
                if (success != null) {
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                NEWS ADDED SUCCESSFULLY
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>

            <form action="/addNews" method="post">
                <div class="form-group">
                    <label> HEADER: </label>
                    <input type="text" name="header" class="form-control">
                </div>
                <div class="form-group">
                    <label> CONTENT: </label>
                    <input type="text" name="content" class="form-control">
                </div>
                <div class="form-group">
                    <label> AUTHOR: </label>
                    <input type="text" name="author" class="form-control">
                </div>
                <div class="form-group">
                    <label> TYPE: </label>
                    <select name="type" id="">
                        <option value="sport">SPORT</option>
                        <option value="culture">CULTURE</option>
                        <option value="politics">POLITICS</option>
                    </select>
                </div>
                <div class="form-group mt-2">
                    <button class="btn btn-success">ADD NEWS</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="footer">
    <%@include file="vendor/footer_news.jsp" %>
</div>
</body>
</html>

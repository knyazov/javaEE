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
    <%@include file="vendor/header.jsp"
    %>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">

            <%
                Students student = (Students) request.getAttribute("student");
                if (student!=null){
            %>
            <div class="card">
                <h5 class="card-header">
                    <%=
                    student.getName()
                    %>
                    <br>
                    <%=
                    student.getSurname()
                    %>
                </h5>
                <div class="card-body">
                    <h5 class="card-title">

                        <%=
                        student.getBirth_date()
                        %>

                    </h5>
                    <p class="card-text"><%=
                    student.getCity()
                    %></p>
                    <a href="/" class="btn btn-primary">back</a>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
<div class="footer">
    <%@include file="vendor/footer.jsp" %>
</div>
</body>
</html>

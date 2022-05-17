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
    <%@include file="vendor/navber_students.jsp" %>
    <div class="row mt-5">
        <div class="col-sm-12">

            <%
                Students student = (Students) request.getAttribute("student");
                if (student != null) {
            %>
            <div class="col-sm-6 offset-3">

                <%
                    String success = request.getParameter("success");
                    if (success != null) {
                %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    Student added successfully
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    }
                %><%
                String wrong = request.getParameter("wrong");
                if (wrong != null) {
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Student NOT SAVED
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    }
                %>

                <form action="/editStudent" method="post">
                    <input type="hidden" name="id" value="<%=student.getId()%>">
                    <div class="form-group">
                        <label> NAME: </label>
                        <input type="text" name="name" class="form-control" value="<%=student.getName()%>">
                    </div>
                    <div class="form-group">
                        <label> SURNAME: </label>
                        <input type="text" name="surname" class="form-control" value="<%=student.getSurname()%>">
                    </div>
                    <div class="form-group">
                        <label> BIRTH DATE: </label>
                        <input type="date" name="date" class="form-control" value="<%=student.getBirth_date()%>">
                    </div>
                    <div class="form-group">
                        <label> CITY: </label>
                        <input type="text" name="city" class="form-control" value="<%=student.getCity()%>">
                    </div>
                    <div class="form-group mt-2">
                        <button class="btn btn-success">SAVE STUDENT</button>
                    </div>
                </form>
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

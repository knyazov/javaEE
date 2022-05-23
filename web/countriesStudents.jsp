<%@ page import="java.util.ArrayList" %>
<%@ page import="Footballer.Footballer" %>
<%@ page import="Item.Students" %>
<%@ page import="Item.Countries" %><%--
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
        <%@include file="vendor/navber_students.jsp" %>
        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>CODE</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Countries> cities = (ArrayList<Countries>) request.getAttribute("cities");

                    if (cities != null) {
                        for (Countries city :
                                cities) {

                %>
                <tr>
                    <td>
                        <%
                            out.println(city.getId());
                        %>
                    </td>
                    <td>
                        <%=
                        city.getName()
                        %>
                    </td>
                    <td>
                        <%=
                        city.getCode()
                        %>
                    </td>

                    <td>
                        <a href="/details_student?id=<%=city.getId()%>" style="color: aliceblue"
                           class="btn btn-info btn-sm"> details </a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="footer">
    <%@include file="vendor/footer.jsp" %>
</div>
</body>
</html>

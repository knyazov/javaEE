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
        <%@include file="vendor/navber_students.jsp" %>
        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>BIRTHDAY DATE</th>
                    <th>CITY</th>
                    <th>INFO</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("student");

                    if (students != null) {
                        for (Students student :
                                students) {

                %>
                <tr>
                    <td>
                        <%
                            out.println(student.getId());
                        %>
                    </td>
                    <td>
                        <%=
                        student.getName()
                        %>
                    </td>
                    <td>
                        <%=
                        student.getSurname()
                        %>
                    </td>
                    <td>
                        <%=
                        student.getBirth_date()
                        %>
                    </td>
                    <td>
                        <%=
                        student.getCity()
                        %>
                    </td>
                    <td>
                        <a href="/details_student?id=<%=student.getId()%>" style="color: aliceblue"
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

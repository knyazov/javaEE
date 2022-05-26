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

    <title>Title</title>
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
            <%
                String name = (String) request.getAttribute("uName");
                String surname = (String) request.getAttribute("uSurname");
                String age = (String) request.getAttribute("uAge");
                String country = (String) request.getAttribute("uCountry");

            %>
            <form action="/setCookiesSecondTask" method="post">
                <label>
                    NAME :
                </label>
                <input type="text" class="form-control" name="name"
                    <%
                    if (name!=null){
                       %>
                       value="<%=name%>">

                <%
                    }
                %>
                <label>
                    SURNAME :
                </label>
                <input type="text" class="form-control" name="surname" <%
                    if (name!=null){
                       %>
                       value="<%=surname%>">

                <%
                    }
                %>

                <label>
                    AGE :
                </label>
                <label for="customRange2" class="form-label"> AGE </label>
                <input type="range" class="form-range" min="0" max="30" id="customRange2"
                    <%
                    if (age!=null){
                       %>
                       value="<%=age%>">

                <%
                    }
                %>
                >

                <select name="country" id="" <%
                    if (country!=null){
                %>
                        value="<%=country%>">

                    <%
                        }
                    %>>
                    <option value="" id="kaz">
                        KAZAKHSTAN
                    </option>
                    <option value="" id="usa">
                        USA
                    </option>
                    <option value="" id="gb">
                        GREAT BRITAIN
                    </option>
                </select>


                <button class="btn btn-success">SET COOKIE</button>
            </form>

        </div>
    </div>
</div>
<div class="footer">
    <%@include file="vendor/footer.jsp" %>
</div>
</body>
</html>

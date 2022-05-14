<%@ page import="java.util.ArrayList" %>
<%@ page import="Footballer.Footballer" %><%--
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
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>SALARY</th>
                    <th>CLUB</th>
                    <th>PRICE</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Footballer> footballers = (ArrayList<Footballer>) request.getAttribute("footballer");

                    if (footballers != null) {
                        for (Footballer footballer :
                                footballers) {

                %>
                <tr>
                    <td>
                        <%
                            out.println(footballer.getId());
                        %>
                    </td>
                    <td>
                        <%=
                        footballer.getName()
                        %>
                    </td>
                    <td>
                        <%=
                        footballer.getSurname()
                        %>
                    </td>
                    <td>
                        <%=
                        footballer.getSalary()
                        %>
                    </td>
                    <td>
                        <%=
                        footballer.getClub()
                        %>
                    </td>
                    <td>
                        <%=
                        footballer.getTransferPrice()
                        %>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="button" autocomplete="off">
                            <a href="#"></a>
                        </button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>

        <div class="col-sm-12">

            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <a class="navbar-brand" href="#">NEWS.COM</a>
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">All news</a>

                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Culture news</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">Sport news</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">Cinema news</a>
                            </li>
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>

        </div>
    </div>
</div>
</body>
</html>

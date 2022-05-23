<%@ page import="java.util.ArrayList" %>
<%@ page import="Item.News" %><%--
  Created by IntelliJ IDEA.
  User: Akzhol
  Date: 18.05.2022
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/headerNews.jsp" %>
</head>
<body>
<%@include file="/vendor/navbar_news.jsp" %>

<section class="news pt-0">
    <div class="container mt-md-5">
        <h2 class="mx-4 my-0 text-center">Recent News</h2>
        <%
            ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
            if (news != null) {
                for (News newss :
                        news) {
        %>

        <ul class="row d-lg-flex list-unstyled image-block justify-content-center px-lg-0 mx-lg-0">
            <li class="col-lg-4 col-md-5 image-block full-width p-3">
                <div class="image-block-inner">
                    <a class="mh-100" href="#">
                        <img src="https://raw.githubusercontent.com/solodev/recent-blog-posts/master/images/news-1.jpg"
                             alt="LunarXP Wins Space Innovator of the Year Award" class="img-responsive w-100"></a>
                    <span class="hp-posts-cat">Awards</span>
                    <h4 class="mt-3"><a href="#"><%=newss.getHeader()%>></a></h4>
                    <!--  <p></p> -->
                    <a href="/detailsNews" class="read-more">Read more &gt;</a>
                </div><!-- .image-block-inner -->
            </li>
        </ul>
        <%
                }
            }
        %>
    </div>
</section>
</body>
</html>
<%
    String sitename = "FOX NEWS";
%>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)"><%=sitename%>></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">All news</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">Sport</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">Culture</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addNews">ADD NEWS</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-primary" type="button">Search</button>
            </form>
        </div>
    </div>
</nav>
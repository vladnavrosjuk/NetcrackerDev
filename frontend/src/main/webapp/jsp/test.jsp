<%--
  Created by IntelliJ IDEA.
  User: navro
  Date: 04.04.2018
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<jsp:include page="/jsp/blocks/header.jsp"/>
<link href="resources/css/test.css" rel="stylesheet" type="text/css" media="all"/>
<script src="resources/js/custom/test.js"></script>

<body>
<div class="container">
    <div id="sidebar">
        <ul>
            <li><button type="submit" class="btn btn-primary ">
                Show all requests
            </button></li>
            <li><button type="submit" class="btn btn-primary ">
                Show
            </button></li>
            <li><a href="#">Users</a></li>
            <li><a href="#">Sign Out</a></li>
        </ul>
    </div>
    <div class="main-content">
        <a href="#" data-toggle=".container" id="sidebar-toggle">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
        <div class="content">
            <h1>Creating Swipeable Side Menu For the Web</h1>
            <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
        </div>
    </div>
</div>
</div>

</body>
</html>

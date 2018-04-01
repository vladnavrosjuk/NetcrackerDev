<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anpi0316
  Date: 15.03.2018
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<script src="resources/js/libs/bootstrap.min.js"></script>
<script src="resources/js/libs/popper.min.js"></script>
<script src="resources/js/libs/jquery-3.2.1.min.js"></script>
<link href="resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="resources/css/general.css" rel="stylesheet" type="text/css" media="all"/>
<script src="resources/js/custom/login.js"></script>







<jsp:include page="/jsp/blocks/header.jsp"/>
<br>
<!-- Кнопка, открывающее модальное окно -->
</div>
<table class="table">
    <thead>
    <tr>
        <th>Check</th>
        <th>Company name</th>
        <th>Dates</th>
        <th>Status</th>
        <th>Faculty</th>
        <th>Speciality</th>
        <th>Is Min.Av.Score</th>
        <th>Total quantity</th>
        <th>Available quantity</th>
        <th>Name of company</th>
        <th>Practice period</th>
        <th>Show <t ></t></th>


    </tr>
    </thead>
    <tbody>
    <%--<c:forEach items="${facultetList}" var="currentFacultet">--%>
        <tr>
            <td>
               <%--     ${currentFacultet.name}--%>
            </td>
            <td>
               <%--     ${currentFacultet.available}--%>
            </td>
        </tr>
<%--    </c:forEach>--%>
    </tbody>
</table>
</div>
<br>
<div class="container-fluid">
    <diw class="row">
        <div class="col-md-5  "><button type="button" class="btn btn-primary" >
            Edit
        </button></div>
        <div class="col-md-6 "><button type="button" class="btn btn-primary">
            Assign students
        </button></div>
        <div class="col-md-1 "><button type="button" class="btn btn-primary">
          Delete
        </button></div>
    </diw>
</div>
</body>
</html>

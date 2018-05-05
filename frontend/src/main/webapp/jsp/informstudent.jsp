<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <th>L.Name</th>
        <th>F.Name</th>
        <th>Faculty</th>
        <th>Specialty</th>
        <th>Group</th>
        <th>Date practice</th>



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
        <div class="col-md-10  "><button type="button" class="btn btn-primary" >
            take off from practice
        </button></div>

        <div class="col-md-2 "><button type="button" class="btn btn-primary">
            add to practice
        </button></div>
    </diw>
</div>
</body>
</html>

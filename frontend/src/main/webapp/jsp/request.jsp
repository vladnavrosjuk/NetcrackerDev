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
<table
        data-search="true" data-toggle="table"

        data-pagination="true"
        data-page-list="[5, 10, 25, 50, 100, ALL]"
        data-page-size="5"
        class="jsStudentsTable">

    <thead>
    <tr>

        <th  data-checkbox="idStudent"></th>
        <th data-field="surname">First Name</th>
        <th data-field="namestud">Last Name</th>
        <th data-field="speciality">Spec.</th>
        <th data-field="facultet">Facult.</th>
        <th data-field="groupstud">Group</th>
        <th data-field="budjet">Budjet</th>
        <th data-field="avscore">Av.Score</th>
        <th data-field="statusstud">StatusStud</th>

    </tr>
    </thead>
</table >
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

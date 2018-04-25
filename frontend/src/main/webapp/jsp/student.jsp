<%--
  Created by IntelliJ IDEA.
  User: navro
  Date: 25.04.2018
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/blocks/headerstudent.jsp"/>
    <link href="resources/css/menu.css" rel="stylesheet" type="text/css" media="all"/>

    <title>Title</title>
</head>
<body>
<table
        data-toggle="table"




        class="jsStudentsTableRole">

    <thead>
    <tr>


        <th data-field="surname" data-sortable="true">First Name</th>
        <th data-field="namestud" data-sortable="true">Last Name</th>
        <th data-field="speciality" data-sortable="true">Spec.</th>
        <th data-field="facultet" data-sortable="true">Facult.</th>
        <th data-field="groupstud" data-sortable="true">Group</th>
        <th data-field="budjet" data-sortable="true">Budjet</th>
        <th data-field="avscore" data-sortable="true">Av.Score</th>

        <th data-field="name" data-sortable="true">Company</th>
        <th data-field="datestart" data-sortable="true">Date Start</th>
        <th data-field="datefinish" data-sortable="true">Date Finish</th>


    </tr>
    </thead>

</table >


</body>
</html>

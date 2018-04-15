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
<script src="resources/js/custom/allrequest.js"></script>







<jsp:include page="/jsp/blocks/header.jsp"/>
<br>
<!-- Кнопка, открывающее модальное окно -->
</div>
<div class="row">
    <div class="col-6 col-md-4">
        <button type="submit" disabled class="btn btn-success btn-block jsDeleteRequest"><span class="glyphicon glyphicon-ok"></span> Delete</button>
    </div>
    <div class="col-6 col-md-4">
        <button type="submit" data-toggle="modal" data-target="#editRequest"  disabled class="btn btn-success btn-block  jsEditRequest"><span class="glyphicon glyphicon-ok"></span> Edit</button>
    </div>
    <div class="col-6 col-md-4">
        <button type="submit" data-toggle="modal" data-target="#releaseRequest" disabled class="btn btn-success btn-block jsAssignRequest"><span class="glyphicon glyphicon-ok"></span> Release</button>
    </div>
</div>
<table
        data-search="true" data-toggle="table"

        data-pagination="true"
        data-page-list="[5, 10, 25, 50, 100, ALL]"
        data-page-size="5"
        class="jsRequestsTable">

    <thead>
    <tr>

        <th  data-checkbox="idRequest"></th>
        <th data-field="name"> Name Company</th>
        <th data-field="datestart">Date Start</th>
        <th data-field="datefinish">Date Finish</th>
        <th data-field="minavscore">Min.Av.Score</th>
        <th data-field="specialityName">Spec.</th>
        <th data-field="studentsofpractice">Students</th>


        <th data-field="quantity">Quantity</th>


    </tr>
    </thead>

</table >
</div>
<br>
<div class="container-fluid">
    <diw class="row">

    </diw>
</div>



<div class="modal fade" id="releaseRequest" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="AddAssign">Add Student</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">




                <select id="example-getting-started" multiple="multiple" class="jsMultiSelectReleseRequest">
                </select>

                <button type="submit" class="btn btn-success btn-block jsReleaseRequest "><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>




<div class="modal fade" id="editRequest" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="adddrequest">Add request</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <label for="companuname"><span class="glyphicon "></span> Company name</label>
                <input type="text" id ="companuname"class="form-control mb-2 mr-sm-2 jsCompanyNameEdit"  placeholder="Company name">

                <label for="startDate"><span class="glyphicon "></span> Start date</label>
                <input type="date" id="startDate"class="form-control jsStartDateEdit ">

                <label for="finishDate"><span class="glyphicon "></span> Finish date</label>
                <input type="date" id="finishDate"class="form-control jsFinishDateEdit ">

                <label for="minscore"><span class="glyphicon "></span> Min.Av.Score</label>
                <input type="text" id="minscore"class="form-control jsMinAvScoreEdit">

                <label for="idSpecialityEditRequest"><span class="glyphicon "></span>Facultet</label>
                <select class="form-control marginBottom1rem jsSpecialityEditRequest" id="idSpecialityEditRequest">
                </select>

                <label for="quantity"><span class="glyphicon "></span>Quantity</label>
                <input type="text" class="form-control mb-2 mr-sm-2 jsRequestQuantityEdit " id="quantity" placeholder="Quantity">

                <button type="submit" class="btn btn-success btn-block jsAddRequestEdit"><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

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


<jsp:include page="/jsp/blocks/header.jsp"/>
<link href="resources/css/menu.css" rel="stylesheet" type="text/css" media="all"/>
<script src="resources/js/custom/menu.js"></script>


<body>
<div class="container2">
    <div id="sidebar">
        <ul>
            <li class="jsModalCreateFaculty" data-toggle="modal" data-target="#createspeialty"><a class="text-left"> <i class="fa fa-plus"></i> Speciality</a></li>
            <li data-toggle="modal" data-target="#createfaculty"><a class="text-left" > <i class="fa fa-plus"></i> Faculty </a ></li>
            <li  class="jsModalAddRequest" data-toggle="modal" data-target="#addrequest"><a class="text-left"><i class="fa fa-plus" ></i> Request</a></li>
            <li class="jsModalCreateStudent" data-toggle="modal" data-target="#createstudent"><a class="text-left"> <i class="fa fa-plus"></i> Student</a></li>
            <li class="jsModalAssignStudents" data-toggle="modal" data-target="#assignstudents"><a class="text-left">    Assign Students</a></li>
            <li ><a class="text-left" href="/allrequest2"> All Request</a></li>
        </ul>
    </div>
    <div class="main-content">
        <table   data-pagination="true" data-search="true" data-toggle="table" class="jsStudentsTable">

            <thead>
            <tr>

                <th data-checkbox="true" class="bs-checkbox"><input name="btSelectAll" type="checkbox"></th>
                <th data-field="name">First Name</th>
                <th data-field="datestart">Last Name</th>
                <th data-field="datefinish">Email</th>
                <th data-field="minavscore">Username</th>
                <th data-field="quantity">Group</th>
            </tr>
            </thead>
        </table >
    </div>
</div>


<!-- Modal -->

<%-----------------------------------------------------------------------------------------------------------------------------
MODAL-------------------------------ADDREQUEST--
---------------------------------------------------------------------------------------------------------------------------%>

<div class="modal fade" id="addrequest" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                        <input type="text" id ="companuname"class="form-control mb-2 mr-sm-2 jsCompanyName"  placeholder="Company name">

                        <label for="startDate"><span class="glyphicon "></span> Start date</label>
                        <input type="date" id="startDate"class="form-control jsStartDate ">

                        <label for="finishDate"><span class="glyphicon "></span> Finish date</label>
                        <input type="date" id="finishDate"class="form-control jsFinishDate ">

                        <label for="minscore"><span class="glyphicon "></span> Min.Av.Score</label>
                        <input type="text" id="minscore"class="form-control jsMinAvScore">

                        <label for="facultetinrequest"><span class="glyphicon "></span>Facultet</label>
                        <select class="form-control marginBottom1rem jsFacultetinAddRequest" id="facultetinrequest">
                        </select>

                        <label for="quantity"><span class="glyphicon "></span>Quantity</label>
                        <input type="text" class="form-control mb-2 mr-sm-2 jsRequestQuantity " id="quantity" placeholder="Quantity">

                        <button type="submit" class="btn btn-success btn-block jsAddRequest"><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>
<%-----------------------------------------------------------------------------------------------------------------------------
MODAL-------------------------------CREATESTUDENT
-----------------------------------------------------------------------------------------------------------------------------%>
<div class="modal fade" id="createstudent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="AddStudent">Add Student</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                        <label for="inputSurname">Surname</label>
                        <input type="text" class="form-control mb-2 mr-sm-2 jsStudentSurname "id="inputSurname" placeholder="Surname student">

                        <label for="inputName">Name</label>
                        <input type="text" class="form-control mb-2 mr-sm-2 jsStudentName"  id="inputName" placeholder="Name student">

                        <label for="jsFacultyIdInCreateStudentWindowtest">Facultet</label>
                        <select class="form-control marginBottom1rem jsDataUsingAjax" id="jsFacultyIdInCreateStudentWindowtest">
                        </select>

                        <label for="jsFacultyIdInCreateStudentWindow2test">Speciality</label>
                        <select class="form-control marginBottom1rem jsDataUsingAjax2" id="jsFacultyIdInCreateStudentWindow2test">
                        </select>

                        <label for="idInputGroup">Group</label>
                        <input type="text" class="form-control mb-2 mr-sm-2 jsStudentGroup" id="idInputGroup" placeholder="Group">

                        <label for="idBudjet">Budjet</label>
                        <select class="form-control marginBottom1rem jsStudentBudjet" id="idBudjet">
                            <option value=1>Budjet</option>
                            <option value=2>NoBudjet</option>
                        </select>

                        <label for="idAvScore">Av.Score.</label>
                        <input type="text" class="form-control mb-2 mr-sm-2 jsStudentAvScore" id="idAvScore"  placeholder="Av. score">


                        <button type="submit" class="btn btn-success btn-block jsAddStudent "><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>
<%-----------------------------------------------------------------------------------------------------------------------------
MODAL-AssignStudents-
----------------------------------------------------------------------------------------------------------------------------%>
<div class="modal fade" id="assignstudents" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="AddAssign">Add Student</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">


                <select class="form-control marginBottom1rem jsRequestForAssign" >
                </select>

                <select id="example-getting-started" multiple="multiple" class="jsMultiSelect">
                </select>

                <button type="submit" class="btn btn-success btn-block jsAddAssign "><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>

<%---------------------------------------------------------------------------------------------------------------------------
--MODALCREATESPECIALITY--
---------------------------------------------------------------------------------------------------------------------------%>

    <div class="modal fade" id="createspeialty" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title" align="center" id="AddFacultet">Add speciality</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <label for="inlineFormInputId">Name Speciality</label>
                    <input type="text" class="form-control mb-2 mr-sm-2 jsInputPassword " id="inlineFormInputId" placeholder="Name of speciality">

                    <label for="jsFacultyIdInCreateStudentWindow">Facultet</label>
                    <select class="form-control marginBottom1rem jsDataSpeciality" id="jsFacultyIdInCreateStudentWindow">
                    </select>

                    <button type="submit" class="btn btn-success btn-block jsSendData "><span class="glyphicon glyphicon-ok"></span> Create</button>
                </div>
            </div>
        </div>
    </div>


<%---------------------------------------------------------------------------------------------------------------------------
Create Faculty
---------------------------------------------------------------------------------------------------------------------------%>

<div class="modal fade" id="createfaculty" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="ADDSPEC">Add FACULTET</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <label for="inputFacult">Facultet</label>
                <input type="text" class="form-control mb-2 mr-sm-2 jsAddFacultyInput "  id="inputFacult"placeholder="Name of faculty">

                <button type="submit" class="btn btn-success btn-block jsAddFacultyButton "><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>

</div>
</body>
</html>
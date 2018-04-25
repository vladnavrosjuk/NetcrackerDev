<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<style>
    html,body{
        overflow-x:hidden;
        overflow-y:hidden;
    }
</style>

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
    <div  class="main-content">
        <div class="row">
            <div class="col-6 col-md-3">
                <button type="submit" data-toggle="modal" data-target="#infoaboutstudent" disabled class="btn btn-success btn-block  jsModalAboutStudent"><span class="glyphicon glyphicon-ok"></span> About</button>
            </div>
            <div class="col-6 col-md-3">
        <button type="submit" disabled class="btn btn-success btn-block jsTest"><span class="glyphicon glyphicon-ok"></span> Delete</button>
            </div>
            <div class="col-6 col-md-3">
        <button type="submit" data-toggle="modal" data-target="#editStudent" disabled class="btn btn-success btn-block  jsEditStudent"><span class="glyphicon glyphicon-ok"></span> Edit</button>
            </div>
            <div class="col-6 col-md-3">
        <button type="submit" data-toggle="modal" data-target="#releasestudents" disabled class="btn btn-success btn-block jsAssignStudent"><span class="glyphicon glyphicon-ok"></span> Release</button>
            </div>
        </div>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <table
                    data-toggle="table"


                    data-sort-order="asc"
                    data-sort-name="surname"

                    data-pagination="true"
                    data-side-pagination="server"
                    data-page-list="[5, 10, 25, 50, 100]"
                    data-url="/studentTableBootstrap"
                    data-search="true"
                    class="jsStudentsTable">

            <thead>
            <tr>

                <th  data-checkbox="idStudent"></th>
                <th data-field="surname" data-sortable="true">First Name</th>
                <th data-field="namestud" data-sortable="true">Last Name</th>
                <th data-field="speciality" data-sortable="true">Spec.</th>
                <th data-field="facultet" data-sortable="true">Facult.</th>
                <th data-field="groupstud" data-sortable="true">Group</th>
                <th data-field="budjet" data-sortable="true">Budjet</th>
                <th data-field="avscore" data-sortable="true">Av.Score</th>
                <th data-field="statusstud" data-sortable="true">StatusStud</th>


            </tr>
            </thead>

        </table >

        </sec:authorize>



    </div>

</div>
<sec:authorize access="hasRole('ROLE_STUDENT')">
sdksmdkmsdk
</sec:authorize>




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







<div class="modal fade" id="infoaboutstudent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="idinfoaboutstudent">Add request</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table

                       data-toggle="table"



                        class="jsPracticeStudent">

                    <thead>
                    <tr>




                        <th data-field="name" data-sortable="true">Company</th>
                        <th data-field="datestart" data-sortable="true">Date Start</th>
                        <th data-field="datefinish" data-sortable="true">Date Finish</th>
                        <th data-field="minavscore" data-sortable="true">Min.Sc.</th>
                        <th data-field="quantity" data-sortable="true">Count</th>




                    </tr>
                    </thead>

                </table >


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




<div class="modal fade" id="releasestudents" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="isReleaseStudent">idReleaseStudent</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">




                <select id="releaseMultiselect" multiple="multiple" class="jsReleaseMultiSelecr">
                </select>

                <button type="submit" class="btn btn-success btn-block jsRealeaseStudent "><span class="glyphicon glyphicon-ok"></span> Release</button>
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
                <h2 class="modal-title" align="center" id="AddAssign">Assign Student</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <label for="idRequestForAssign">Requests</label>
                <select class="form-control marginBottom1rem jsRequestForAssign" id="idRequestForAssign" >

                </select>
                <label for="example-getting-started">Students</label>


                <select id="example-getting-started" multiple="multiple" class="jsMultiSelect">
                </select>

                <br> </br>

                <button type="submit" class="btn btn-success btn-block jsAddAssign "><span class="glyphicon glyphicon-ok"></span> Create</button>
            </div>
        </div>
    </div>
</div>




<div class="modal fade" id="editStudent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="sad">Add Student</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <label for="inputSurnameEdit">Surname</label>
                <input type="text" class="form-control mb-2 mr-sm-2 jsStudentSurnameEdit "id="inputSurnameEdit" placeholder="Surname student">

                <label for="inputNameEdit">Name</label>
                <input type="text" class="form-control mb-2 mr-sm-2 jsStudentNameEdit"  id="inputNameEdit" placeholder="Name student">

                <label for="jsFacultyIdInCreateStudentWindowtestEdit">Facultet</label>
                <select class="form-control marginBottom1rem jsFacultetEdit" id="jsFacultyIdInCreateStudentWindowtestEdit">
                </select>

                <label for="jsFacultyIdInCreateStudentWindow2testEdit">Speciality</label>
                <select class="form-control marginBottom1rem jsSpecialityEdit" id="jsFacultyIdInCreateStudentWindow2testEdit">
                </select>

                <label for="idInputGroupEdit">Group</label>
                <input type="text" class="form-control mb-2 mr-sm-2 jsStudentGroupEdit" id="idInputGroupEdit" placeholder="Group">

                <label for="idBudjetEdit">Budjet</label>
                <select class="form-control marginBottom1rem jsStudentBudjetEdit" id="idBudjetEdit">
                    <option value=1>Budjet</option>
                    <option value=2>NoBudjet</option>
                </select>

                <label for="idAvScoreEdit">Av.Score.</label>
                <input type="text" class="form-control mb-2 mr-sm-2 jsStudentAvScoreEdit" id="idAvScoreEdit"  placeholder="Av. score">


                <button type="submit" class="btn btn-success btn-block jsUpdateEditStudent "><span class="glyphicon glyphicon-ok"></span> Edit</button>
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
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
<%--
<script src="resources/js/libs/bootstrap.min.js"></script>
<script src="resources/js/libs/popper.min.js"></script>
<script src="resources/js/libs/jquery-3.2.1.min.js"></script>
<link href="resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="resources/css/general.css" rel="stylesheet" type="text/css" media="all"/>
--%>





<jsp:include page="/jsp/blocks/header.jsp"/>

<div class="container-fluid">








    <br>

    <div class="row">



        <div class="col-md-2"><button type="submit" class="btn btn-primary jShowAllReques">
        Show all requests
    </button></div>

    <div class="col-md-2"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addrequest">
        Add request
    </button></div>
    <div class="col-md-2"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createstudent">
        Create student
    </button></div>
    <div class="col-md-2"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#assignstudents">
        Assign students
    </button></div>
    <div class="col-md-2"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createspeialty">
        Create specialty
    </button></div>
    <div class="col-md-2"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createfaculty">
       Create faculty
    </button></div>

<!-- Button trigger modal -->

</div>
</div>

<!-- Modal -->

<%--MODAL-------------------------------ADDREQUEST--%>

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
                <form role="form">
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Company name">

                    </div>
                    <div class="form-group">
                        <label for="startDate"><span class="glyphicon "></span> Start date</label>
                        <input type="date" id="startDate"class="form-control ">
                    </div>
                    <div class="form-group">
                        <label for="startDate"><span class="glyphicon "></span> Finish date</label>
                        <input type="date" id="finishDate"class="form-control ">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Quantity">

                    </div>

                    <button type="submit" class="btn btn-success btn-block "><span class="glyphicon glyphicon-ok"></span> Create</button>
                </form>

            </div>
        </div>
    </div>
</div>












<%--MODAL-------------------------------CREATESTUDENT--%>


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
                <form role="form">
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 " placeholder="Surname student">

                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Name student">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Faculty">

                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Speciality">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 " placeholder="Group">

                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Is budjet">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Av. score">
                    </div>

                    <button type="submit" class="btn btn-success btn-block "><span class="glyphicon glyphicon-ok"></span> Create</button>
                </form>

            </div>
        </div>
    </div>
</div>







<%--MODAL-------------------------------CREATESPECIALITY--%>

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
                <form role="form">
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 jsInputPassword " id="inlineFormInputId" placeholder="Name of speciality">

                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2 jsInputName " id="inlineFormInputName" placeholder="Available faculties">
                    </div>

                    <button type="submit" class="btn btn-success btn-block jsSendData "><span class="glyphicon glyphicon-ok"></span> Create</button>
                    </form>

            </div>
        </div>
    </div>
</div>

<%--MODAL-------------------------------CREATEFACULTY--%>
<div class="modal fade" id="createfaculty" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="exampleModalLabel">Add speciality</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">


                        <form>
                            <div class="form-group">
                                <input type="text" class="form-control mb-2 mr-sm-2 "  placeholder="Name of faculty">


                            </div>
                        </form>
                    </div>


                    <button type="submit" class="btn btn-success btn-block "><span class="glyphicon glyphicon-ok"></span> Create</button>
                </form>
            </div>
        </div>
    </div>
</div>

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
        <th>Is budget</th>
        <th>Average score</th>
        <th>Status</th>
        <th>Name of company</th>
        <th>Practice period</th>
        <th>Show </th>


    </tr>
    </thead>
    <tbody>

        <tr>
        <td>

        </td>
            <td>
                <div class="jsAddedUser">

                </div>
            </td>

        </tr>

    </tbody>
</table>
<div class="form-group">



</div>
</body>
</html>

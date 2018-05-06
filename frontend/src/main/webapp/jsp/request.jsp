<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:include page="/jsp/blocks/headerAllRequest.jsp"/>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSfqj0z4gUb9oF8ZoWwtLmowiqqw2rWUk&callback=initMap">
</script>
<script src="resources/js/custom/geocoder.js"></script>

<script src="resources/js/custom/maps.js"></script>
<style>

    #map {
        height: 400px;
        width: 100%;
    }
</style>








<br>
<!-- Кнопка, открывающее модальное окно -->
</div>
<div class="row">
    <div class="col-6 col-md-2">
        <button type="submit" disabled class="btn btn-success btn-block jsDeleteRequest"><span class="glyphicon glyphicon-ok"></span> Delete</button>
    </div>
    <div class="col-6 col-md-3">
        <button type="submit" data-toggle="modal" data-target="#editRequest"  disabled class="btn btn-success btn-block  jsEditRequest"><span class="glyphicon glyphicon-ok"></span> Edit</button>
    </div>
    <div class="col-6 col-md-2">
        <button type="submit" data-toggle="modal" data-target="#releaseRequest" disabled class="btn btn-success btn-block jsAssignRequest"><span class="glyphicon glyphicon-ok"></span> Release</button>
    </div>

    <div class="col-6 col-md-3">

        <button type="submit" data-toggle="modal" data-target="#registrrequest" disabled  class="btn btn-success btn-block jsRegistrRequestModal"><span class="glyphicon glyphicon-ok"></span> Registr</button>
    </div>
    <div class="col-6 col-md-2">

        <button type="submit" data-toggle="modal" data-target="#modalmaps"   class="btn btn-success btn-block "><span class="glyphicon glyphicon-ok"></span> Map</button>
    </div>
</div>
<table
        data-toggle="table"
        data-search="true"

        data-sort-order="asc"
        data-sort-name="namecompany"

        data-pagination="true"
        data-side-pagination="server"
        data-page-list="[5, 10, 25, 50, 100]"
        data-url="/requestTableBootstrap"
        class="jsRequestsTable">

    <thead>
    <tr>

        <th  data-checkbox="idRequest" ></th>
        <th data-field="name" data-sortable="true"> Name Company</th>
        <th data-field="datestart" data-sortable="true">Date Start</th>
        <th data-field="datefinish" data-sortable="true">Date Finish</th>
        <th data-field="minavscore" data-sortable="true">Min.Av.Score</th>
        <th data-field="specialityName" data-sortable="true">Spec.</th>
        <th data-field="studentsofpractice" data-sortable="true">Students</th>


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

<div class="modal fade" id="modalmaps" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title jsRegistrName" align="center" id="idModalMaps">Map</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" class="form-control mb-2 mr-sm-2 jsSearchInMap"  id="search" placeholder="Map">
                <button type="submit"  class="btn btn-success btn-block jsClickSearch " id="idSearchMapa"><span class="glyphicon glyphicon-ok"></span> Search</button>
                <button type="submit"  class="btn btn-success btn-block jsAddCoordinate" id="idAddCoord"><span class="glyphicon glyphicon-ok"></span> Save</button>


                <div id="map"></div>




            </div>
        </div>
    </div>
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

                <button type="submit" class="btn btn-success btn-block jsReleaseRequest "><span class="glyphicon glyphicon-ok"></span> Release</button>
            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="registrrequest" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title jsRegistrNameRequest" align="center" id="RegRequest">Registr Request</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">


                <label for="idDropdownRequest">Wait Registration</label>
                <select class="form-control marginBottom1rem jsRegistrationRequestDropdown" id="idDropdownRequest">
                </select>

                <br>


                <button type="submit"  class="btn btn-success btn-block jsRegistrNewRequest "><span class="glyphicon glyphicon-ok"></span> Create</button>
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

                <button type="submit" class="btn btn-success btn-block jsAddRequestEdit"><span class="glyphicon glyphicon-ok"></span> Edit</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

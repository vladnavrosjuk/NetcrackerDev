<html>
<head>
    <title>Login page</title>

</head>




<body>
<jsp:include page="/jsp/blocks/headerstudent.jsp"/>


<style>

    #map {
        height: 400px;
        width: 100%;
    }
</style>


<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<div class="container target">

    <br>
    <div class="row">
        <div class="col-md-3">
            <!--left col-->
            <ul class="list-group">

                <li class="list-group-item text-muted " contenteditable="false">Profile</li>
                <li class="list-group-item text-right " ><span class="pull-left"><strong class="">Name</strong></span> <h5 class="jsNameStudent"></h5> </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong class="">SurName</strong></span> <h5 class="jsSurnameStudent"></h5></li>
                <li class="list-group-item text-right " ><span class="pull-left"><strong class="">Spec</strong></span> <h5 class="jsSpecStudent"></h5> </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong class="">Facult</strong></span> <h5 class="jsFacultStudent"></h5></li>
                <li class="list-group-item text-right " ><span class="pull-left"><strong class="">Group</strong></span> <h5 class="jsGroupStudent"></h5> </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong class="">Budjet</strong></span> <h5 class="jsBudjetStudent"></h5></li>
                <li class="list-group-item text-right " ><span class="pull-left"><strong class="">Av.Score</strong></span> <h5 class="jsScoreStudent"></h5> </li>
                <br>
                <button type="submit" class="btn btn-success btn-md btn-block pull-right jsPrint "><span class="glyphicon glyphicon-ok"></span> <i class="fas fa-print">Print</i></button>
                <button type="submit" class="btn btn-success btn-md btn-block pull-right jsViewCoordinate " data-toggle="modal" data-target="#modalmapsStudent"><span class="glyphicon glyphicon-ok"></span> <i class="fa fa-street-view">Coordinate</i></button>
            </ul>




        </div>

        <div class="col-md-9">
        <table
                data-toggle="table"




                class="jsStudentsTableRole">

            <thead>
            <tr>



                <th data-field="name" data-sortable="true">Company</th>
                <th data-field="datestart" data-sortable="true">Date Start</th>
                <th data-field="datefinish" data-sortable="true">Date Finish</th>


            </tr>
            </thead>

        </table >
        </div>

        <!--/col-3-->
    </div>
    <div class="modal fade" id="modalmapsStudent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title jsRegistrName" align="center" id="idModalMaps">Map</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">



                    <div id="map"></div>




                </div>
            </div>
        </div>
    </div>



</div>
</body>
</html>

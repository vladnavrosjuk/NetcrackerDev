

<html>
<head>
<jsp:include page="/jsp/blocks/headerRequest.jsp"/>
<title>Company page</title>
</head>
<body>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<div class="container target">

    <br>
    <div class="row">
        <div class="col-md-3">
            <!--left col-->
            <ul class="list-group">



                <li class="list-group-item text-muted " contenteditable="false">Profile</li>
                <li class="list-group-item text-right " ><span class="pull-left"><strong class="">Company</strong></span> <h5 class="jsNameRequest"></h5> </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong class="">Date Start</strong></span> <h5 class="jsDateStartRequest"></h5></li>
                <li class="list-group-item text-right " ><span class="pull-left"><strong class="">Date Finish</strong></span> <h5 class="jsDateFinishRequest"></h5> </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong class="">Quantity</strong></span> <h5 class="jsQuantityRequest"></h5></li>


                <button type="submit" class="btn btn-success btn-md btn-block pull-right jsPrintRole "><span class="glyphicon glyphicon-ok"></span> <i class="fas fa-print">Print</i></button>
            </ul>




        </div>

        <div class="col-md-9">
            <table
                    data-toggle="table"




                    class="jsRequestTableRole">

                <thead>
                <tr>





                    <th data-field="surname" data-sortable="true">First Name</th>
                    <th data-field="namestud" data-sortable="true">Last Name</th>
                    <th data-field="speciality" data-sortable="true">Spec.</th>
                    <th data-field="facultet" data-sortable="true">Facult.</th>
                    <th data-field="groupstud" data-sortable="true">Group</th>
                    <th data-field="budjet" data-sortable="true">Budjet</th>
                    <th data-field="avscore" data-sortable="true">Av.Score</th>


                </tr>
                </thead>

            </table >
        </div>

        <!--/col-3-->
    </div>



</div>

</body>

    </html>
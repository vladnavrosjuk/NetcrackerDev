
$(document).ready(function() {



    $(".jsButtonExitinAutoriation").click(function (event) {
        event.stopPropagation();
        $.ajax({

            url: 'exitUser',
            type: 'POST',

            contentType: "application/json",
            dataType: 'text',
            mimeType: 'application/json',

            success: function (xhr) {


                window.location.href = xhr;



            }

        });




    })

    $.ajax({
        url: 'setStudentName',
        type: 'GET',
        dataType: 'text',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (name) {
            $(".headerStudent").text(name+" ");


        }

    });
    $.ajax({
        url: 'seTabletStudentRole',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (name) {

            $( ".jsStudentsTableRole" ).bootstrapTable('load', name);




        }

    });
    $.ajax({
        url: 'setInfoAboutStudent',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (student) {


            $(".jsNameStudent").text(student.namestud),
                $(".jsSurnameStudent").text(student.surname),
                $(".jsSpecStudent").text(student.speciality),
                $(".jsFacultStudent").text(student.facultet),
                $(".jsGroupStudent").text(student.groupstud),
                $(".jsBudjetStudent").text(student.budjet),
                $(".jsScoreStudent").text(student.avscore)




        }

    });

    $(".jsViewCoordinate").click(function (event) {




        $.ajax({
            url: 'setStudentCoordinate',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (coordinat) {
                var latlng = new google.maps.LatLng(coordinat.lat, coordinat.lng);
                var options = {
                    zoom: 15,
                    center: latlng,

                };
                map = new google.maps.Map(document.getElementById("map"), options);
                marker = new google.maps.Marker({
                    position: latlng,
                    map: map,
                    title: "Your Company"
                });




            }

        });
    })

    $(".jsPrint").click(function (event) {




    $.ajax({
        url: 'setStudentPrint',
        type: 'GET',
        dataType: 'text',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (name) {


            w=  window.open();
            w.document.write(name);

            w.print();
            w.close();

        }

    });
    })
});

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
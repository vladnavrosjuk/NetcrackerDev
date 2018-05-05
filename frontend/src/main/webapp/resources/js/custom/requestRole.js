
$(document).ready(function() {


    $.ajax({
        url: 'setRequestNameRole',
        type: 'GET',
        dataType: 'text',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (name) {
            $(".headerStudent").text(name);


        }

    });
    $.ajax({
        url: 'getRequestTableRole',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (name) {

            $( ".jsRequestTableRole" ).bootstrapTable('load', name);



        }

    });
    $.ajax({
        url: 'setInfoAboutRequest',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (request) {

            $( ".jsNameRequest" ).text(request.name);
            $( ".jsDateStartRequest" ).text(request.datestart);
            $( ".jsDateFinishRequest" ).text(request.datefinish);
            $( ".jsQuantityRequest" ).text(request.quantity);



        }

    });

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
    $(".jsPrintRole").click(function (event) {




        $.ajax({
            url: 'setRolePrint',
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
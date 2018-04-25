
$(document).ready(function() {
    $(".jstesting").click(function (event) {
        event.stopPropagation();

    })

    $.ajax({
        url: 'setStudentName',
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
});
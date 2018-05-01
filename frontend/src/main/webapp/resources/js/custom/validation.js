$(document).ready(function() {
    validateAddStudent();
    validateeditStudent();
    validateAddRequest();



    $('.jsAddFacultyInput').inputmask('Regex', {
        regex: "([A-Z])\\w{8}"


    });


    $('.jsAddFacultyInput').on("keyup",function () {
        if($ (this).val()!="")
            $( ".jsAddFacultyButton" ).prop('disabled', false);
        else
            $( ".jsAddFacultyButton" ).prop('disabled', true);

    })

    $('.jsInputPassword').inputmask('Regex', {
        regex: "([A-Z])\\w{8}"


    });


    $('.jsInputPassword').on("keyup",function () {
        if($ (this).val()!="")
            $( ".jsSendData" ).prop('disabled', false);
        else
            $( ".jsSendData" ).prop('disabled', true);

    })



})
function validateeditStudent() {


    $('.jsStudentNameEdit').inputmask('Regex', {
        regex: "[A-Z]{1}[a-z]{10}"


    });

    $('.jsStudentGroupEdit').inputmask('Regex', {
        regex: "[0-9]{1,7}"

    });
    $('.jsStudentSurnameEdit').inputmask('Regex', {
        regex: "[A-Z]{1}[a-z]{10}"

    });

    $('.jsStudentAvScoreEdit').inputmask('Regex', {
        regex: "\\d{1}|10"


    });
    $('.jsStudentAvScoreEdit').on("keyup",function () {
        if($('.jsStudentSurnameEdit').val()!=""&&$ (this).val()!=""&&  $('.jsStudentNameEdit').val()!="" &&  $('.jsStudentGroupEdit').val()!="")
            $( ".jsUpdateEditStudent" ).prop('disabled', false);
        else
            $( ".jsUpdateEditStudent" ).prop('disabled', true);

    })

    $('.jsStudentSurnameEdit').on("keyup",function () {
        if($('.jsStudentAvScoreEdit').val()!=""&&$ (this).val()!=""&&  $('.jsStudentNameEdit').val()!="" &&  $('.jsStudentGroupEdit').val()!="")
            $( ".jsUpdateEditStudent" ).prop('disabled', false);
        else
            $( ".jsUpdateEditStudent" ).prop('disabled', true);

    })

    $('.jsStudentNameEdit').on("keyup",function () {
        if($('.jsStudentSurnameEdit').val()!=""&&$ (this).val()!=""&&  $('.jsStudentAvScoreEdit').val()!="" &&  $('.jsStudentGroupEdit').val()!="")
            $( ".jsUpdateEditStudent" ).prop('disabled', false);
        else
            $( ".jsUpdateEditStudent" ).prop('disabled', true);

    })
    $('.jsStudentGroupEdit').on("keyup",function () {
        if($('.jsStudentSurnameEdit').val()!=""&&$ (this).val()!=""&&  $('.jsStudentNameEdit').val()!="" &&  $('.jsStudentAvScoreEdit').val()!="")
            $( ".jsUpdateEditStudent" ).prop('disabled', false);
        else
            $( ".jsUpdateEditStudent" ).prop('disabled', true);

    })



}

function validateAddRequest() {

    $('.jsCompanyName').inputmask('Regex', {
        regex: "([A-Z])\\w+"

    });

    $('.jsMinAvScore').inputmask('Regex', {
        regex: "\\d{1}|10"


    });
    $('.jsRequestQuantity').inputmask('Regex', {
        regex: "\\d{2}|100"


    });
    $('.jsMinAvScore').on("keyup",function () {
        if($('.jsFinishDate').val()!=""&&$('.jsRequestQuantity').val()!=""&&$(this).val()!=""&&  $('.jsStartDate').val()!="" &&  $('.jsCompanyName').val()!="")
            $( ".jsAddRequest" ).prop('disabled', false);
        else
            $( ".jsAddRequest" ).prop('disabled', true);

    })

    $('.jsRequestQuantity').on("keyup",function () {
        if($('.jsFinishDate').val()!=""&&$('.jsMinAvScore').val()!=""&&$(this).val()!=""&&  $('.jsStartDate').val()!="" &&  $('.jsCompanyName').val()!="")
            $( ".jsAddRequest" ).prop('disabled', false);
        else
            $( ".jsAddRequest" ).prop('disabled', true);

    })

    $('.jsCompanyName').on("keyup",function () {
        if($('.jsFinishDate').val()!=""&&$('.jsMinAvScore').val()!=""&&$(this).val()!=""&&  $('.jsStartDate').val()!="" &&  $('.jsRequestQuantity').val()!="")
            $( ".jsAddRequest" ).prop('disabled', false);
        else
            $( ".jsAddRequest" ).prop('disabled', true);

    })
    $(".jsStartDate").change(function() {
        if($('.jsFinishDate').val()!=""&&$('.jsMinAvScore').val()!=""&& $('.jsCompanyName').val()!=""&&  $('.jsStartDate').val()!="" &&  $('.jsRequestQuantity').val()!="")
            $( ".jsAddRequest" ).prop('disabled', false);
        else
            $( ".jsAddRequest" ).prop('disabled', true);


    })
    $(".jsFinishDate").change(function() {
        if($('.jsStartDate').val()!=""&&$('.jsMinAvScore').val()!=""&& $('.jsCompanyName').val()!=""&&  $('.jsStartDate').val()!="" &&  $('.jsRequestQuantity').val()!="")
            $( ".jsAddRequest" ).prop('disabled', false);
        else
            $( ".jsAddRequest" ).prop('disabled', true);


    })



}
function validateAddStudent() {
    $('.jsStudentGroup').inputmask('Regex', {
        regex: "[0-9]{1,7}"

    });
    $('.jsStudentSurname').inputmask('Regex', {
        regex: "[A-Z]{1}[a-z]{10}"

    });
    $('.jsStudentName').inputmask('Regex', {
        regex: "[A-Z]{1}[a-z]{10}"


    });
    $('.jsStudentAvScore').inputmask('Regex', {
        regex: "\\d{1}|10"


    });
    $('.jsStudentAvScore').on("keyup",function () {
        if($('.jsStudentName').val()!=""&&$ (this).val()!=""&&  $('.jsStudentSurname').val()!="" &&  $('.jsStudentGroup').val()!="")
            $( ".jsAddStudent" ).prop('disabled', false);
        else
            $( ".jsAddStudent" ).prop('disabled', true);

    })

    $('.jsStudentName').on("keyup",function () {
        if($('.jsStudentAvScore').val()!=""&&$ (this).val()!=""&&  $('.jsStudentSurname').val()!="" &&  $('.jsStudentGroup').val()!="")
            $( ".jsAddStudent" ).prop('disabled', false);
        else
            $( ".jsAddStudent" ).prop('disabled', true);

    })
    $('.jsStudentSurname').on("keyup",function () {
        if($('.jsStudentAvScore').val()!=""&&$ (this).val()!=""&&  $('.jsStudentName').val()!="" &&  $('.jsStudentGroup').val()!="")
            $( ".jsAddStudent" ).prop('disabled', false);
        else
            $( ".jsAddStudent" ).prop('disabled', true);

    })
    $('.jsStudentGroup').on("keyup",function () {
        if($('.jsStudentAvScore').val()!=""&&$ (this).val()!=""&&  $('.jsStudentName').val()!="" &&  $('.jsStudentSurname').val()!="")
            $( ".jsAddStudent" ).prop('disabled', false);
        else
            $( ".jsAddStudent" ).prop('disabled', true);

    })


}


var  avScore = "([0-9]{1}[.]{1}[0-9]{1,2})|10";
var faculty = "([A-Z])\\w{20}";
var name = "[A-Z]{1}[a-z]{10}";
var group = "[0-9]{1,7}";

$(document).ready(function() {
    validateAddStudent();
    validateeditStudent();
    validateAddRequest();
    hint();


    $('.jsStudentSurname').on("keyup",function () {
        if ( $('.jsStudentSurname').val().length == 0 )
            $('.jsRegEnter').text("Please,fill in the fields with a Latin letter starting with a capital letter!!!");
        else  $('.jsRegEnter').text("");
    })
    $('.jsStudentSurname').blur(function () {
        $('.jsRegEnter').text("");

    })


    $('.jsAddFacultyInput').inputmask('Regex', {
        regex: faculty


    });


    $('.jsAddFacultyInput').on("keyup",function () {
        if($ (this).val()!="")
            $( ".jsAddFacultyButton" ).prop('disabled', false);
        else
            $( ".jsAddFacultyButton" ).prop('disabled', true);

    })

    $('.jsInputPassword').inputmask('Regex', {
        regex: faculty


    });


    $('.jsInputPassword').on("keyup",function () {
        if($ (this).val()!="")
            $( ".jsSendData" ).prop('disabled', false);
        else
            $( ".jsSendData" ).prop('disabled', true);

    })



})
function hint() {



    $('.jsCompanyName').on("keyup",function () {
        if ( $('.jsCompanyName').val().length == 0 )
            $('.jsHintCompanyName').text("Please,fill in the fields with a Latin letter starting with a capital letter!!!");
        else  $('.jsHintCompanyName').text("");
    })
    $('.jsCompanyName').blur(function () {
        $('.jsHintCompanyName').text("");

    })

    $('.jsMinAvScore').on("keyup",function () {
        if ( $('.jsMinAvScore').val().length == 0 )
            $('.jsHintMinScoreRequest').text("Please, fill in the field with numbers only 1 - 10!!!");
        else  $('.jsHintMinScoreRequest').text("");
    })
    $('.jsMinAvScore').blur(function () {
        $('.jsHintMinScoreRequest').text("");

    })

    $('.jsRequestQuantity').on("keyup",function () {
        if ( $('.jsRequestQuantity').val().length == 0 )
            $('.jsHintQuantity').text("Please, fill in the field with numbers only!!!");
        else  $('.jsHintQuantity').text("");
    })
    $('.jsRequestQuantity').blur(function () {
        $('.jsHintQuantity').text("");

    })





    $('.jsStudentGroup').on("keyup",function () {
        if ( $('.jsStudentGroup').val().length == 0 )
            $('.jsHintGroup').text("Please, fill in the field with numbers only!!!");
        else  $('.jsHintGroup').text("");
    })
    $('.jsStudentGroup').blur(function () {
        $('.jsHintGroup').text("");

    })

    $('.jsStudentAvScore').on("keyup",function () {
        if ( $('.jsStudentAvScore').val().length == 0 )
            $('.jsHintAvScore').text(" Please, fill in the field only with numbers up to 10!!!");
        else  $('.jsHintAvScore').text("");
    })
    $('.jsStudentAvScore').blur(function () {
        $('.jsHintAvScore').text("");

    })





    $('.jsStudentSurname').on("keyup",function () {
        if ( $('.jsStudentSurname').val().length == 0 )
            $('.jsHintSurname').text("Please,fill in the fields with a Latin letter starting with a capital letter!!!");
        else  $('.jsHintSurname').text("");
    })
    $('.jsStudentSurname').blur(function () {
        $('.jsHintSurname').text("");

    })

    $('.jsStudentName').on("keyup",function () {
        if ( $('.jsStudentName').val().length == 0 )
            $('.jsHintName').text("Please,fill in the fields with a Latin letter starting with a capital letter!!!");
        else  $('.jsHintName').text("");
    })
    $('.jsStudentName').blur(function () {
        $('.jsHintName').text("");

    })

}
function validateeditStudent() {


    $('.jsStudentNameEdit').inputmask('Regex', {
        regex: name


    });

    $('.jsStudentGroupEdit').inputmask('Regex', {
        regex: group

    });
    $('.jsStudentSurnameEdit').inputmask('Regex', {
        regex: name

    });

    $('.jsStudentAvScoreEdit').inputmask('Regex', {
        regex: avScore


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
        regex: faculty

    });

    $('.jsMinAvScore').inputmask('Regex', {
        regex: avScore


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
        regex: group

    });
    $('.jsStudentSurname').inputmask('Regex', {
        regex: name

    });
    $('.jsStudentName').inputmask('Regex', {
        regex: name


    });
    $('.jsStudentAvScore').inputmask('Regex', {
        regex: avScore


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

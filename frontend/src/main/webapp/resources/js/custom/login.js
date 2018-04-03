/**
 * Created by anpi0316 on 15.03.2018.
 */
$(document).ready(function () {
    var x = document.getElementById("createfaculty");
    var ELEMENTS = {
        CONTAINER_FACULTY: '.jsDataSpeciality',
        INPUT_FACULTY: '.jsAddFacultyInput',
        BUTTON_ADD_FACULTY:'.jsAddFacultyButton',

        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjax',
        CONTAINER_DATA_USING_AJAX2: '.jsDataUsingAjax2',
        INPUT_NAME_AUTOR: '.jsInputNameAutor',
        INPUT_PASSWORD_AUTOR: '.jsInputPassword',
        BUTTON_AUTOR: '.jsButtonAutor',

        INPUT_ID: '.jsInputPassword',
        INPUT_NAME: '.jsInputName',
        SEND_DATA_BTN: '.jsSendData',
        CONTAINER_ADDED_USER: '.jsAddedUser',
        SHOWALL:'.jShowAllReques'
    };

    var $usersContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $facultyContainer = $(ELEMENTS.CONTAINER_FACULTY),
        $usersContainer2 = $(ELEMENTS.CONTAINER_DATA_USING_AJAX2),
        $addedUserContainer = $(ELEMENTS.CONTAINER_ADDED_USER),
        $sendDataBtn = $(ELEMENTS.SEND_DATA_BTN),
        $showall =$(ELEMENTS.SHOWALL),
        $buttonAddFaculty = $(ELEMENTS.BUTTON_ADD_FACULTY),
        $buttonAutoe  =$ (ELEMENTS.BUTTON_AUTOR);


    $( ".jsModalCreateFaculty" ).click(function (event) {
        /*       event.stopPropagation();*/


        $.ajax({
            url: 'dropdown',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $facultyContainer.text('');
                users ? function () {


                    users.some(function (user) {

                        $facultyContainer.append('<option value="'+user.id+'">'+user.name+'</option>')
                    });
                }() : false;
            }

        });
    })

    $( ".jsModalCreateStudent" ).click(function (event) {
        /*       event.stopPropagation();*/


        $.ajax({
            url: 'dropdown',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $usersContainer.text('');
                users ? function () {


                    users.some(function (user) {

                        $usersContainer.append('<option value="'+user.id+'">'+user.name+'</option>')
                    });
                }() : false;
            }

        });
    })
    $( ".jsModalCreateStudent" ).click(function (event) {
 /*       event.stopPropagation();*/


        $.ajax({
            url: 'specialityfor1',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $usersContainer2.text('');
                users ? function () {


                    users.some(function (user) {

                        $usersContainer2.append('<option value="'+user.id+'">'+user.name+'</option>')
                    });
                }() : false;
            }

        });
    })

    $( ".jsDataUsingAjax" ).change(function() {
        var obj = {


            facultetId : $(".jsDataUsingAjax option:selected").attr("value")

        };

        $.ajax({
            url: 'dropDown2',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (users) {
                $usersContainer2.text('');

                users ? function () {
                    users.some(function (user) {

                        $usersContainer2.append('<option value="'+user.id+'">'+user.name+'</option>')
                    });
                }() : false;
            }

        });



    });

    $buttonAddFaculty.click(function (event) {
        event.stopPropagation();
        $showall.click(function (event) {
            event.stopPropagation();
            $.ajax({
                url: 'allrequest2',
                type: 'GET',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: '',
                success: function () {

                }

            });
        });

    })


    $sendDataBtn.click(function (event) {
        event.stopPropagation();

        var obj = {
            name : $(ELEMENTS.INPUT_PASSWORD_AUTOR).val(),

            facultetId : $(".jsDataSpeciality option:selected").attr("value")

        };

        $.ajax({
            url: 'addSpeciality',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {


            }

        });
    });

    $(".jsAddStudent").click(function (event) {
        event.stopPropagation();

        var obj = {


            namefaculity : $(".jsDataUsingAjax option:selected").attr("value"),
            specialityid : $(".jsDataUsingAjax2 option:selected").text(),
            surname :$(".jsStudentSurname").val(),

            namestud:$(".jsStudentName").val(),
            groupstud:$(".jsStudentGroup").val(),
            budjet: $(".jsStudentBudjet option:selected").text(),
            avscore:$(".jsStudentAvScore").val(),

        };

        $.ajax({
            url: 'addStudent',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {


            }

        });
    });




    $buttonAddFaculty.click(function (event) {
        event.stopPropagation();

        var obj = {

            name: $(ELEMENTS.INPUT_FACULTY).val()
        };

        $.ajax({
            url: 'addFacultet',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                /*  $("#createfaculty").modal('toogle');*/
                x.close();
                /* $addedUserContainer.append(addedUser ? addedUser.name : '');*/
                /*  window.location.href ="/admin-page"*/
            }

        });
    });





});
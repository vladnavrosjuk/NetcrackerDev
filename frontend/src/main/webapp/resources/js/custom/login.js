/**
 * Created by anpi0316 on 15.03.2018.
 */
$(document).ready(function () {

    var ELEMENTS = {
        INPUT_FACULTY: '.jsAddFacultyInput',
        BUTTON_ADD_FACULTY:'.jsAddFacultyButton',

           CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjax',
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
        $addedUserContainer = $(ELEMENTS.CONTAINER_ADDED_USER),
        $sendDataBtn = $(ELEMENTS.SEND_DATA_BTN),
        $showall =$(ELEMENTS.SHOWALL),
        $buttonAddFaculty = $(ELEMENTS.BUTTON_ADD_FACULTY),
        $buttonAutoe  =$ (ELEMENTS.BUTTON_AUTOR);



    $.ajax({
        url: 'dropdown',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (users) {
            users ? function () {
                users.some(function (user) {

                    $usersContainer.append('<option value="'+user.id+'">'+user.name+'</option>')
                });
            }() : false;
        }

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
                window.location.href ="/allrequest"
            }

        });
    });

    })


    $sendDataBtn.click(function (event) {
        event.stopPropagation();

        var obj = {

            name: $(ELEMENTS.INPUT_NAME).val()
        };

        $.ajax({
            url: 'users',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                $addedUserContainer.append(addedUser ? addedUser.name : '');
              /*  window.location.href ="/admin-page"*/
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
                $("#createfaculty").modal('toogle');
               /* $addedUserContainer.append(addedUser ? addedUser.name : '');*/
                /*  window.location.href ="/admin-page"*/
            }

        });
    });





});
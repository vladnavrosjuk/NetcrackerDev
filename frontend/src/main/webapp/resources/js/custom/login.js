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


/*Подгрузка студентов в multiselect*/

    $( ".jsModalAssignStudents" ).click(function (event) {
             $.ajax({
            url: 'dropdownStudent',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (students) {
                $('.jsMultiSelect').text('');
                students ? function () {
                    students.some(function (student) {

                        $('.jsMultiSelect').append('<option value="'+student.id+'">'+student.surname+'</option>')

                    });
                    $('.jsMultiSelect').attr('multiple','multiple');
                    $('.jsMultiSelect').multiselect();
                }() : false;
            }
        });
    })
/*
-----------------------------------------------------------------------------------------------------------------------
    Подгрузка запросов в dropdown
-----------------------------------------------------------------------------------------------------------------------
*/


    $( ".jsModalAssignStudents" ).click(function (event) {
            $.ajax({
            url: 'dropdownRequest',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $('.jsRequestForAssign').text('');
                users ? function () {
                    users.some(function (user) {
                        $('.jsRequestForAssign').append('<option value="'+user.id+'">'+user.namecompany+'</option>')
                    });

                }() : false;
            }
        });
    })
    /*
    -----------------------------------------------------------------------------------------------------------------------
        Подгрузка факультетов в dropdown
    -----------------------------------------------------------------------------------------------------------------------
    */
    $( ".jsModalCreateFaculty" ).click(function (event) {
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
    /*
-----------------------------------------------------------------------------------------------------------------------
    Подгрузка фаультетов в dropdown
-----------------------------------------------------------------------------------------------------------------------
*/
    $( ".jsModalCreateStudent" ).click(function (event) {
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
    /*
-----------------------------------------------------------------------------------------------------------------------
    Подгрузка специальностей в dropdown
-----------------------------------------------------------------------------------------------------------------------
*/
    $( ".jsModalCreateStudent" ).click(function (event) {
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
    /*
-----------------------------------------------------------------------------------------------------------------------
        Подгрузка специальнсотей в dropdown в зависмотси от выбранного факульета
-----------------------------------------------------------------------------------------------------------------------
    */
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
    /*
    -----------------------------------------------------------------------------------------------------------------------
  ?
    -----------------------------------------------------------------------------------------------------------------------
    */
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
    /*
    -----------------------------------------------------------------------------------------------------------------------
    Сопоставление запроса со студентом
    -----------------------------------------------------------------------------------------------------------------------
    */

    $(".jsAddAssign").click(function (event) {
        event.stopPropagation();

        var obj = {
            students :  $('#example-getting-started').val(),
            requestId : $(".jsRequestForAssign option:selected").attr("value")
        };

        $.ajax({
            url: 'addAssign',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
            }

        });
    });
/*
-----------------------------------------------------------------------------------------------------------------------
Добавление специальности
-----------------------------------------------------------------------------------------------------------------------
*/
        $sendDataBtn.click(function (event) {
        event.stopPropagation();
        var obj = {
            name : $(ELEMENTS.INPUT_PASSWORD_AUTOR).val(),
            facultetId : $(".jsDataSpeciality option:selected").attr("value")
        };

        $.ajax({
            url: 'addSpeciality',
            type: 'POST',
            dataType: 'text',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                noty({ text: 'Специальность '+obj.name+' создана!'});
                $("#createspeialty").modal('toggle');


            }

        });
    });
        /*
-----------------------------------------------------------------------------------------------------------------------
        Подгрузка факультетов в dropdown окна запроса
-----------------------------------------------------------------------------------------------------------------------
    */



    $( ".jsModalAddRequest" ).click(function (event) {
            $.ajax({
            url: 'dropdown',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $( ".jsFacultetinAddRequest" ).text('');
                users ? function () {
                    users.some(function (user) {
                        $( ".jsFacultetinAddRequest" ).append('<option value="'+user.id+'">'+user.name+'</option>')
                    });
                }() : false;
            }

        });
    })
/*
-----------------------------------------------------------------------------------------------------------------------
    Добавление запроса
-----------------------------------------------------------------------------------------------------------------------
    */
    $(".jsAddRequest").click(function (event) {
        event.stopPropagation();

        var obj = {
        namecompany: $(".jsCompanyName").val(),
        datestart:$(".jsStartDate").val(),
        datefinish:$(".jsFinishDate").val(),
        minavscore:$(".jsMinAvScore").val(),
        facultetid: $(".jsFacultetinAddRequest option:selected").attr("value"),
            quantity : $(".jsRequestQuantity").val(),
        };

        $.ajax({
            url: 'addRequest',
            type: 'POST',
            dataType: 'text',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                noty({ text: 'Запрос компании '+obj.namecompany+' создан!'});
                $("#addrequest").modal('toggle');

            }

        });
    });

    /*
-----------------------------------------------------------------------------------------------------------------------
       Добавление студента
----------------------------------------------------------------------------------------------------------------------
    */
    $(".jsAddStudent").click(function (event) {
        event.stopPropagation();
        var obj = {
            namefaculity : $(".jsDataUsingAjax option:selected").attr("value"),
            specialityid : $(".jsDataUsingAjax2 option:selected").attr("value"),
            surname :$(".jsStudentSurname").val(),
            namestud:$(".jsStudentName").val(),
            groupstud:$(".jsStudentGroup").val(),
            budjet: $(".jsStudentBudjet option:selected").text(),
            avscore:$(".jsStudentAvScore").val(),

        };




        $.ajax({

            url: 'addStudent',
            type: 'POST',
            dataType: 'text',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function () {
                noty({ text: 'Студент '+obj.namestud+' '+obj.surname+' создан!'});
                $("#createstudent").modal('toggle');
            }

        });
    });


    /*
-----------------------------------------------------------------------------------------------------------------------
       Добавление факультета
----------------------------------------------------------------------------------------------------------------------
    */


    $buttonAddFaculty.click(function (event) {
        event.stopPropagation();

        var obj = {

            name: $(ELEMENTS.INPUT_FACULTY).val()
        };

        $.ajax({
            url: 'addFacultet',
            type: 'POST',
            dataType: 'text',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                noty({ text: 'Факультет '+obj.name+' создан!'});
                $("#createfaculty").modal('toggle');
            }

        });
    });





});
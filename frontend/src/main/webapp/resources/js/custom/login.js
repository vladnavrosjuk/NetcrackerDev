/**
 * Created by anpi0316 on 15.03.2018.
 */
$(document).ready(function () {
    var x = document.getElementById("createfaculty");
    var indexeow =1 ;
    var indexRequest = 0;
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

    $(".jsMenyRequest").click(function (event) {
        $.ajax({
            url: 'requestsForTable',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (students) {
                $( ".jsRequestsTable" ).bootstrapTable('load', students);


            }

        });

    })

    $.ajax({
        url: 'requestsForTable',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (students) {
            $( ".jsRequestsTable" ).bootstrapTable('load', students);


        }

    });
    $.ajax({
        url: 'checkDatePractice',
        type: 'POST',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (students) {



        }

    });






    $.ajax({
        url: 'studentsForTable',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (students) {
            $( ".jsStudentsTable" ).bootstrapTable('load', students);


        }

    });
    $( ".jsStudentsTable" ).on('check.bs.table', function (e, row, $el) {
       indexeow =  $el.closest('tr').data('index');
    });
    $( ".jsRequestsTable" ).on('check.bs.table', function (e, row, $el) {
        indexRequest =  $el.closest('tr').data('index');
    });


    $( ".jsRequestForAssign" ).change(function() {

        var obj = {
            id : $(".jsRequestForAssign option:selected").attr("value")
        };
        $.ajax({
            url: 'ogr',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {

                students ? function () {



                    $('.jsMultiSelect').change(function () {
                        var count = $(".jsMultiSelect :selected").length;

                        if (count>students.quantity)
                        {      noty({ text: 'Вы превысили кол-во выборов'});

                            $( ".jsAddAssign" ).prop('disabled', true);

                        }
                        else { $( ".jsAddAssign" ).prop('disabled', false);}


                            })





                    // $('.jsMultiSelect').attr('multiple','multiple');

                }() : false;
            }
        });
    });

/*Подгрузка студентов в multiselect*/

   /* $( ".jsModalAssignStudents" ).click(function (event) {
             $.ajax({
            url: 'dropdownStudent',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
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
    })*/
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
                        $('.jsRequestForAssign').append('<option value="'+user.id+'">'+user.namecompany+" Min.Score:"+user.minavscore+" Quantity:"+user.quantity+'</option>')
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





    $( ".jsRequestForAssign" ).change(function() {

        var obj = {
            id : $(".jsRequestForAssign option:selected").attr("value")
        };
        $.ajax({
            url: 'multiselectForRequest',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $('.jsMultiSelect').text('');
                students ? function () {
                    students.some(function (student) {


                        $('.jsMultiSelect').append('<option value="'+student.id+'">'+student.surname+' '+student.namestud+' '+student.avscore+'</option>');


                    });
                    $('.jsMultiSelect').multiselect('rebuild');



                   // $('.jsMultiSelect').attr('multiple','multiple');

                }() : false;
            }
        });
    });
    $('.jsMultiSelect').multiselect({
        buttonWidth: '400px',
        maxHeight: 400,
        includeSelectAllOption: true,
        enableFiltering: true,
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
    $( ".jsFacultetEdit" ).change(function() {
        var obj = {
            facultetId : $(".jsFacultetEdit option:selected").attr("value")
        };
        $.ajax({
            url: 'dropDown2',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (users) {
                $( ".jsSpecialityEdit" ).text('');
                users ? function () {
                    users.some(function (user) {
                        $( ".jsSpecialityEdit" ).append('<option value="'+user.id+'">'+user.name+'</option>')
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


    var list = $( ".jsStudentsTable" ).bootstrapTable('getSelections');

    $(".jsRealeaseStudent").click(function (event) {
        event.stopPropagation();

        var ids =  $.map($( ".jsStudentsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idStudent;});

        var obj = {
            listid :ids,
            requestsId :  $('.jsReleaseMultiSelecr').val(),

        };

        $.ajax({
            url: 'releaseStudents',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                $( ".jsStudentsTable" ).bootstrapTable('updateRow', {
                    index: indexeow,
                    row: addedUser
                });


            }

        });
    });
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
          //      $( ".jsStudentsTable" ).bootstrapTable('destroy');
                $( ".jsStudentsTable" ).bootstrapTable('load',addedUser);


            }

        });
    });
    $( ".jsEditStudent" ).click(function (event) {
        $.ajax({
            url: 'dropdown',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $(".jsFacultetEdit").text('');
                users ? function () {
                    users.some(function (user) {
                        $(".jsFacultetEdit").append('<option value="'+user.id+'">'+user.name+'</option>')
                    });
                }() : false;
            }
        });
    })
    $( ".jsEditStudent" ).click(function (event) {
        $.ajax({
            url: 'dropdownSpeciality',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $( ".jsSpecialityEdit" ).text('');
                users ? function () {
                    users.some(function (user) {
                        $( ".jsSpecialityEdit" ).append('<option value="'+user.id+'">'+user.name+'</option>')

                    });
                }() : false;
            }

        });
    })





    $(".jsEditStudent").click(function (event) {
        $(".jsStudentSurnameEdit").val(""),
            $(".jsFacultetEdit").val("");
        $(".jsSpecialityEdit").val(""),
            $(".jsStudentNameEdit").val(""),
            $(".jsStudentGroupEdit").val(""),


            $(".jsStudentAvScoreEdit").val("");

        var ids =  $.map($( ".jsStudentsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idStudent;});


        var obj = {
            listid :  ids,

        };




        $.ajax({
            url: 'editRowStudent',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                $(".jsStudentSurnameEdit").val(addedUser.surname),
                $(".jsFacultetEdit").val(addedUser.facultetid);
                $(".jsSpecialityEdit").val(addedUser.specialityId),
                    $(".jsStudentNameEdit").val(addedUser.namestud),
                    $(".jsStudentGroupEdit").val(addedUser.groupstud),
                    $(".jsStudentBudjetEdit").val(addedUser.budjetId),


                    $(".jsStudentAvScoreEdit").val(addedUser.avscore);







            }

        });
    });






    $(".jsTest").click(function (event) {

        var ids =  $.map($( ".jsStudentsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idStudent;});

        var obj = {
            listid :  ids,

        };

        $( ".jsEditStudent" ).prop('disabled', true);
        $( ".jsTest" ).prop('disabled', true);
        $( ".jsAssignStudent" ).prop('disabled', true);

        $( ".jsStudentsTable" ).bootstrapTable('remove', {
            field: 'idStudent',
            values: ids
        });

        $.ajax({
            url: 'testel',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                alert("lol");
                $( ".jsStudentsTable" ).bootstrapTable('remove', {
                    field: 'idStudent',
                    values: ids
                });

            }

        });
    });
   /* $(".jsTest").click(function () {
        var ids = $.map($( ".jsStudentsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;
        });
        $( ".jsStudentsTable" ).bootstrapTable('remove', {
            field: 'idRequest',
            values: ids
        });
    });*/
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
                $("#createspeialty").modal('hide');



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
            url: 'dropdownSpeciality',
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
    $( ".jsStudentsTable" ).on('check.bs.table', function (e, clickedUser) {
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditStudent" ).prop('disabled', false);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', false);


        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', true);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }

    });
    $( ".jsStudentsTable" ).on('uncheck.bs.table', function (e, clickedUser) {
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditStudent" ).prop('disabled', false);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', false);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', true);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }

    });



    $( ".jsStudentsTable" ).on('uncheck-all.bs.table', function (e, clickedUser) {
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditStudent" ).prop('disabled', false);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', false);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', true);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }

    });




    $( ".jsStudentsTable" ).on('check-all.bs.table', function (e, clickedUser) {
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditStudent" ).prop('disabled', false);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', false);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', true);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }

    });


    $( ".jsStudentsTable" ).on('uncheck.bs.table', function (e, clickedUser) {
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditStudent" ).prop('disabled', false);
            $( ".jsTest" ).prop('disabled', false);
            $( ".jsAssignStudent" ).prop('disabled', false);

        }
        if($( ".jsStudentsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditStudent" ).prop('disabled', true);
            $( ".jsTest" ).prop('disabled', true);
            $( ".jsAssignStudent" ).prop('disabled', true);

        }

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
            budjet: $(".jsStudentBudjetEdit option:selected").text(),
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
                $( ".jsStudentsTable" ).bootstrapTable('append', addedUser);

                $( ".jsStudentsTable" ).bootstrapTable('scrollTo', 'bottom');
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

    $( ".jsRequestsTable" ).on('check-all.bs.table', function (e, clickedUser) {
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', true);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditRequest" ).prop('disabled', false);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', false);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', true);
            $( ".jsAssignRequest" ).prop('disabled', true);
        }

    });

    $( ".jsRequestsTable" ).on('uncheck-all.bs.table', function (e, clickedUser) {
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', true);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditRequest" ).prop('disabled', false);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', false);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', true);
            $( ".jsAssignRequest" ).prop('disabled', true);
        }

    });

    $( ".jsRequestsTable" ).on('check.bs.table', function (e, clickedUser) {
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', true);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditRequest" ).prop('disabled', false);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', false);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', true);
            $( ".jsAssignRequest" ).prop('disabled', true);
        }

    });


    $( ".jsRequestsTable" ).on('uncheck.bs.table', function (e, clickedUser) {
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length > 1)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', true);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 1)
        {
            $( ".jsEditRequest" ).prop('disabled', false);
            $( ".jsDeleteRequest" ).prop('disabled', false);
            $( ".jsAssignRequest" ).prop('disabled', false);

        }
        if($( ".jsRequestsTable" ).bootstrapTable('getSelections').length == 0)
        {
            $( ".jsEditRequest" ).prop('disabled', true);
            $( ".jsDeleteRequest" ).prop('disabled', true);
            $( ".jsAssignRequest" ).prop('disabled', true);
        }

    });














    $(".jsUpdateEditStudent").click(function (event) {
        event.stopPropagation();
        var ids =  $.map($( ".jsStudentsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idStudent;});
        var obj = {
            listid: ids,
            facultetid : $(".jsFacultetEdit option:selected").attr("value"),
            specialityId : $(".jsSpecialityEdit option:selected").attr("value"),
            surname :$(".jsStudentSurnameEdit").val(),
            namestud:$(".jsStudentNameEdit").val(),
            groupstud:$(".jsStudentGroupEdit").val(),
            budjet: $(".jsStudentBudjetEdit option:selected").text(),
            avscore:$(".jsStudentAvScoreEdit").val(),

        };





        $.ajax({

            url: 'editStudentBase',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                $( ".jsStudentsTable" ).bootstrapTable('updateRow', {
                    index: indexeow,
                    row: addedUser
                });


            }

        });
    });







    $( ".jsAssignStudent" ).click(function() {


        var ids =  $.map($( ".jsStudentsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idStudent;});


        var obj = {
            listid: ids,
        };
        $.ajax({
            url: 'releseStydentPractice',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $('.jsReleaseMultiSelecr').text('');
                students ? function () {
                    students.some(function (student) {


                        $('.jsReleaseMultiSelecr').append('<option value="'+student.id+'">'+student.namecompany+'</option>');


                    });
                    $('.jsReleaseMultiSelecr').multiselect('rebuild');



                    // $('.jsMultiSelect').attr('multiple','multiple');

                }() : false;
            }
        });
    });
    $('.jsReleaseMultiSelecr').multiselect({
        buttonWidth: '400px',
        maxHeight: 400,
        includeSelectAllOption: true,
        enableFiltering: true,
    })



    $(".jsDeleteRequest").click(function (event) {

        var ids =  $.map($( ".jsRequestsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;});

        var obj = {
            idRequestList :  ids,

        };

        /* $( ".jsEditStudent" ).prop('disabled', true);
         $( ".jsTest" ).prop('disabled', true);
         $( ".jsAssignStudent" ).prop('disabled', true);
 */

        $( ".jsRequestsTable" ).bootstrapTable('remove', {
            field: 'idRequest',
            values: ids
        });

        $.ajax({
            url: 'deleteRequest',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {



            }

        });
    });




























    $(".jsEditRequest").click(function (event) {

            $(".jsCompanyNameEdit").val(""),
            $(".jsStartDateEdit").val(""),
            $(".jsFinishDateEdit").val(""),
            $(".jsSpecialityEditRequest").val("").change(),
            $(".jsRequestQuantityEdit").val(""),
            $(".jsMinAvScoreEdit").val("");

        var ids =  $.map($( ".jsRequestsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;});


        var obj = {
            idRequestList :  ids,

        };




        $.ajax({
            url: 'editRowRequest',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                    $(".jsCompanyNameEdit").val(addedUser.name),
                    $(".jsStartDateEdit").val(addedUser.datestart),
                    $(".jsFinishDateEdit").val(addedUser.datefinish),
                    $(".jsSpecialityEditRequest").val(addedUser.idSpeciality).change();
                    $(".jsRequestQuantityEdit").val(addedUser.quantity),
                    $(".jsMinAvScoreEdit").val(addedUser.minavscore);








            }

        });
    });












    $(".jsAddRequestEdit").click(function (event) {
        event.stopPropagation();
        var ids =  $.map($( ".jsRequestsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;});
        var obj = {
            idRequestList: ids,

            idSpeciality : $(".jsSpecialityEditRequest option:selected").attr("value"),
            minavscore : $(".jsMinAvScoreEdit").val(),
            quantity :$(".jsRequestQuantityEdit").val(),
            datefinish:$(".jsFinishDateEdit").val(),
            datestart:$(".jsStartDateEdit").val(),

            name:$(".jsCompanyNameEdit").val(),

        };





        $.ajax({

            url: 'editRowRequestBase',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                $( ".jsRequestsTable" ).bootstrapTable('updateRow', {
                    index: indexRequest,
                    row: addedUser
                });


            }

        });
    });




    $( ".jsEditRequest" ).click(function (event) {
        $.ajax({
            url: 'dropdownSpeciality',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (users) {
                $( ".jsSpecialityEditRequest" ).text('');
                users ? function () {
                    users.some(function (user) {
                        $( ".jsSpecialityEditRequest" ).append('<option value="'+user.id+'">'+user.name+'</option>')

                    });
                }() : false;
            }

        });
    })



























    $( ".jsAssignRequest" ).click(function() {


        var ids =  $.map($( ".jsRequestsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;});


        var obj = {
            idRequestList: ids,
        };
        $.ajax({
            url: 'multiselestReleaseRequest',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $('.jsMultiSelectReleseRequest').text('');
                students ? function () {
                    students.some(function (student) {


                        $('.jsMultiSelectReleseRequest').append('<option value="'+student.id+'">'+student.surname+'</option>');


                    });
                    $('.jsMultiSelectReleseRequest').multiselect('rebuild');



                    // $('.jsMultiSelect').attr('multiple','multiple');

                }() : false;
            }
        });
    });
    $('.jsMultiSelectReleseRequest').multiselect({
        buttonWidth: '400px',
        maxHeight: 400,
        includeSelectAllOption: true,
        enableFiltering: true,
    })





    $( ".jsReleaseRequest" ).click(function() {


        var ids =  $.map($( ".jsRequestsTable" ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;});


        var obj = {
            requestsId: ids,
            listid:$(".jsMultiSelectReleseRequest").val(),
        };
        $.ajax({
            url: 'releaseStudentFromRequest',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $( ".jsRequestsTable" ).bootstrapTable('updateRow', {
                    index: indexRequest,
                    row: students
                });

            }
        });
    });




});
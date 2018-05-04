$(document).ready(function() {
    $('.jsLoginRegisrt').on("keyup",function () {
        if($ (this).val()!=""&&  $('.jsPasswordRegistr').val()!="" &&  $('.jsPasswordConfirmRegistr').val()!="")
            $( ".jsAddRegistr" ).prop('disabled', false);
        else
            $( ".jsAddRegistr" ).prop('disabled', true);

    })

    $('.jsPasswordRegistr').on("keyup",function () {
        if($ (this).val()!=""&&  $('.jsLoginRegisrt').val()!="" &&  $('.jsPasswordConfirmRegistr').val()!="")
            $( ".jsAddRegistr" ).prop('disabled', false);
        else
            $( ".jsAddRegistr" ).prop('disabled', true);

    })

    $('.jsPasswordConfirmRegistr').on("keyup",function () {
        if($ (this).val()!=""&&  $('.jsLoginRegisrt').val()!="" &&  $('.jsPasswordRegistr').val()!="")
            $( ".jsAddRegistr" ).prop('disabled', false);
        else
            $( ".jsAddRegistr" ).prop('disabled', true);

    })


  $('.jsAddRegistr').click(function () {

      var password  = $(".jsPasswordRegistr").val();
      var passhash = CryptoJS.MD5(password).toString();
      var passwordconfirm  = $(".jsPasswordConfirmRegistr").val();
      if (password==passwordconfirm)
      {

          var obj = {
              password: passhash,
              login: $(".jsLoginRegisrt").val(),
              role : $(".jsRoleRegistration option:selected").attr("value")


          };





          $.ajax({

              url: 'addNewRegistration',
              type: 'POST',
              dataType: 'text',
              contentType: "application/json",
              mimeType: 'application/json',
              data: JSON.stringify(obj),
              success: function (addedUser) {

                  noty({ text: 'Wait for administrator approval'});
                  $("#register").modal('hide');






              }

          });
      }
      else
          alert("Passwords do not match")



  })
});
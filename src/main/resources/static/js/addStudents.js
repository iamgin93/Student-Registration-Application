$('document').ready(function(){
    $('.table #editStudentBtn').on('click',function(event){
        event.preventDefault();

        // Get the json payload and sets the input field values
        var href = $(this).attr('href');
        $.get(href,function(student, status){
            $('#editStudentModal #studentid').val(student.studentId);
            $('#nameEdit').val(student.name);
            $('#courseEdit').val(student.course);
            $('#emailAddressEdit').val(student.emailAddress);
            $('#phoneNumberEdit').val(student.phoneNumber);
        });
        $('#editStudentModal').modal('show');
    });

    //Form validation logic
    (function () {
      'use strict'

      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.querySelectorAll('.requires-validation')

      // Loop over them and prevent submission
      Array.prototype.slice.call(forms)
        .forEach(function (form) {
          form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }

            form.classList.add('was-validated')
          }, false)
        })
    })()

    //Reset form validation
    $('.btn-add').on('click', function(event){
        $('.add-form').removeClass('was-validated');

        $('.add-form input').val("");
    });

});
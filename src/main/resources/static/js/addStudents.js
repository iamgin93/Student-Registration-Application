$('document').ready(function(){
    $('.table #editStudentBtn').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href,function(student, status){
            $('#editStudentModal #studentid').val(student.studentId);
            $('#nameEdit').val(student.name);
            $('#emailAddressEdit').val(student.emailAddress);
            $('#phoneNumberEdit').val(student.phoneNumber);
        });
        $('#editStudentModal').modal('show');
    });
});
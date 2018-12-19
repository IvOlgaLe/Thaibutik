/*function submitter(btn) {
    var param = btn.id;
    var rowId;
    var myForm = document.forms["cartForm"];
    myForm.elements["productId"].value = param;
    
    if (myForm.elements["rowIndex"] != undefined) {
    	myForm.elements["rowIndex"].value = $(btn).closest('tr').index()-1;
    }
    
    myForm.submit();
}

function getRowIndex (td) {
	 var row_index = $(this).parent().index();
	 var col_index = $(this).index();
	 submitter();
}*/

(function() {

    ('#login-form-link').click(function(e) {
        ("#login-form").delay(100).fadeIn(100);
        ("#register-form").fadeOut(100);
        ('#register-form-link').removeClass('active');
        (this).addClass('active');
        e.preventDefault();
    });
    ('#register-form-link').click(function(e) {
        ("#register-form").delay(100).fadeIn(100);
        ("#login-form").fadeOut(100);
        ('#login-form-link').removeClass('active');
        (this).addClass('active');
        e.preventDefault();
    });

});

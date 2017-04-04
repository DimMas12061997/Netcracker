$(function() {
    $("#reg").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            pass: {
                required: true,
                minlength: 6
            },
            pass2: {
                required: true,
                minlength: 6,
                equalTo: "#pass"
            }
        },
        messages: {
            email: {
                required: "Поле E-mail обязательное для заполнения",
                email: "Введите пожалуйста корректный e-mail"
            }
        },
        focusCleanup: true,
        focusInvalid: false,
        invalidHandler: function(event, validator) {
            $(".reg").text("Исправьте пожалуйста все ошибки.");
        },
        onkeyup: function(element) {
            $(".reg").text("");
        },
        errorPlacement: function(error, element) {
            return true;
        },
        errorClass: "form-input_error",
        validClass: "form-input_success"
    });
});

$(function() {
    $("#entrance").validate({

        rules: {
            email: {
                required: true,
                email: true
            },
            pass:{
                required: true,
                minlength: 6
            },
        },
        messages: {
            email: {
                required: "Поле E-mail обязательное для заполнения",
                email: "Введите пожалуйста корректный e-mail"
            },
            pass:{
                required: "Это поле обязательно для заполнения",
                minlength: "Пароль должен быть минимум 6 символа"
            },
        },
        focusCleanup: true,
        focusInvalid: false,
        invalidHandler: function(event, validator) {
            $(".entrance").text("Исправьте пожалуйста все ошибки.");
        },
        onkeyup: function(element) {
            $(".entrance").text("");
        },
        errorPlacement: function(error, element) {
            return true;
        },
        errorClass: "form-input_error",
        validClass: "form-input_success"
    });
});
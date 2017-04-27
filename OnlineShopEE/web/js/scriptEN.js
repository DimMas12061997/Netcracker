$(function () {
    $("#js-register-form").validate({
        rules: {
            name: {
                required: true
            },
            surname: {
                required: true,
            },
            login: {
                required: true,
            },
            password: {
                required: true,
                minlength: 6
            },
            password2: {
                required: true,
                minlength: 6,
                equalTo: "#pass1"
            }
        },
        focusCleanup: true,
        focusInvalid: false,
        invalidHandler: function (event, validator) {
            $(".js-form-message").text("Исправьте пожалуйста все ошибки.");
        },
        onkeyup: function (element) {
            $(".js-form-message").text("");
        },
    });
});

$(function () {
    $("#js-entrance-form").validate({
        rules: {
            login: {
                required: true,
            },
            password: {
                required: true,
                minlength: 6
            }
        },
        focusCleanup: true,
        focusInvalid: false,
        invalidHandler: function (event, validator) {
            $(".js-form-message").text("Исправьте пожалуйста все ошибки.");
        },
        onkeyup: function (element) {
            $(".js-form-message").text("");
        },
    });
});
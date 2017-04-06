$(function () {
    $("#js-register-form").validate({
        rules: {
            form_name: {
                required: true
            },
            form_surname: {
                required: true,
            },
            form_login: {
                required: true,
            },
            form_pswd1: {
                required: true,
                minlength: 6
            },
            form_pswd2: {
                required: true,
                minlength: 6,
                equalTo: "#form_pswd1"
            }
        },
        messages: {
            form_name: {
                required: "Поле Имя обязательное для заполнения."
            },
            form_surname: {
                required: "Поле Фамилия обязательное для заполнения.",
            },
            form_login: {
                required: "Поле Логин обязательное для заполнения."
            },
            form_pswd1: {
                required: "Поле Пароль обязательное для заполнения."
            },
            form_pswd2: {
                required: "Повторите введенный пароль."
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
        form_login: {
            required: true,
        },
        form_pswd1: {
            required: true,
            minlength: 6
        }
    },
    messages: {
        form_login: {
            required: "Поле Логин обязательное для заполнения."
        },
        form_pswd1: {
            required: "Поле Пароль обязательное для заполнения."
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

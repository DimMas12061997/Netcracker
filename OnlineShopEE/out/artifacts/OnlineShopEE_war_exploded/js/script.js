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
        messages: {
            name: {
                required: "Поле Имя обязательное для заполнения."
            },
            surname: {
                required: "Поле Фамилия обязательное для заполнения.",
            },
            login: {
                required: "Поле Логин обязательное для заполнения."
            },
            password: {
                required: "Поле Пароль обязательное для заполнения."
            },
            password2: {
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
        login: {
            required: true,
        },
        password: {
            required: true,
            minlength: 6
        }
    },
    messages: {
        login: {
            required: "Поле Логин обязательное для заполнения."
        },
        password: {
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

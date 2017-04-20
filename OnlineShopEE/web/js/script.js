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
    $(function () {
        $("#edit-form").validate({
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
        $("#profile-form").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
                address: {
                    required: true,
                },
                budget: {
                    required: true,
                    digits: true,
                    number: true
                },
                credit_card: {
                    required: true,
                    digits: true,
                    minlength: 5,
                }
            },
            messages: {
                email: {
                    required: "Поле email обязательное для заполнения.",
                    email: "Введите пожалуйста корректный e-mail"
                },
                address: {
                    required: "Поле address обязательное для заполнения.",
                },
                budget: {
                    required: "Поле budget обязательное для заполнения.",
                    digits: "Поле budget должно содержать только цифры."
                },
                credit_card: {
                    required: "Поле credit_card обязательное для заполнения.",
                    digits: "Поле credit_card должно содержать только цифры."
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
});

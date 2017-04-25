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
                    number: "Поле budget должно содержать только знаки и цифры."
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

    $(function () {
        $("#add_category").validate({
            rules: {
                categoryName: {
                    required: true,
                }
            },
            messages: {
                categoryName: {
                    required: "Поле categoryName обязательное для заполнения."
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
        $("#add_goods").validate({
            rules: {
                goodsName: {
                    required: true
                },
                goodsNumber: {
                    required: true,
                    digits: true
                },
                goodsPrice: {
                    required: true,
                    number: true
                },
                goodsProducer: {
                    required: true
                },
                goodsDescription: {
                    required: true
                },
                categoryName: {
                    required: true
                }
            },
            messages: {
                goodsName: {
                    required: "Поле goodsName обязательное для заполнения."
                },
                goodsNumber: {
                    required: "Поле goodsNumber обязательное для заполнения.",
                    digits: "Поле goodsNumber должно содержать только цифры."
                },
                goodsPrice: {
                    required: "Поле goodsPrice обязательное для заполнения.",
                    number: "Поле goodsPrice должно содержать только знаки и цифры."
                },
                goodsProducer: {
                    required: "Поле goodsProducer обязательное для заполнения."
                },
                goodsDescription: {
                    required: "Поле goodsDescription обязательное для заполнения."
                },
                categoryName: {
                    required: "Поле categoryName обязательное для заполнения."
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
                    $("#update_goods").validate({
                        rules: {
                            goodsName: {
                                required: true
                            },
                            goodsNumber: {
                                required: true,
                                digits: true
                            },
                            goodsPrice: {
                                required: true,
                                number: true
                            },
                            goodsProducer: {
                                required: true
                            },
                            goodsDescription: {
                                required: true
                            },
                            categoryName: {
                                required: true
                            }
                        },
                        messages: {
                            goodsName: {
                                required: "Поле goodsName обязательное для заполнения."
                            },
                            goodsNumber: {
                                required: "Поле goodsNumber обязательное для заполнения.",
                                digits: "Поле goodsNumber должно содержать только цифры."
                            },
                            goodsPrice: {
                                required: "Поле goodsPrice обязательное для заполнения.",
                                number: "Поле goodsPrice должно содержать только знаки и цифры."
                            },
                            goodsProducer: {
                                required: "Поле goodsProducer обязательное для заполнения."
                            },
                            goodsDescription: {
                                required: "Поле goodsDescription обязательное для заполнения."
                            },
                            categoryName: {
                    required: "Поле categoryName обязательное для заполнения."
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
        $("#update_category").validate({
            rules: {
                categoryName: {
                    required: true,
                }
            },
            messages: {
                categoryName: {
                    required: "Поле categoryName обязательное для заполнения."
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
// $('#myModalUpdate').on('show.bs.modal', function (event) {
//     var button = $(event.relatedTarget) // Кнопка, что спровоцировало модальное окно
//
//     var recipient = button.data('whatever') // Извлечение информации из данных-* атрибутов
//     console.log(recipient);
//
//     // Если необходимо, вы могли бы начать здесь AJAX-запрос (и выполните обновление в обратного вызова).
//
//     // Обновление модальное окно Контента. Мы будем использовать jQuery здесь, но вместо него можно использовать привязки данных библиотеки или других методов.
//
//     var modal = $(this)
//     modal.find('.modal-body input').val(recipient)
// })

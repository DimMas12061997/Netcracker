<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет магазин</title>
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/jquery-validation/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="css/product_content.css"/>
    <script>
        $('#myModalUpdate').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Кнопка, что спровоцировало модальное окно

            var recipient = button.data('whatever') // Извлечение информации из данных-* атрибутов

            // Если необходимо, вы могли бы начать здесь AJAX-запрос (и выполните обновление в обратного вызова).

            // Обновление модальное окно Контента. Мы будем использовать jQuery здесь, но вместо него можно использовать привязки данных библиотеки или других методов.

            var modal = $(this)
            modal.find('.modal-body input').val(recipient)
        })
    </script>
</head>
<body>
<nav class="navbar navbar-my" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="/image/logo2.png" width="150" height="30" alt=""></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="controller?command=catalog">Каталог</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search" action="controller" method="POST" id="find-form">
                <input type="hidden" name="command" value="find_goods"/>
                <div class="form-group">
                    <input type="text" class="form-control" name="find" placeholder="Искать товар">
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>
                    Искать
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="controller?command=show_order">
                    <span class="glyphicon glyphicon-shopping-cart"></span> Корзина <span
                        class="badge"> ${goodsOrder}</span></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="glyphicon glyphicon-user"></span> ${user}<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="controller?command=adminprofilepage">Мой профиль</a></li>
                        <li><a href="controller?command=editpage">Редактировать</a></li>
                        <c:if test="${userType == 'ADMINISTRATOR'}">
                            <li><a href="controller?command=show_customers">Пользователи</a></li>
                            <li><a href="controller?command=black_list">Управление черным списком</a></li>
                            <li><a href="controller?command=show_purchase_history">История покупок</a></li>
                            <li><a href="controller?command=shop_management">Управление магазином</a></li>
                        </c:if>
                        <li class="divider"></li>
                        <li><a href="controller?command=logout">Выйти</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Добавление категории</h4>
            </div>
            <div class="modal-body">

                <form action="controller" method="POST" id="add_category">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="add_category"/>
                    <input type="text" placeholder="Наименование категории" name="categoryName" class="form-input">
                    <p>
                        <input type="submit" value="Добавить" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModalUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalUpdateLabel">Изменение категории</h4>
            </div>
            <div class="modal-body">

                <form action="controller" method="POST" id="update_category">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="update_category"/>
                    Наименование категории: <input type="text" name="categoryName" class="form-input">
                    <p>
                        <input type="submit" value="Изменить" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModalGoods" tabindex="-1" role="dialog" aria-labelledby="myModalGoodsLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalGoodsLabel">Добавление товара</h4>
            </div>
            <div class="modal-body">

                <form action="controller" method="POST" id="add_goods">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="add_goods"/>
                    <input type="text" placeholder="Наименование товара" name="goodsName" class="form-input">
                    <input type="number" placeholder="Количество товара" name="goodsNumber" class="form-input">
                    <input type="text" placeholder="Цена единицы товара" name="goodsPrice" class="form-input">
                    <input type="text" placeholder="Производитель" name="goodsProducer" class="form-input">
                    <input type="text" placeholder="Описание" name="goodsDescription" class="form-input">
                    <select id="categoryName" name="categoryName">
                        <option value="">Выберите категорию: </option>
                        <c:forEach var="category" items="${categoryList}">
                            <option><c:out value="${category.categoryName}"/></option>
                        </c:forEach>
                    </select>
                    <p>
                        <input type="submit" value="Добавить" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr class="warning">
            <th align="center">№</th>
            <th align="center">Наименование товара</th>
            <th align="center">Количество</th>
            <th align="center">Цена</th>
            <th align="center">Производитель</th>
            <th align="center">Описание</th>
            <th align="center">Категория</th>
            <th align="center">Удалить товар</th>
            <th align="center">Изменить товар</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="goods" items="${goodsList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${goods.name}"/></td>
                <td><c:out value="${goods.number}"/></td>
                <td><c:out value="${goods.unitPrice}"/></td>
                <td><c:out value="${goods.producer}"/></td>
                <td><c:out value="${goods.description}"/></td>
                <td><c:out value="${goods.createdDate}"/></td>
                <td>
                    <a href="controller?command=remove_goods&idGoods=${goods.idGoods}"
                       class="glyphicon glyphicon-trash"></a>
                </td>
                <td>
                    <a href="controller?command=update_goods&idGoods=${goods.idGoods}"
                       class="glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalGoods">
            Добавить товар
        </button>
    </p>
    <p>
    <table class="table table-bordered">
        <thead>
        <tr class="warning">
            <th align="center">№</th>
            <th align="center">Наименование категории</th>
            <th align="center">Изменить</th>
            <th align="center">Удалить</th>
            <th align="center">Выбрать</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categoryList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${category.categoryName}"/></td>
                <td>
                    <a href="#myModalUpdate" role="button" data-toggle="modal" data-whatever="${category.categoryName}"
                       class="glyphicon glyphicon-pencil"></a>
                        <%--<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalUpdate" data-whatever="123">--%>
                        <%--Изменить категорию--%>
                        <%--</button>--%>
                </td>
                <td>
                    <a href="controller?command=remove_category&categoryId=${category.idCategory}"
                       class="glyphicon glyphicon-trash"></a>
                </td>
                <td>
                    <a href="controller?command=shop_management&categoryId=${category.idCategory}"
                       class="glyphicon glyphicon-ok"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="controller?command=shop_management"
       class="glyphicon glyphicon-ok">Выбрать все товары</a>
    </p>
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
        Добавить категорию
    </button>

</div>
</body>
</html>

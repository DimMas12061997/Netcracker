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
                <li class="active"><a href="#">О магазине</a></li>
                <li><a href="controller?command=catalog">Каталог</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search" action="controller" method="POST" id="find-form">
                <input type="hidden" name="command" value="find_goods" />
                <div class="form-group">
                    <input type="text" class="form-control" name = "find" placeholder="Искать товар">
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${user}<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="controller?command=adminprofilepage">Мой профиль</a></li>
                        <li><a href="controller?command=editpage">Редактировать</a></li>
                        <c:if test="${userType == 'ADMINISTRATOR'}">
                            <li><a href="controller?command=show_customers">Пользователи</a></li>
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
</div>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr class="warning" align="center">
            <th>№</th>
            <th>Наименование товара</th>
            <th>Количество</th>
            <th>Цена</th>
            <th>Производитель</th>
            <th>Описание</th>
            <th>Удалить товар</th>
            <th>Изменить товар</th>
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
                <td>
                    <a href="controller?command=remove_order&idOrder=${order.idGoods}"
                       class="glyphicon glyphicon-trash"></a>
                </td>
                <td>
                    <a href="controller?command=remove_order&idOrder=${order.idGoods}"
                       class="glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
        </c:forEach>
        <tr class="warning" align="center">
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><c:out value="    К оплате: "/></td>
            <td><c:out value="${orderCost}"/></td>
            <td></td>
        </tr>
        </tbody>
    </table>
    <c:if test="${orderCost > 0}">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="buy_order"/>
            <input type="hidden" name="orderCost" value="${orderCost}"/>
            <input type="submit" value="Купить" style="margin-left:50%;"  class="btn btn-success btn btn-primary btn-lg"/>
                <%--<button style="margin-left:50%;" type="button" class="btn btn-success btn btn-primary btn-lg">Купить</button>--%>
                ${errorPayment}
        </form>
    </c:if>
</div>
</body>
</html>

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
                <%--<li class="active"><a href="#">О магазине</a></li>--%>
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
</div>
<div class="container">
    <div class="i-right-title-text">Неплательщики</div>
    <table class="table table-bordered">
        <thead>
        <tr align="center" class="warning">
            <th>№</th>
            <th>Логин</th>
            <th>Стоимость предварительного заказа</th>
            <th>Добавить в ЧС</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${order.createdDate}"/></td>
                <td><c:out value="${order.orderCost}"/></td>
                <td>
                    <a href="controller?command=add_black_list&userLogin=${order.createdDate}"
                       class="glyphicon glyphicon-ok"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="i-right-title-text">Черный список</div>
    <table class="table table-bordered">
        <thead>
        <tr align="center" class="warning">
            <th>№</th>
            <th>Логин</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Удалить из чс</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="blackList" items="${blackList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${blackList.login}"/></td>
                <td><c:out value="${blackList.lastName}"/></td>
                <td><c:out value="${blackList.firstName}"/></td>
                <td>
                    <a href="controller?command=remove_from_blacklist&userId=${blackList.userId}"
                       class="glyphicon glyphicon-trash"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


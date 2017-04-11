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
            <a class="navbar-brand" href="#">SPORTIX</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Пункт 1</a></li>
                <li><a href="#">Пункт 2</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Выпадающий пункт <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Подпункт</a></li>
                        <li><a href="#">Еще подпункт</a></li>
                        <li><a href="#">Еще что-то</a></li>
                        <li class="divider"></li>
                        <li><a href="#">И еще</a></li>
                    </ul>
                </li>
                <li><a href="#">Пункт 4</a></li>
                <li><a href="#">Пункт 5</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Искать">
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Искать
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" class="glyphicon glyphicon-user" data-toggle="dropdown"> ${user}<span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="controller?command=adminprofilepage">Мой профиль</a></li>
                        <li><a href="controller?command=editpage">Редактировать</a></li>
                        <c:if test="${userType == 'ADMINISTRATOR'}">
                            <li><a href="controller?command=show_customers">Пользователи</a></li>
                        </c:if>
                        <li class="divider"></li>
                        <li><a href="controller?command=logout">Выйти</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Логин</th>
        <th>Роль</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var = "user" items="${userList}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td><c:out value="${ user.lastName }" /></td>
            <td><c:out value="${ user.firstName }" /></td>
            <td><c:out value="${ user.login }" /></td>
            <%--<td><c:out value="${ user.roleId }" /></td>--%>
            <c:if test="${user.roleId == '1'}">
                <td>Администратор</td>
            </c:if>
            <c:if test="${user.roleId == '2'}">
                <td>Покупатель</td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<html>--%>
<%--<head><title>Index</title></head>--%>
<%--<body>--%>
<%--<jsp:forward page="/jsp/login.jsp"/>--%>
<%--</body></html>--%>
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
                <button type="submit" class="btn btn-default"><span class = "glyphicon glyphicon-search"></span> Искать</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="controller?command=loginpage">Вход</a></li>
                <li><a href="controller?command=registrationpage">Регистрация</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
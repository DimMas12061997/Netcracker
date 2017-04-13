<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет магазин</title>
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/jquery-validation/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="css/prosport.css"/>
    <link href="css/style.css" rel="stylesheet">

</head>
<div>
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
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Искать">
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>
                        Искать
                    </button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="controller?command=loginpage">Вход</a></li>
                    <li><a href="controller?command=registrationpage">Регистрация</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="i-main c">
    <div class="left-menu">
        <div class="left-menu-title">
            <div class="left-menu-title-text"> <span class="glyphicon glyphicon-list"></span>  МЕНЮ</div>
        </div>
        <div class="left-menu-block">
            <ul>
                <c:forEach var = "catalog" items="${categoryList}">
                <li> <a href="controller?command=show_goods&id=${catalog.idCategory}">
                <c:out value="${ catalog.categoryName }"/>
                </a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="right right404 right-catalog">
        <div class="i-right-title">
            <div class="i-right-title-label i-right-title-label-10"></div>
            <div class="i-right-title-text">Каталог</div>
        </div>
        <div class="r-cat">
            <c:forEach var = "goods" items="${goodsList}">
                <div class="r-cat-box  shk-item">
                    <form  method="post">
                        <fieldset>
                            <div class="r-cat-acii">
                            </div>
                            <a href="controller?command=show_good&id=${goods.idGoods}" class="r-cat-img">
                                <img class="shk-image" src="assets/images/gejnery-belkovo-uglevodnye-smesi/dymatize-super-mass-gainer-chocolate-6-lbs.jpg" alt=${goods.name} title=${goods.name}>
                            </a>
                            <div class="r-cat-other">
                                <div class="r-cat-other-title">
                                    <div><a href="controller?command=show_good&id=${goods.idGoods}" style="color:#efc400;" >${goods.name}</a></div>
                                    <p></p>
                                </div>
                                <div class="r-cat-other-price">
                                    <div>
                                        <span class="r-cat-other-price-true shk-price">${goods.unitPrice}</span>
                                    </div>
                                    <button type="submit"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 30px; color: #252a2f;"></span></button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </c:forEach>
        </div>
        <%--<div class="pagination pagination-centered" style="margin-left:200px;">--%>
            <%--<li class="disabled"><span><<</span></li>--%>
            <%--<li class="active"><span>1</span></li>--%>
            <%--<li><a href="#">2</a></li>--%>
            <%--<li><a href="#">3</a></li>--%>
            <%--<li><a href="#">4</a></li>--%>
            <%--<li><a href="#">5</a></li>--%>
            <%--<li><a href="#">>></a></li>--%>
        <%--</div>--%>
    </div>
</div>
</body>
</html>

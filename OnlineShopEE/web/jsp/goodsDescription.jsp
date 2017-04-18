<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет магазин</title>
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
    <%--<script src="js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>--%>
    <script src="js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/jquery-validation/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="css/product_content.css"/>
    <link href="css/style.css" rel="stylesheet">
    <%--<script type="text/javascript">--%>
    <%--$("document").ready(function(){--%>
    <%--$('#modal').modal();--%>
    <%--});--%>
    <%--</script>--%>
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
                    <c:choose>
                        <c:when test="${userType == 'GUEST'}">
                            <li><a href="controller?command=loginpage">Вход</a></li>
                            <li><a href="controller?command=registrationpage">Регистрация</a></li>
                        </c:when>
                        <c:otherwise>
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
                                    </c:if>
                                    <li class="divider"></li>
                                    <li><a href="controller?command=logout">Выйти</a></li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="i-main c">
    <div class="left-menu">
        <div class="left-menu-title">
            <div class="left-menu-title-text"><span class="glyphicon glyphicon-list"></span> МЕНЮ</div>
        </div>
        <div class="left-menu-block">
            <ul>
                <c:forEach var="catalog" items="${categoryList}">
                    <li><a href="controller?command=show_goods&id=${catalog.idCategory}">
                        <c:out value="${ catalog.categoryName }"/>
                    </a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="right right404 right-catalog">
        <div class="i-right-title">
            <div class="i-right-title-label i-right-title-label-10"></div>
            <div class="i-right-title-text">Каталог - <c:out value="${categoryName}"/></div>
        </div>
        <c:set var="goods" value="${goodsDescription}"/>
        <div class="product content">
            <div class="shs-tocart shk-item">
                <div class="product-img-wrp">
                    <div class="product-img">
                        <div class="product-acii">
                            <div class="prod_new1">NEW</div>
                        </div>
                        <a href="assets/images/energetiki/no-xplode_30serv_blueraz.jpg" class="fancybox"><img
                                class="shk-image" alt=" <c:out value="${ goods.name }"/>"
                                src="assets/images/energetiki/no-xplode_30serv_blueraz.jpg"></a>
                    </div>
                </div>
                <div class="product-other">
                    <div class="product-title"><c:out value="${goods.name }"/></div>
                    <div style="margin-top: 20px;">
                        <form action="controller" method="POST">
                            <c:choose>
                            <c:when test="${userType == 'GUEST'}">
                            <div class="r-cat-other-price">
                                <div class="r-cat-other-price-cell-wrp">
                                    <div class="r-cat-other-price-cell">
                                    <span class="r-cat-other-price-true shk-price"> Цена: <c:out
                                            value="${ goods.unitPrice }"/></span>
                                    </div>
                                </div>
                            </div>
                            </c:when>
                            <c:otherwise>
                            <input type="hidden" name="command" value="make_order"/>
                            <input type="hidden" name="idGoods" value="${goods.idGoods}"/>
                            <input type="hidden" name="name" value="${goods.name}"/>
                            <input type="hidden" name="unitPrice" value="${goods.unitPrice}"/>
                            <div class="col-10" style="width:60px;"><input
                                    style="margin-left:10px; color:#efc400; background-color: #4f4f4f"
                                    class="form-control" name="number" type="number" value="0" min="1"
                                    max="${goods.number}"
                                    id="example-number-input">
                            </div>
                            <p>
                            <div class="r-cat-other-price">
                                <div class="r-cat-other-price-cell-wrp">
                                    <div class="r-cat-other-price-cell">
                                    <span class="r-cat-other-price-true shk-price" id="stuff_2618_price"> Цена: <c:out
                                            value="${ goods.unitPrice }"/></span>
                                    </div>
                                </div>
                            </div>
                            <input type="submit" value="Добавить в корзину"
                                   style="background-color: #4f4f4f; color:#efc400; font-size: 20px; text-align: center;">
                            </input>
                            </p>
                            </c:otherwise>
                            </c:choose>
                    </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="product-text content">
            <div class="product-text-title">ПРОИЗВОДИТЕЛЬ:</div>
            <p><c:out value="${ goods.producer }"/></p>
            <div class="product-text-title">ОПИСАНИЕ:</div>
            <p><c:out value="${ goods.description }"/></p>
        </div>
    </div>
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

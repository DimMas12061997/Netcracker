<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/jquery-validation/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="css/product_content.css"/>
    <link href="css/style.css" rel="stylesheet">

</head>
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
                    <li><a href="controller?command=catalog">${catalog}</a></li>
                </ul>
                <form class="navbar-form navbar-left" role="search" action="controller" method="POST" id="find-form">
                    <input type="hidden" name="command" value="find_goods"/>
                    <div class="form-group">
                        <input type="text" class="form-control" name="find" placeholder="${searchGood}">
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>
                        ${search}
                    </button>
                </form>
                <ul class="nav navbar-nav">
                    <li><a href="controller?command=select_language&language=EN&page=path.page.showOrder"><span class="bfh-languages" data-language="en_US" data-flags="true"></span>EN</a></li>
                    <li><a href="controller?command=select_language&language=RU&page=path.page.showOrder"><span class="bfh-languages" data-language="ru_RU" data-flags="true"></span>RU</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${userType == 'GUEST'}">
                            <li><a href="controller?command=loginpage">${entrance}</a></li>
                            <li><a href="controller?command=registrationpage">${registration}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="controller?command=show_order">
                                <span class="glyphicon glyphicon-shopping-cart"></span>  ${basket} <span
                                    class="badge"> ${goodsOrder}</span></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                                        class="glyphicon glyphicon-user"></span> ${user}<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="controller?command=adminprofilepage">${myProfile}</a></li>
                                    <li><a href="controller?command=editpage">${edit}</a></li>
                                    <c:if test="${userType == 'ADMINISTRATOR'}">
                                        <li><a href="controller?command=show_customers">${users}</a></li>
                                        <li><a href="controller?command=black_list"> ${managingBlackList}</a></li>
                                        <li><a href="controller?command=show_purchase_history">${purchaseHistory} </a></li>
                                        <li><a href="controller?command=shop_management">${shopManagement} </a></li>
                                    </c:if>
                                    <li class="divider"></li>
                                    <li><a href="controller?command=logout">${logout}</a></li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
<div class="container">
    ${userBlackList}
    <table class="table table-bordered">
        <thead>
        <tr class="warning" align="center">
            <th>№</th>
            <th>${nameLabel}</th>
            <th>${priceLabel}</th>
            <th>${numberLabel}</th>
            <th>${sumLabel}</th>
            <th>${removeLabel}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${order.name}"/></td>
                <td><c:out value="${order.unitPrice}"/></td>
                <form action="controller" method="POST">
                    <input type="hidden" name="command" value="update_order"/>
                    <input type="hidden" name="idOrder" value="${order.idGoods}"/>
                    <input type="hidden" name="unitPrice" value="${order.unitPrice}"/>
                    <input type="hidden" name="numberGoods" value="${order.shopId}"/>
                    <td>
                        <input type="submit" value="${update}"
                              style="background-color: #4f4f4f; width:30%; float: left; color:#efc400; font-size: 12px; text-align: center;"/>
                        <input
                                style="width:40%; color:#efc400; background-color: #4f4f4f"
                                class="form-control" name="number" type="number" value="${order.shopId}" min="0"
                                max="${order.number+order.shopId}"
                                id="example-number-input"></td>

                </form>
                <td><c:out value="${order.shopId*order.unitPrice}"/></td>
                <td>
                    <a href="controller?command=remove_order&idOrder=${order.idGoods}&cost=${order.shopId*order.unitPrice}&number=${order.shopId}"
                       class="glyphicon glyphicon-trash"></a></td>
            </tr>
        </c:forEach>
        <tr class="warning" align="center">
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><c:out value="   ${payLabel}: "/></td>
            <td><c:out value="${orderCost}"/></td>
            <td></td>
        </tr>
        </tbody>
    </table>
    <c:if test="${orderCost > 0}">
    <form action="controller" method="POST">
        <input type="hidden" name="command" value="buy_order"/>
        <input type="hidden" name="orderCost" value="${orderCost}"/>
        <input type="submit" value="${buy}" style="margin-left:50%;"  class="btn btn-success btn btn-primary btn-lg"/>
          ${errorPayment}
    </form>
    </c:if>
</div>
</body>
</html>

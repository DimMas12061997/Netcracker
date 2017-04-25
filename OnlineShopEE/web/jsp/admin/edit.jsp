<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
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
                <li><a href="controller?command=select_language&language=EN&page=path.page.adminEditPage"><span class="bfh-languages" data-language="en_US" data-flags="true"></span>EN</a></li>
                <li><a href="controller?command=select_language&language=RU&page=path.page.adminEditPage"><span class="bfh-languages" data-language="ru_RU" data-flags="true"></span>RU</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="controller?command=show_order">
                    <span class="glyphicon glyphicon-shopping-cart"></span>  ${basket} <span
                        class="badge"> ${goodsOrder}</span></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${user}<span class="caret"></span></a>
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
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <form action="controller" method="POST" class="form" id="edit-form">
        <h3 class="form-title">${editData}:</h3>
        <div class="message js-form-message"></div>
        <input type="hidden" name="command" value="edit_main_data" />
        <div class="form-group">
            ${placeholderName}: <input type="text" name="name" class="form-input" value = ${first_name}>
        </div>
        <div class="form-group">
            ${placeholderSurname}: <input type="text" name="surname" class="form-input" value = ${last_name}>
        </div>
        <div class="form-group">
            ${placeholderLogin}: <input type="text" name="login" class="form-input" value = ${login}>
        </div>
        <div class="form-group">
            ${placeholderPassword}: <input type="text" name="password" value = ${password} class="form-input">
        </div>
        ${dateLabel}: ${date}
        ${errorLoginPassMessage}
        <br/>
        ${wrongAction}
        <br/>
        ${nullPage}
        <div class="form-group">
            <button type="submit" class="form-btn">${save}</button>
        </div>
    </form>
</div>
</body>
</html>
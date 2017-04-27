<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <c:choose>
    <c:when test="${localeLang == 'ru'}">
        <script src="js/script.js"></script>
    </c:when>
    <c:otherwise>
        <script src="js/scriptEN.js"></script>
   </c:otherwise>
    </c:choose>
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
                <li><a href="controller?command=select_language&language=EN&page=path.page.login"><span class="bfh-languages" data-language="en_US" data-flags="true"></span>EN</a></li>
                <li><a href="controller?command=select_language&language=RU&page=path.page.login"><span class="bfh-languages" data-language="ru_RU" data-flags="true"></span>RU</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="controller?command=loginpage">${entrance}</a></li>
                <li><a href="controller?command=registrationpage">${registration}</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <form action="controller" method="POST" class="form" id="js-entrance-form">
        <input type="hidden" name="command" value="login"/>
        <h3 class="form-title">${entrance}</h3>
        <div class="message js-form-message"></div>
        <div class="form-group">
            <input type="text" placeholder="${placeholderLogin}" name="login" class="form-input">
        </div>
        <div class="form-group">
            <input type="password" placeholder="${placeholderPassword}" name="password" id="form-pswd1"
                   class="form-input">
        </div>
        ${errorLoginPassMessage}
        <br/>
        ${wrongAction}
        <br/>
        ${nullPage}
        <div class="form-group">
            <button type="submit" class="form-btn">${submit}</button>
        </div>
    </form>
</div>
</body>
</html>
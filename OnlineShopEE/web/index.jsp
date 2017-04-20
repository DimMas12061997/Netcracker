<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                    <li><a href="controller?command=loginpage">Вход</a></li>
                    <li><a href="controller?command=registrationpage">Регистрация</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<h1 style="color: #ffe80d; margin-left: 4%;">ДОБРО ПОЖАЛОВАТЬ НА САЙТ POWERSPORTS</h1>
<p style="margin-left: 1%;">Магазин спортивного питания "ПроСпорт" предлагает широкий ассортимент спортивного питания: протеины, гейнеры, креатин,
аминокислоты, витамины, глютамин, жиросжигатели, BCAA и другое. У нас продаются товары только известных западных фирм –
продукты высочайшего качества и эффективности. Очень широко представлено спортивное питание для набора массы, спортивное
питание для бодибилдинга. При нашем ассортименте вы без труда сможете определить свой набор спортивного питания.
Посетите наш магазин и вы больше никогда не будете задаваться вопросом, где спортивное питание купить! Наличие товаров и
цены в магазине и на сайте полностью совпадают.</p>
<p style="margin-left: 1%;">В нашем магазине спортивного питания вы можете получить подробные бесплатные консультации и помощь в составлении программы питания: подбор добавок, дозировок, рекомендации по применению.</p>
</body>
</html>
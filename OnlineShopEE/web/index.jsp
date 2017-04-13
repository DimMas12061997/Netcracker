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
    <%--<link rel="stylesheet" href="css/prosport.css"/>--%>

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
<h1 style="color: #ffe80d; margin-left: 4%;">ДОБРО ПОЖАЛОВАТЬ НА САЙТ POWERSPORTS</h1>
<p style="margin-left: 1%;">Магазин спортивного питания "ПроСпорт" предлагает широкий ассортимент спортивного питания: протеины, гейнеры, креатин,
аминокислоты, витамины, глютамин, жиросжигатели, BCAA и другое. У нас продаются товары только известных западных фирм –
продукты высочайшего качества и эффективности. Очень широко представлено спортивное питание для набора массы, спортивное
питание для бодибилдинга. При нашем ассортименте вы без труда сможете определить свой набор спортивного питания.
Посетите наш магазин и вы больше никогда не будете задаваться вопросом, где спортивное питание купить! Наличие товаров и
цены в магазине и на сайте полностью совпадают.</p>
<p style="margin-left: 1%;">В нашем магазине спортивного питания вы можете получить подробные бесплатные консультации и помощь в составлении программы питания: подбор добавок, дозировок, рекомендации по применению.</p>

<%--<div class="i-main c">--%>
<%--<div class="left-menu">--%>
<%--<div class="left-menu-title">--%>
<%--<div class="left-menu-title-text"> <span class="glyphicon glyphicon-list"></span>  МЕНЮ</div>--%>
<%--</div>--%>
<%--<div class="left-menu-block">--%>
<%--<ul>--%>
<%--<li><a href="/proteini" title="Протеины" >Протеины</a></li>--%>
<%--<li class="active"><a href="/geyneri" title="Гейнеры" >Гейнеры</a></li>--%>
<%--&lt;%&ndash;<li><a href="/batonchiki" title="Батончики" >Батончики</a></li>&ndash;%&gt;--%>
<%--<li><a href="/aminokisloti" title="Аминокислоты" >Аминокислоты</a></li>--%>
<%--<li><a href="/bcaa" title="ВСАА" >ВСАА</a></li>--%>
<%--&lt;%&ndash;<li><a href="/vitaminy-i-mineraly" title="Витамины и минералы" >Витамины и минералы</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li><a href="/energetiki" title="Энергетики" >Энергетики</a></li>&ndash;%&gt;--%>
<%--<li><a href="/kreatin" title="Креатин" >Креатин</a></li>--%>
<%--&lt;%&ndash;<c:forEach var = "catalog" items="${categoryList}">&ndash;%&gt;--%>
<%--&lt;%&ndash;<li> <a href="controller?command=${ catalog.categoryName}"">&ndash;%&gt;--%>
<%--&lt;%&ndash;<c:out value="${ catalog.categoryName }"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="right right404 right-catalog">--%>
<%--<div class="i-right-title">--%>
<%--<div class="i-right-title-label i-right-title-label-10"></div>--%>
<%--<div class="i-right-title-text">Гейнеры ( Белково-углеводные смеси)</div>--%>
<%--</div>--%>
<%--<div class="r-cat">--%>
<%--<div class="r-cat-box  shk-item">--%>
<%--<form  method="post">--%>
<%--<fieldset>--%>
<%--<input type="hidden" name="shk-id" value="2684" >--%>
<%--<input type="hidden" name="shk-name" value="Dym. Super Mass Gainer 6 lb" >--%>
<%--<input type="hidden" name="shk-count" value="1"  >--%>
<%--<div class="r-cat-acii">--%>
<%--</div>--%>
<%--<a href="geynery-belkovo-uglevodnye-smesi/dym-super-mass-gainer-6-lb" class="r-cat-img">--%>
<%--<img class="shk-image" src="assets/images/gejnery-belkovo-uglevodnye-smesi/dymatize-super-mass-gainer-chocolate-6-lbs.jpg" alt="Dym. Super Mass Gainer 6 lb" title="Dym. Super Mass Gainer 6 lb">--%>
<%--</a>--%>
<%--<div class="r-cat-other">--%>
<%--<div class="r-cat-other-title">--%>
<%--<div><a href="geynery-belkovo-uglevodnye-smesi/dym-super-mass-gainer-6-lb" >Dym. Super Mass Gainer 6 lb</a></div>--%>
<%--<p></p>--%>
<%--</div>--%>
<%--<div class="r-cat-other-price">--%>
<%--<div>--%>
<%--<span class="r-cat-other-price-true shk-price">59,00</span>--%>
<%--<span style="display:none">29,30</span>--%>
<%--</div>--%>
<%--<button type="submit" style="margin-left: 1%; margin-bottom: 1%;"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 30px; color: #252a2f;"></span></button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</fieldset>--%>
<%--</form>--%>
<%--</div>--%>
<%--<div class="r-cat-box  shk-item">--%>
<%--<form  method="post">--%>
<%--<fieldset>--%>
<%--<input type="hidden" name="shk-id" value="2821" >--%>
<%--<input type="hidden" name="shk-name" value="MXL. Special Mass Gainer 6 lb" >--%>
<%--<input type="hidden" name="shk-count" value="1"  >--%>
<%--<div class="r-cat-acii">--%>
<%--<div class="prod_hit1">ХИТ!</div>--%>
<%--</div>--%>
<%--<a href="geynery-belkovo-uglevodnye-smesi/mxl-special-mass-gainer-6-lb" class="r-cat-img">--%>
<%--<img class="shk-image" src="assets/images/gejnery-belkovo-uglevodnye-smesi/special_mass6lbs_cookiesandcream.png" alt="MXL. Special Mass Gainer 6 lb" title="MXL. Special Mass Gainer 6 lb">--%>
<%--</a>--%>
<%--<div class="r-cat-other">--%>
<%--<div class="r-cat-other-title">--%>
<%--<div><a href="geynery-belkovo-uglevodnye-smesi/mxl-special-mass-gainer-6-lb" >MXL. Special Mass Gainer 6 lb</a></div>--%>
<%--<p></p>--%>
<%--</div>--%>
<%--<div class="r-cat-other-price">--%>
<%--<div>--%>
<%--<span class="r-cat-other-price-true shk-price">47,00</span>--%>
<%--<span style="display:none">23,30</span>--%>
<%--</div>--%>
<%--<button type="submit" style="margin-left: 1%; margin-bottom: 1%;"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 30px; color: #252a2f;"></span></button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</fieldset>--%>
<%--</form>--%>
<%--</div>--%>
<%--<div class="r-cat-box  shk-item">--%>
<%--<form  method="post">--%>
<%--<fieldset>--%>
<%--<input type="hidden" name="shk-id" value="3047" >--%>
<%--<input type="hidden" name="shk-name" value="Uni. Real Gains 3,8 lb." >--%>
<%--<input type="hidden" name="shk-count" value="1"  >--%>
<%--<div class="r-cat-acii">--%>
<%--</div>--%>
<%--<a href="geynery-belkovo-uglevodnye-smesi/uni-real-gains-38-lb" class="r-cat-img">--%>
<%--<img class="shk-image" src="assets/images/gejnery-belkovo-uglevodnye-smesi/uni.-real-gains-3-8-lb..gif" alt="Uni. Real Gains 3,8 lb." title="Uni. Real Gains 3,8 lb.">--%>
<%--</a>--%>
<%--<div class="r-cat-other">--%>
<%--<div class="r-cat-other-title">--%>
<%--<div><a href="geynery-belkovo-uglevodnye-smesi/uni-real-gains-38-lb" >Uni. Real Gains 3,8 lb.</a></div>--%>
<%--<p></p>--%>
<%--</div>--%>
<%--<div class="r-cat-other-price">--%>
<%--<div>--%>
<%--<span class="r-cat-other-price-true shk-price">47,00</span>--%>
<%--<span style="display:none">23,30</span>--%>
<%--</div>--%>
<%--<button type="submit" style="margin-left: 1%; margin-bottom: 1%;"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 30px; color: #252a2f;"></span></button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</fieldset>--%>
<%--</form>--%>
<%--</div>--%>
<%--<div class="r-cat-box  shk-item">--%>
<%--<form  method="post">--%>
<%--<fieldset>--%>
<%--<input type="hidden" name="shk-id" value="2727" >--%>
<%--<input type="hidden" name="shk-name" value="MHP. Up Your Mass 10 lbs" >--%>
<%--<input type="hidden" name="shk-count" value="1"  >--%>
<%--<div class="r-cat-acii">--%>
<%--</div>--%>
<%--<a href="geynery-belkovo-uglevodnye-smesi/mhp-up-your-mass-10-lbs" class="r-cat-img">--%>
<%--<img class="shk-image" src="assets/images/proteiny-vysokobelkovye-smesi/883-4530.jpg" alt="MHP. Up Your Mass 10 lbs" title="MHP. Up Your Mass 10 lbs">--%>
<%--</a>--%>
<%--<div class="r-cat-other">--%>
<%--<div class="r-cat-other-title">--%>
<%--<div><a href="geynery-belkovo-uglevodnye-smesi/mhp-up-your-mass-10-lbs" >MHP. Up Your Mass 10 lbs</a></div>--%>
<%--<p></p>--%>
<%--</div>--%>
<%--<div class="r-cat-other-price">--%>
<%--<div>--%>
<%--<span class="r-cat-other-price-true shk-price">204,00</span>--%>
<%--<span style="display:none">102</span>--%>
<%--</div>--%>
<%--<button type="submit" style="margin-left: 1%; margin-bottom: 1%;"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 30px; color: #252a2f;"></span></button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</fieldset>--%>
<%--</form>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="pagination pagination-centered" style="margin-left:200px;">--%>
<%--<li class="disabled"><span><<</span></li>--%>
<%--<li class="active"><span>1</span></li>--%>
<%--<li><a href="#">2</a></li>--%>
<%--<li><a href="#">3</a></li>--%>
<%--<li><a href="#">4</a></li>--%>
<%--<li><a href="#">5</a></li>--%>
<%--<li><a href="#">>></a></li>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<style>--%>
<%--.sort-price #sortpopularity, .sort-price label, .sort-pop #sortprice, .sort-pop label {cursor: pointer}--%>
<%--#sortprice {cursor: pointer}--%>
<%--</style>--%>

</body>
</html>
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
    <link rel="stylesheet" href="css/product_content.css"/>
    <script>
        window.onload = function () {
            $('[data-target="#myModalUpdate"]').click(function () {
                document.getElementById('idCategory').value = this.id;
                document.getElementById('nameCategory').value = this.name;
            })
        $('[data-target="#myModalUpdateGoods"]').click(function () {
            console.log(this.id);
            document.getElementById('goodsId').value = this.id;
//            document.getElementById('goodsName').value = (this.id).idname;
//            document.getElementById('goodsNumber').value = (this.id).number;
//            document.getElementById('goodsPrice').value = (this.id).unitPrice;
//            document.getElementById('goodsProducer').value = (this.id).producer;
//            document.getElementById('goodsDescription').value = (this.id).description;
//            document.getElementById('name_category').value = (this.id).createdDate;
        })
        };
    </script>
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
                <li><a href="controller?command=select_language&language=EN&page=path.page.showManagement"><span class="bfh-languages" data-language="en_US" data-flags="true"></span>EN</a></li>
                <li><a href="controller?command=select_language&language=RU&page=path.page.showManagement"><span class="bfh-languages" data-language="ru_RU" data-flags="true"></span>RU</a></li>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">${addCategory}</h4>
            </div>
            <div class="modal-body">

                <form action="controller" method="POST" id="add_category">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="add_category"/>
                    <input type="text" placeholder="${nameCategory}" name="categoryName" class="form-input">
                    <p>
                        <input type="submit" value="${add}" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModalUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalUpdateLabel">${editCategory}</h4>
            </div>
            <div class="modal-body">

                <form action="controller" method="POST" id="update_category">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="update_category"/>
                    <input type="hidden" id="idCategory" name="categoryId" value=""/>
                   ${nameCategory}: <input type="text" name="categoryName" id ="nameCategory" class="form-input">
                    <p>
                        <input type="submit" value="${edit}" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModalUpdateGoods" tabindex="-1" role="dialog" aria-labelledby="myModalUpdateGoodsLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalUpdateGoodsLabel">${editGoods}</h4>
            </div>
            <div class="modal-body">
                <form action="controller" method="POST" id="update_goods">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="update_goods"/>
                    <input type="hidden" name="idGoods" id="goodsId" value=""/>
                    <input type="text" placeholder="${nameLabel}" name="goodsName" class="form-input">
                    <input type="number" min="0" placeholder="${numberLabel}" name="goodsNumber" class="form-input">
                    <input type="text" placeholder="${numberLabel}" name="goodsPrice" class="form-input">
                    <input type="text" placeholder="${producerLabel}" name="goodsProducer" class="form-input">
                    <input type="text" placeholder="${descriptionLabel}"  name="goodsDescription" class="form-input">
                    <select id="name_category" name="categoryName">
                        <option value="">${chooseCategory}:</option>
                        <c:forEach var="category" items="${categoryList}">
                            <option><c:out value="${category.categoryName}"/></option>
                        </c:forEach>
                    </select>
                    <p>
                        <input type="submit" value="${edit}" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModalGoods" tabindex="-1" role="dialog" aria-labelledby="myModalGoodsLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalGoodsLabel">${addGoods}</h4>
            </div>
            <div class="modal-body">
                <form action="controller" method="POST" id="add_goods">
                    <div class="message js-form-message"></div>
                    <input type="hidden" name="command" value="add_goods"/>
                    <input type="text" placeholder="${nameLabel}" name="goodsName" class="form-input">
                    <input type="number" min="0" placeholder="${numberLabel}" name="goodsNumber" class="form-input">
                    <input type="text" placeholder="${priceLabel}" name="goodsPrice" class="form-input">
                    <input type="text" placeholder="${producerLabel}" name="goodsProducer" class="form-input">
                    <input type="text" placeholder="${descriptionLabel}"  name="goodsDescription" class="form-input">
                    <select id="categoryName" name="categoryName">
                        <option value="">${chooseCategory}:</option>
                        <c:forEach var="category" items="${categoryList}">
                            <option><c:out value="${category.categoryName}"/></option>
                        </c:forEach>
                    </select>
                    <p>
                        <input type="submit" value="${add}" style="margin-left: 45%;margin-top: 3%"
                               class="btn btn-success"/></p>
                    <br/>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr class="warning">
            <th align="center">№</th>
            <th align="center">${nameLabel}</th>
            <th align="center">${numberLabel}</th>
            <th align="center">${priceLabel}</th>
            <th align="center">${producerLabel}</th>
            <th align="center">${descriptionLabel}</th>
            <th align="center">${categoryLabel}</th>
            <th align="center">${remove}</th>
            <th align="center">${edit}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="goods" items="${goodsList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${goods.name}"/></td>
                <td><c:out value="${goods.number}"/></td>
                <td><c:out value="${goods.unitPrice}"/></td>
                <td><c:out value="${goods.producer}"/></td>
                <td><c:out value="${goods.description}"/></td>
                <td><c:out value="${goods.createdDate}"/></td>
                <td>
                    <a href="controller?command=remove_goods&idGoods=${goods.idGoods}"
                       class="glyphicon glyphicon-trash"></a>
                </td>
                <td>
                    <a class="glyphicon glyphicon-pencil" data-toggle="modal"
                       data-target="#myModalUpdateGoods" id="${goods.idGoods}" href="#"></a>
                      </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalGoods">
            ${addGoods}
        </button>
    </p>
    <p>
    <table class="table table-bordered">
        <thead>
        <tr class="warning">
            <th align="center">№</th>
            <th align="center">${nameCategory}</th>
            <th align="center">${edit}</th>
            <th align="center">${remove}</th>
            <th align="center">${select}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categoryList}" varStatus="i">
            <tr class="success" align="center">
                <td>${i.count}</td>
                <td><c:out value="${category.categoryName}"/></td>
                <td>
                    <a class="glyphicon glyphicon-pencil" data-toggle="modal"
                       data-target="#myModalUpdate" name="${category.categoryName}" id="${category.idCategory}" href="#"></a>
                </td>
                <td>
                    <a href="controller?command=remove_category&categoryId=${category.idCategory}"
                       class="glyphicon glyphicon-trash"></a>
                </td>
                <td>
                    <a href="controller?command=shop_management&categoryId=${category.idCategory}"
                       class="glyphicon glyphicon-ok"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="controller?command=shop_management"
       class="glyphicon glyphicon-ok">${selectAllGoods}</a>
    </p>
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
        ${addCategory}
    </button>

</div>
</body>
</html>

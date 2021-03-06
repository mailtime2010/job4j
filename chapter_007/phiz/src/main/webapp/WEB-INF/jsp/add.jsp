<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <link href="img/favicon.png" rel="shortcut icon" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <title>ADD</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/headerGate.jsp"/>
<section>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p><b>Добавление в список программиста перешедшего на сторону Java.</b></p>
            </div>
        </div>
        <div class="table-top-row">
            <div class="right">
                <a class="link" href="<c:url value="/gate"/>">Главная</a>
            </div>
        </div>
        <div class="table-top-row">
            <form action="<c:url value="/upload"/>" method="POST" enctype="multipart/form-data">
                <div class="input-container">
                    <i class="icon">
                        <img alt="name" src="img/name.png" title="name"></i>
                    <label>
                        <input class="input-field" name="name" placeholder="Имя" required type="text">
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon">
                        <img alt="email" src="img/email.png" title="email"></i>
                    <label>
                        <input class="input-field" name="email" placeholder="Почта" required type="text">
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon">
                        <img alt="login" src="img/login.png" title="login"></i>
                    <label>
                        <input class="input-field" name="login" placeholder="Логин" required type="text">
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon">
                        <img alt="Пароль" src="img/favicon.png" title="Пароль"></i>
                    <label>
                        <input class="input-field" name="password" placeholder="Пароль" required type="password">
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <label>
                        <input name="file" type="file" accept="image/jpeg,image/png,image/bmp"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <button class="btn" type="submit"><b>Сохранить</b></button>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <label>
                        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <label>
                      <span style="color:red">
                            <c:out value="${sessionScope.infoUpload}"/>
                        </span>
                    </label>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>




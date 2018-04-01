<%--
  Created by IntelliJ IDEA.
  User: navro
  Date: 28.03.2018
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="resources/js/libs/jquery-3.2.1.min.js"></script>

<script src="resources/js/libs/popper.min.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>

<link href="resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="resources/css/autor.css" rel="stylesheet" type="text/css" media="all"/>
<script src="resources/js/custom/login.js"></script>

<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-8">
            <h1 class="text-center login-title"></h1>
            <div class="account-wall">
                <img class="profile-img" src="http://myzone.dwvighbb5mwqnytmb.netdna-cdn.com/wp-content/uploads/2014/01/Netcracker-logo.jpg"
                     alt="">
                <form class="form-signin">
                    <input type="text" class="form-control  jsInputNameAutor" placeholder="Email" required autofocus>
                    <input type="password" class="form-control jsInputPassword" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block jsButtonAutor" type="submit">
                        Sign in</button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>

                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>

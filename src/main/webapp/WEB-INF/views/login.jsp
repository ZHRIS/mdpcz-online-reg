<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%----%><c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>
</head>
<body>

<div class="container">
    <%--<form method="POST" action="${contextPath}/user/login" class="form-signin">
       <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/user/add">Create an account</a></h4>
        </div>
    </form>--%>

        <c:if test="${param.error ne null}">
        <div>
            Invalid username and password.
        </div>
        </c:if>
        <c:if test="${param.logout ne null}">
        <div>
            You have been logged out.
        </div>
        </c:if>
        <%--<form action="/user/login" method="post">
            <div><label> User Name : <input type="text" name="userName"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div><input type="submit" value="Sign In"/></div>
        </form>--%>


        <form method="POST" action="${contextPath}/login" class="form-signin">
            <h2 class="form-heading">Log in</h2>

            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <input name="username" type="text" class="form-control" placeholder="Username"
                       autofocus="true"/>
                <input name="password" type="password" class="form-control" placeholder="Password"/>
                <span>${error}</span>
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                <h4 class="text-center"><a href="${contextPath}/account/add">Create an account</a></h4>
            </div>

        </form>
</body>
</div>

</body>
</html>

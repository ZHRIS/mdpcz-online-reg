<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Create an account</title>
</head>
<body>
<div>

    <spring:url value="/user/save" var="postUrl"/>

    <form:form class="form-horizontal" method="post"
               modelAttribute="user" action="${postUrl}">

        <form:hidden path="id"/>

        <fieldset>
            <c:choose>
                <c:when test="${user['new']}">
                    <legend>Add User Details</legend>
                </c:when>
                <c:otherwise>
                    <legend>Update User Details</legend>
                </c:otherwise>
            </c:choose>
            <br/>

            <h2> Create your account</h2>
            <spring:bind path="userName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Email address </label>
                    <div class="col-sm-10">
                        <form:input path="userName" type="text" class="form-control"
                                    id="userName" placeholder="Email Address"/>
                        <span class="text-danger"><form:errors path="userName"/></span>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="firstName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">First Name </label>
                    <div class="col-sm-10">
                        <form:input path="firstName" type="text" class="form-control"
                                    id="firstName" placeholder="First Name"/>
                        <span class="text-danger"><form:errors path="firstName"/></span>
                    </div>
                </div>
            </spring:bind>

           <%-- <spring:bind path="middleName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Middle Name *</label>
                    <div class="col-sm-10">
                        <form:input path="middleName" type="text" class="form-control"
                                    id="middleName" placeholder="Middle Name"/>
                        <span class="text-danger"><form:errors path="middleName"/></span>
                    </div>
                </div>
            </spring:bind>



            <spring:bind path="lastName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Last Name *</label>
                    <div class="col-sm-10">
                        <form:input path="lastName" type="text" class="form-control"
                                    id="lastName" placeholder="Last Name"/>
                        <span class="text-danger"><form:errors path="lastName"/></span>
                    </div>
                </div>
            </spring:bind>--%>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Password *</label>
                    <div class="col-sm-10">
                        <form:input path="password" type="password" class="form-control"
                                    id="password" placeholder="Password"/>
                        <span class="text-danger"><form:errors path="password"/></span>
                    </div>
                </div>
            </spring:bind>

            <%--<spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Confirm Password *</label>
                    <div class="col-sm-10">
                        <form:input path="passwordConfirm" type="password" class="form-control"
                                    id="passwordConfirm" placeholder="Password Confirm"/>
                        <span class="text-danger"><form:errors path="passwordConfirm"/></span>
                    </div>
                </div>
            </spring:bind>
--%>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${userForm['new']}">
                            <button type="submit" class="btn-lg btn-primary pull-right">Add
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn-lg btn-primary pull-right">Update
                            </button>
                        </c:otherwise>
                    </c:choose>
                    <a href="<c:url value="/user/login"/>" class="btn btn-danger">Cancel</a></td>
                </div>
            </div>
        </fieldset>
    </form:form>
</div>

</body>
</html>

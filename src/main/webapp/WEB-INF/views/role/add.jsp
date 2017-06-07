<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>Role</title>
</head>
<body>

<div class="row">
    <div class="col-sm-offset-3 col-lg-6 col-sm-6 well">

        <spring:url value="/role/save" var="postUrl"/>

        <form:form class="form-horizontal" method="post"
                   modelAttribute="role" action="${postUrl}">

            <form:hidden path="id"/>
            <fieldset>
                <c:choose>
                    <c:when test="${role['new']}">
                        <legend>Add Role</legend>
                    </c:when>
                    <c:otherwise>
                        <legend>Update Role</legend>
                    </c:otherwise>
                </c:choose>
                <br/>

                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Name *</label>
                        <div class="col-sm-10">
                            <form:input path="name" type="text" class="form-control"
                                        id="name" placeholder="Name"/>
                            <span class="text-danger"><form:errors path="name"/></span>
                        </div>
                    </div>
                </spring:bind>

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
                        <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a></td>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>

</body>
</html>

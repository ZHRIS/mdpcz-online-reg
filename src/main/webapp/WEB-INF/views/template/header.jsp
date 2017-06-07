<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${title}</title>
    <spring:url value="/css/pharmacy.css" var="coreCss"/>
    <spring:url value="/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/css/datatables.min.css" var="dataTablesCSS"/>
    <spring:url value="/css/jquery.dataTables.min.css" var="jqueryDataTablesCSS"/>
    <spring:url value="/css/jquery-ui.min.css" var="jqueryUiCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${dataTablesCSS}" rel="stylesheet"/>
    <link href="${jqueryDataTablesCSS}" rel="stylesheet"/>
    <link href="${jqueryUiCss}" rel="stylesheet"/>
    <script>
        var requestContextPath = '${pageContext.request.contextPath}';
        var patientSummaryId = '${patient.id}';
    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>">Mdpcz</a>
        </div>

        <ul class="nav navbar-right top-nav">
            <li id="count_prescriptions"></li>
        </ul>

    </div>
</nav>

<div class="container">

<br/><br/>
<br/>
<ul class="nav nav-pills">
    <li role="presentation">
        <a href="<c:url value="/"/>">Home</a>
    </li>

</ul>
<br/>

<div class="row">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>
</div>

<%--
<c:if test="${patient!=null && patient.id!=null}">
    <%@include file="../patient/patient_summary.jsp" %>
</c:if>--%>

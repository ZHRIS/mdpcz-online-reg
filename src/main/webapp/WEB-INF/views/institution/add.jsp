<%@include file="../template/header.jsp" %>

<div class="row">
    <spring:url value="/institution/save" var="postUrl"/>

    <form:form class="" method="post"
               modelAttribute="institution" action="${postUrl}">

        <form:hidden path="id"/>
        <form:hidden path="user"/>

        <fieldset>
            <legend>Apply for an Institution</legend>
            <br/>

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Institution Name</label>
                    <div class="col-sm-10">
                        <form:input path="name" type="text" class="form-control"
                                    id="name" placeholder="Enter name here"/>
                        <span class="text-danger"><form:errors path="name"/></span>
                    </div>
                </div>
            </spring:bind>


        </fieldset>
    </form:form>
</div>

<%@include file="../template/footer.jsp" %>

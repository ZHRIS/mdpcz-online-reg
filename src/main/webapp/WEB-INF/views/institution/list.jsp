<%@include file="../template/header.jsp" %>

<div class="container">
    <table class="table table-striped">
        <caption>Institution List</caption>
        <thead>

        <tr>
            <th>Name</th>
        </tr>

        </thead>


        <c:forEach var="item" items="${list}">
            <tr>
                <td>
                        ${item.name}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="../template/footer.jsp" %>
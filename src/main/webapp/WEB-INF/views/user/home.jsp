<%@include file="../template/header.jsp" %>
<% String globalReg = "${pageContext.request.userPrincipal.name}"; %>

<div class="row">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <br/>
    <div id="tabs">
        <ul>
            <li><a href="#demographic" onclick="getPracitioner(803217)">Demographic</a></li>
            <li><a href="#conactInfo">Contact Detail</a></li>
            <li><a href="#cpd">Cpd Information</a></li>
            <li><a href="#institutions">Institutions</a></li>
        </ul>

        <div id="demographic" id="practititionerDemographic">
            <%--<div>
                <div class="row">
                    <label class="col-sm-2">First Name:</label>
                    <div class="col-sm-10">{{}}</div>
                </div>

                <div class="row">
                    <label class="col-sm-2">Last Name</label>
                    <div class="col-sm-10">{{}}</div>
                </div>
            </div>--%>
            <div jput="tbody_template">
                <tr>
                    First Name:
                </tr>
                <tr>

                </tr>
                <tr>
                    <td>{{dateOfBirth}}</td>
                </tr>
                <td>Reg number: ${pageContext.request.userPrincipal.name}</td>
                </tr>
            </div>
            <table>
                <tbody id="tbody">
                </tbody>
            </table>

        </div>

        <div id="conactInfo">
            <div class="row">
                <a href="<c:url value="/address/${patient.id}/add"/>" class="btn btn-lg btn-primary"
                   style="float: right;">Add Address
                </a>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Address Detail</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${addressList}">
                    <tr>
                        <td>${item.detail}</td>
                        <td>

                            <a href="<c:url value="/address/${item.id}/update"/>">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div id="cpd">
            <div class="row">
                <label class="col-sm-2">First Name:</label>
                <div class="col-sm-10"></div>
            </div>

            <div class="row">
                <label class="col-sm-2">Last Name</label>
                <div class="col-sm-10"></div>
            </div>

        </div>

        <div id="institutions">
            <div class="row">
                <a href="<c:url value="/institution/add"/>" class="" style="...">
                    Apply for Institution</a>
            </div>

            <table id="patientTable" class="table table-striped">
                <thead>
                <tr>
                    <th>Institution Name</th>
                    <th>City</th>
                    <th>Country</th>
                </tr>
                </thead>


            </table>

        </div>
    </div>
</div>
<%@include file="../template/footer.jsp" %>

<script>
<%--var regNo ="<%=globalReg%>"--%>
//var regNo = 803217;
    /*$.ajax({
        url: 'http://localhost:8080/practititioner/' + regNo,
        dataType: 'json',
        success: function (data) {
            var row = $('<tr>' +
                '<td>' + data.firstName + '</td>' +
                '<td>' + data.lastName + '</td>' +
                '</tr>');
            $('#practititionerDemographic').append(row);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error: ' + textStatus + ' - ' + errorThrown);
        }
    });*/


function getPracitioner(regNo) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/practititioner/' + regNo,
        dataType: 'json',
        success: function (data) {

            var row = $('<tr>' +
                '<td>' + data.fullName + '</td>' +
                '<td>' + data.lastName + '</td>' +
                '</tr>');
            $('#practititionerDemographic').append(row);
        }
    });

}


</script>
<%--
</body>
</html>
--%>

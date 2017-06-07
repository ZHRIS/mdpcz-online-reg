$(function () {

    $("#tabs").tabs();

    $("#dateOfBirth").datepicker({
        dateFormat: "dd/mm/yy"
    });

    $("#dateCreated").datepicker({
        dateFormat: "dd/mm/yy"
    });

    $("#expiryDate").datepicker({
        dateFormat: "dd/mm/yy"
    });

    $("#accordionMenu").accordion();

});

/***************** Get list of institutions **************/
$.ajax({
    url: 'http://localhost:8080/institution/list',
    dataType: 'json',
    success: function (data) {
        for (var i = 0; i < data.length; i++) {
            var row = $('<tr><td><a id="' + data[i].id + '" href="#" class="list-group-item" onclick="showInstititutionModal(' + data[i].id + ')">' + data[i].name + '</a> </td>' +
//                    '<td>' + data[i].city + '</td>' +
//                    '<td>' + data[i].county + '</td>' +
                '</tr>');
            //$("#patient_search_result_list").show();
            $('#institutions').append(row);
        }
    },
    error: function (jqXHR, textStatus, errorThrown) {
        alert('Error: ' + textStatus + ' - ' + errorThrown);
    }
});
/***************** Get list of institutions **************/


function showInstititutionModal(id) {

    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/institution/' + id,
        success: function (data) {

            obj = data;
            $('#name').html('<label id="name">' + obj.name + '</label>');
            $("#institutionModal").modal('show');
        }
    });

    // next add the onclick handler
    $("#institutionModal").click(function () {
        $("#dialog").dialog("open");
        return false;
    });
}


/***************** Get Get practititioner **************/

var currentUserName = $().SPServices.SPGetCurrentUser({
    fieldName: "Title",
    debug: false
});

/*function getPractitioner(currentUserName) {


 /!*$.ajax({
 url: 'http://localhost:8080/practititioner/' + regNumber,
 dataType: 'json',
 success: function (data) {

 },
 error: function (jqXHR, textStatus, errorThrown) {
 alert('Error: ' + textStatus + ' - ' + errorThrown);
 }
 });*!/

 $("#tbody").jPut({
 jsonData: json,
 url: 'http://localhost:8080/practititioner/' + currentUserName,
 name: "tbody_template",
 });

 }*/


function getUserInformation() {

    $.ajax({

    });

}

function getProfileId(){
    sforce.connection.sessionId = window.ApiUtils.getSessionId();
    sforce.connection.query(
        "SELECT ProfileId FROM User WHERE Id = '" + window.UserContext.userId + "'",
        {
            onSuccess:
                function(result){
                    document.getElementById('lblProfileId').innerHTML = result.records.ProfileId;
                    var profId= result.records.ProfileId;
                    alert('Profile Id: ' + profId);
                },
            onFailure:
                function(){
                    document.getElementById('lblProfileId').innerHTML = '#ERROR';
                }
        }
    );
}

getProfileId();

var thisUserAccount = $().SPServices.SPGetCurrentUser({
    fieldName: "Name",
    debug: false
});

/***************** Get practititioner **************/
$.ajax({
    url: 'http://localhost:8080/practititioner/' + thisUserAccount,
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
});

/***************** Get practititioner **************/


/**********Patient Search********/
var patientSearchTerm = null;
function search_patient(value) {
    if (patientSearchTerm != null) patientSearchTerm.abort();
    if (value.length >= 3) {
        patientSearchTerm = $.ajax({
            url: requestContextPath + "/patient/search_list",
            data: {'searchTerm': value},
            success: function (data) {
                resultTable = "";
                $.map(data, function (obj, i) {
                    resultTable += ('<tr><td><a id="' + obj.id + '" href="' + requestContextPath + "/patient/" + obj.id + '">' + obj.patientNumber + '</a></td><td>' + obj.firstName + '</td><td>' + obj.middleName + '</td><td>' + obj.lastName + '</td><td>' + obj.age + '</td><td>' + obj.gender + '</td><td><a id="' + obj.id + '" href="' + requestContextPath + "/patient/" + obj.id + '">Manage Patient</a></td></tr>');
                });
                $("#patient_search_result_div").show();
                $("#patient_search_result_list").html(resultTable);
            }
        });
    } else {
        $("#patient_search_result_div").hide();
    }
}
/**********End Patient Search********/


/***************** Get one institutions **************/

$.ajax({
    url: requestContextPath + "/admin/product/drug_search_list",
    dataType: 'json',
    success: function (data) {
        resultTable = "";
        $.map(data, function (obj, i) {
            resultTable += ('<a id="' + obj.id + '" href="#" class="list-group-item" onclick="add_product_property(' + obj.id + ')">' + obj.name + '</a>');
        });
        $("#institutions").html(resultTable);
    }
});

/***************** Get one of institutions **************/
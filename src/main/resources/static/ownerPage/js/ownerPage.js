function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}


function parkingUsages(){

    $("#cardInformation").hide();
    $("#profile").hide();
    $("#reportError").hide();
    $("#exit").hide();
    $("#driverUsages").show();
    $("#parkButtonOpen").hide();

    var userId;
    var entry;
    var departure;
    var totalTime;
    var price;
    var district;
    var province;
    var address;
    var name;

    var ownerName=sessionStorage.getItem("owner")
    var userInfo={
        name:null,
        entry:null,
        departure:null,
        totalTime:null,
        price:null,
        district:null,
        province:null,
        address:null
    }
    data=JSON.stringify(userInfo);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/information/parkingSpacesUsagesApi/getParkingSpacesUsagesOwner/"+ownerName,
        success:function (data) {

            var myTable="";
            var i;
            for(i=0;i<data.length;i++){
                myTable += "<th scope=\"row\">" +i + "</th>";
                myTable += "<td>" + data[i].name + "</td>";
                myTable += "<td>" + data[i].province + "</td>";
                myTable += "<td>" + data[i].district + "</td>";
                myTable += "<td>" + data[i].address + "</td>";
                myTable += "<td>" + data[i].entry + "</td>";
                myTable += "<td>" + data[i].departure + "</td>";
                myTable += "<td>" + data[i].totalTime + "</td>";
                myTable += "<td>" + data[i].price + "</td>";
            }
            myTable += "";
            document.getElementById("getParkingInfo").innerHTML = myTable;
        },error:function (data) {
            alert(data+" Error");
        }
    })


}

$("#closeButton").click(function (event) {
    $("#parkButtonClose").hide();
    $("#parkButtonOpen").show();
    $("#verticalLine").css("background-color","#6c757d");
});

$("#openButton").click(function (event) {
    $("#parkButtonOpen").hide();
    $("#parkButtonClose").show();
    $("#verticalLine").css("background-color","#007bff");
});

$(function () {
    $('#datetimepicker7').datetimepicker();
    $('#datetimepicker8').datetimepicker({
        useCurrent: false
    });
    $("#datetimepicker7").on("change.datetimepicker", function (e) {
        $('#datetimepicker8').datetimepicker('minDate', e.date);
    });
    $("#datetimepicker8").on("change.datetimepicker", function (e) {
        $('#datetimepicker7').datetimepicker('maxDate', e.date);
    });
});

window.onload = parkingUsages();
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

var ownerName=sessionStorage.getItem("owner");
var parkStatus;
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

function getParkAreas(Id){

    var nameId;
    var ownerId;
    var latitude;
    var longitude;
    var parkStatus;
    var district;
    var province;
    var address;

    var parkArea={
        nameId:null,
        ownerId:ownerId,
        latitude:null,
        longitude:null,
        parkStatus:null,
        district:null,
        province:null,
        address:null
    }

    data=JSON.stringify(parkArea);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/information/parkingSpacesApi/getAllByOwnerId/"+Id,
        success:function (data) {
            if(data[0].parkStatus=="CLOSED"){
                $("#parkButtonClose").hide();
                $("#parkButtonOpen").show();
                $("#verticalLine").css("background-color","#6c757d");
            }
            else if(data[0].parkStatus=="OPEN"){
                $("#parkButtonOpen").hide();
                $("#parkButtonClose").show();
                $("#verticalLine").css("background-color","#1e7e34");
            }
            else if(data[0].parkStatus=="BUSY"){
                $("#parkButtonOpen").hide();
                $("#parkButtonClose").show();
                $("#verticalLine").css("background-color","red");
            }





        },error:function (data) {
            alert(data+" Error");
        }
    })
}


function getOwnerInfo(ownerName){

    var name;
    var surname;
    var idName;
    var mail;
    var phoneNumber;
    var ibanNumber;


    var userInfo={
        name:null,
        surname:null,
        idName:null,
        mail:null,
        phoneNumber:null,
        ibanNumber:null,
    }
    data=JSON.stringify(userInfo);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/information/parkingOwnerInformationApi/getOwnerInfo/"+ownerName,
        success:function (data) {

            $("#nameSurname").text((data.name+" "+data.surname));
            $("#idName").text((data.idName+" "));
            $("#mail").text((data.mail+" "));
            $("#phoneNumber").text((data.phoneNumber+" "));
            $("#carPlate").text((data.ibanNumber+" "));

        },error:function (data) {
            alert(data+" Error");
        }
    })
}

function parkInfo(){
    $("#profile").hide();
    $("#parkInfo").show();

    parkingUsages();
    getParkAreas(ownerName);



}

function profile(){

    $("#parkInfo").hide();
    $("#profile").show();

    getOwnerInfo(ownerName);

}


function changeParkStatus(parkId,parkStatus){

    data=JSON.stringify(parkStatus);

    $.ajax({
        type:"PUT",
        contentType: 'application/json; charset=UTF-8',
        url:"/information/parkingSpacesApi/updateByParkId/"+parkId,
        data: data,
        success:function (data) {

        },error:function (data) {
            alert(data+" Error");
        }
    })
}




$("#closeButton").click(function (event) {
    $("#parkButtonClose").hide();
    $("#parkButtonOpen").show();
    $("#verticalLine").css("background-color","#6c757d");

    changeParkStatus("park1","CLOSED");

});

$("#openButton").click(function (event) {
    $("#parkButtonOpen").hide();
    $("#parkButtonClose").show();
    $("#verticalLine").css("background-color","#1e7e34");

    changeParkStatus("park1","OPEN");


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

window.onload = parkInfo();
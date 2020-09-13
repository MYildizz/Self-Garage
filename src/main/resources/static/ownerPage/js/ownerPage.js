var obj = JSON.parse(document.cookie)


if(obj.ownerId==null){
    window.location.href = "/ownerLogin";
}


function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

var ownerName=obj.ownerId;
var parkStatus;
var parkCloseList=[];
var parkOpenList=[];
var parkSize;
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

    var ownerName=obj.ownerId
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
            for(i=data.length-1; i>=0;i--){
                myTable +=" <tr> "
                myTable += "<th scope=\"row\">" +i + "</th>";
                myTable += "<td>" + data[i].name + "</td>";
                myTable += "<td>" + data[i].province + "/ "+ data[i].district +"</td>";
                myTable += "<td>" + data[i].entry + "</td>";
                myTable += "<td>" + data[i].departure + "</td>";
                myTable += "<td>" + data[i].totalTime + " Dk "+ "</td>";
                myTable += "<td>" + data[i].price + " Tl "+"</td>";
                myTable +=" </tr> "
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
            var sizeTemp=data.length;
            parkSize=sizeTemp;
            sessionStorage.setItem("size",sizeTemp);
            getParks(sizeTemp);
            var i;
            for(i=0;i<sizeTemp;i++){
                var parkButtonClose="#parkButtonClose"+i;
                var parkButtonOpen="#parkButtonOpen"+i;
                var verticalLine="#verticalLine"+i;


                if(data[i].parkStatus=="CLOSED"){
                    $(parkButtonClose).hide();
                    $(parkButtonOpen).show();
                    $(verticalLine).css("background-color","#6c757d");
                }
                else if(data[i].parkStatus=="OPEN"){
                    $(parkButtonOpen).hide();
                    $(parkButtonClose).show();
                    $(verticalLine).css("background-color","#1e7e34");
                }
                else if(data[i].parkStatus=="BUSY"){
                    $(parkButtonOpen).hide();
                    $(parkButtonClose).show();
                    $(verticalLine).css("background-color","red");
                }
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
    $("#reportError").hide();
    $("#parkInfo").show();

    getParkAreas(ownerName);
    parkingUsages();




}

function profile(){
    $("#reportError").hide();
    $("#parkInfo").hide();
    $("#profile").show();

    getOwnerInfo(ownerName);

}

function reportError(){
    $("#parkInfo").hide();
    $("#profile").hide();
    $("#exit").hide();
    $("#reportError").show();
}

function reportErrorMessage(){
    var name = obj.ownerId;
    var message = $("#FormControlTextarea").val();

    $.ajax({
        url: "/mail/sendComplaint",
        type: "POST",
        data: {
            name: name,
            message: message
        },
        cache: false,
        success: function() {
            alert("Geri bildiriminiz tarafımıza ulaşmıştır. Teşekkür ederiz.")
        },
        error: function() {
            alert("sunucan cevap alınamadı")
        }
    });

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

function closeButtons(buttonId){
    var tempNumber=parseInt(buttonId.charAt(11))+1;
    var parkId="park"+tempNumber;
    var parkButtonClose="#park"+buttonId;
    var parkButtonOpen="#parkButtonOpen"+buttonId.charAt(11);
    var verticalLine="#verticalLine"+buttonId.charAt(11);
    $(parkButtonClose).hide();
    $(parkButtonOpen).show();
    $(verticalLine).css("background-color","#6c757d");
    changeParkStatus(parkId,"CLOSED");

}


function openButtons(buttonId){
    var tempNumber=parseInt(buttonId.charAt(10))+1;
    var parkId="park"+tempNumber;
    var parkButtonClose="#parkButtonClose"+buttonId.charAt(10);
    var parkButtonOpen="#park"+buttonId;
    var verticalLine="#verticalLine"+buttonId.charAt(10);
    $(parkButtonOpen).hide();
    $(parkButtonClose).show();
    $(verticalLine).css("background-color","#1e7e34");
    changeParkStatus(parkId,"OPEN");
}

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




$("#saveTime").click(function (event){
    var firstDate=$('#datetimepicker7').find("input").val();
    var secondDate=$('#datetimepicker8').find("input").val();

    var firstMonth= firstDate.substring(0, 2);
    var firstDay= firstDate.substring(3, 5);
    var firstYear= firstDate.substring(6, 10);
    var firstHour=firstDate.substring(11, 13);
    var firstMinute=firstDate.substring(13, 16);

    firstHour.split(":").pop();
    firstMinute.split(":").pop();
    firstMinute.split(" ").pop();


    if(firstDate.includes("PM")){
        firstHour=parseInt(firstHour,10)+12;

    }

    if(firstMinute.includes(":")){
        firstMinute= firstMinute.substring(1,3);
    }
    else{
        firstMinute= firstMinute.substring(0,2);
    }

    var firstDate= firstYear+"-"+firstMonth+"-"+firstDay+" "+firstHour+":"+firstMinute+":00";


    var secondMonth= secondDate.substring(0, 2);
    var secondDay= secondDate.substring(3, 5);
    var secondYear= secondDate.substring(6, 10);
    var secondHour=secondDate.substring(11, 13);
    var secondMinute=secondDate.substring(13, 16);

    secondHour.split(":").pop();
    secondMinute.split(":").pop();
    secondMinute.split(" ").pop();


    if(secondDate.includes("PM")){
        secondHour=parseInt(secondHour,10)+12;

    }

    if(secondMinute.includes(":")){
        secondMinute= secondMinute.substring(1,3);
    }
    else{
        secondMinute= secondMinute.substring(0,2);
    }

    var secondDate= secondYear+"-"+secondMonth+"-"+secondDay+" "+secondHour+":"+secondMinute+":00";

    alert("Talebiniz Alınmıştır");



});

window.onload = parkInfo();
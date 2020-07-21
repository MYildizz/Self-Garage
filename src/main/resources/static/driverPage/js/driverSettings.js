/* Set the width of the side navigation to 250px */
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

function profile(){
    $("#cardInformation").hide();
    $("#driverUsages").hide();
    $("#reportError").hide();
    $("#exit").hide();
    $("#profile").show();

    var name;
    var surname;
    var idName;
    var mail;
    var phoneNumber;
    var carPlate;

    var driverName=sessionStorage.getItem("userId")

    var userInfo={
        name:null,
        surname:null,
        idName:null,
        mail:null,
        phoneNumber:null,
        carPlate:null,
    }
    data=JSON.stringify(userInfo);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/information/driverInformationApi/getDriverInfo/"+driverName,
        success:function (data) {

            $("#nameSurname").text((data.name+" "+data.surname));
            $("#idName").text((data.idName+" "));
            $("#mail").text((data.mail+" "));
            $("#phoneNumber").text((data.phoneNumber+" "));
            $("#carPlate").text((data.carPlate+" "));

        },error:function (data) {
            alert(data+" Error");
        }
    })

}

function parkingUsages(){

    $("#cardInformation").hide();
    $("#profile").hide();
    $("#reportError").hide();
    $("#exit").hide();
    $("#driverUsages").show();

    var userId;
    var entry;
    var departure;
    var totalTime;
    var price;
    var district;
    var province;
    var address;
    var name;

    var driverName=sessionStorage.getItem("userId")
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
        url:"/information/parkingSpacesUsagesApi/getParkingSpacesUsagesDriver/"+driverName,
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



function cardInformation(){
    $("#driverUsages").hide();
    $("#profile").hide();
    $("#reportError").hide();
    $("#exit").hide();
    $("#cardInformation").show();

    var name;
    var surname;
    var cardNo;
    var aa_yy;
    var cvc;
    var id_name;

    var id=sessionStorage.getItem("userId")

    var userInfo ={
        name:null,
        surname:null,
        cardNo:null,
        aa_yy:null,
        cvc:null,
        id_name:id
    }
    data=JSON.stringify(userInfo);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/DriverCreditCardInformation/getParkingSpacesUsagesDriver/"+id,
        success:function (data) {

            var myTable="";
            var i;
            for(i=0;i<data.length;i++){
                myTable += "<th scope=\"row\">" +i + "</th>";
                myTable += "<td>" + data[i].name + "</td>";
                myTable += "<td>" + data[i].surname + "</td>";
                myTable += "<td>" + data[i].cardNo + "</td>";
                myTable += "<td>" + data[i].aa_yy + "</td>";
                myTable += "<td>" + data[i].cvc + "</td>";
            }
            myTable += "";
            document.getElementById("getCardInfo").innerHTML = myTable;

        },error:function (data) {
            alert(data+" Error");
        }
    })

}

function reportError(){
    $("#driverUsages").hide();
    $("#profile").hide();
    $("#cardInformation").hide();
    $("#exit").hide();
    $("#reportError").show();
}

function exit() {
    $("#driverUsages").hide();
    $("#profile").hide();
    $("#cardInformation").hide();
    $("#reportError").hide();
    $("#exit").show();

    sessionStorage.removeItem("idName");
    alert("Çıkış Yapılıyor");

}

window.onload = profile();
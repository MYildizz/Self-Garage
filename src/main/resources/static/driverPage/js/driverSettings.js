var obj = JSON.parse(document.cookie);


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

    var driverName=obj.userId

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

    var driverName=obj.userId
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

    var id=obj.userId

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

            var cardNo=data[0].cardNo;
            cardNo=cardNo.substring(6,10);

            if(data.length==0){
                alert("demo aşamasında ödeme bilgileri bulunmamaktadır.");
            }

            var myTable="";
            var i;
            for(i=0;i<data.length;i++){
                myTable += "<th scope=\"row\">" +i + "</th>";
                myTable += "<td>" + data[i].name + "</td>";
                myTable += "<td>" + data[i].surname + "</td>";
                myTable += "<td>" + "********"+cardNo + "</td>";
                myTable += "<td>" + "**/**" + "</td>";
                myTable += "<td>" + "***" + "</td>";
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

function reportErrorMessage(){
    var name = obj.userId;
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
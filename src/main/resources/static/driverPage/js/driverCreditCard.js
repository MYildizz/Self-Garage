var name;
var surname;
var cardNo;
var aa_yy;
var cvc;
var id_name;


function getData(){
    var name=sessionStorage.getItem("userId")

    var userInfo ={
        name:null,
        surname:null,
        cardNo:null,
        aa_yy:null,
        cvc:null,
        id_name:name
    }
    data=JSON.stringify(userInfo);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/DriverCreditCardInformation/getParkingSpacesUsagesDriver/"+name,
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
            document.getElementById("getInfo").innerHTML = myTable;

        },error:function (data) {
            alert(data+" Error");
        }
    })



}
window.onload = getData();
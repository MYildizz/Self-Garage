var userId;
var entry;
var departure;
var totalTime;
var price;
var district;
var province;
var address;
var name

function getData(){
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
            document.getElementById("getInfo").innerHTML = myTable;

        },error:function (data) {
            alert(data+" Error");
        }
    })
}
window.onload = getData();

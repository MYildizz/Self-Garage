var  long=32.9380175 ;
var  lat=39.968061;
function initMap() {



    var nameId;
    var latitude;
    var longitude;
    var parkStatus;
    var district;
    var province;
    var address;

    var parkArea={
        nameId:null,
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
        url:"/information/parkingSpacesApi/getAllByParkStatusOpen",
        success:function (data) {

           long=  data[0].longitude;
          lat=data[0].latitude;


            var map = new google.maps.Map(document.getElementById("map"), {
                zoom: 15,
                center: new google.maps.LatLng(lat, long)
            });

            var i;

            for(i=0;i<data.length;i++){
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(data[i].latitude, data[i].longitude),
                    map: map,
                    title: "Hello World!"
                });
            }



        },error:function (data) {
            alert(data+" Error");
        }
    })



}
var lastname = sessionStorage.getItem("userId");




window.onload = getParkSpaces();


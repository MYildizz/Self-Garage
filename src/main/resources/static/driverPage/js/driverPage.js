var longitude;
var latitude;
var marker;
var map;
var nearDistanceLongitude;
var nearDistanceLatitude;
var directionsService;



function initMap() {

    document.getElementById("rezerveParkArea").style.display="none";
    document.getElementById("iptalEt").style.display="none";

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

            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (position) {
                    pos = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    };

                     map = new google.maps.Map(document.getElementById("map"), {
                        zoom: 15,
                        center: new google.maps.LatLng(pos.lat, pos.lng),
                        icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png'
                    });


                    const cityCircle = new google.maps.Circle({
                        strokeColor: "#34495E",
                        strokeOpacity: 1,
                        strokeWeight: 2,
                        fillColor: "#34495E",
                        fillOpacity: 0.35,
                        map,
                        center: new google.maps.LatLng(pos.lat, pos.lng),
                        radius: 420

                    });

                    var marker2 = new google.maps.Marker({
                        position: new google.maps.LatLng(pos.lat, pos.lng),
                        map: map,
                        title: "Buradasınız",
                        icon: 'http://www.robotwoods.com/dev/misc/bluecircle.png',
                        scale: 100
                    });
                    var distance= google.maps.geometry.spherical.computeDistanceBetween (new google.maps.LatLng(pos.lat, pos.lng), new google.maps.LatLng(data[0].latitude, data[0].longitude));
                    var directionsDisplay = new google.maps.DirectionsRenderer();
                    var parkId=data[0].nameId;
                    var ownerId=data[0].ownerId;
                    var address=data[0].address;
                    var district=data[0].district;
                    var province =data[0].province;


                    if(data.length!=0){
                        var i;
                        for(i=0;i<data.length;i++){
                            marker = new google.maps.Marker({
                                position: new google.maps.LatLng(data[i].latitude, data[i].longitude),
                                map: map,
                                title: "Hello World!",
                            });

                            var temp=google.maps.geometry.spherical.computeDistanceBetween (new google.maps.LatLng(pos.lat, pos.lng), new google.maps.LatLng(data[i].latitude, data[i].longitude));

                            if(temp <= distance){
                                distance=temp;
                                nearDistanceLatitude=data[i].latitude;
                                nearDistanceLongitude=data[i].longitude;
                                parkId=data[i].nameId;
                                ownerId=data[i].ownerId;
                                address=data[0].address;
                                district=data[0].district;
                                province =data[0].province;
                            }

                            google.maps.event.addListener(marker, 'click', function() {

                                showNearLocation(this.getPosition().lat(),this.getPosition().lng(),directionsDisplay);
                            });

                        }

                        sessionStorage.setItem("parkId",parkId);
                        sessionStorage.setItem("ownerId",ownerId);
                        sessionStorage.setItem("address",address);
                        sessionStorage.setItem("district",district);
                        sessionStorage.setItem("province",province);
                        sessionStorage.setItem("nearDistanceLatitude",nearDistanceLatitude);
                        sessionStorage.setItem("nearDistanceLongitude",nearDistanceLongitude);


                    }

                });
            }

            else {
                alert("konumunuz alınamamıştır lütfen konumuzunu paylaşmak için izin veriniz!");
            }



        },error:function (data) {
            alert(data+" Error");
        }
    })

}


function showNearLocation(lat,long,directionsRenderer){

    if(directionsRenderer==null)
    {
        directionsRenderer= new google.maps.DirectionsRenderer();
    }

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };


            directionsService = new google.maps.DirectionsService();


            var userLocation = new google.maps.LatLng(pos.lat, pos.lng);

            if(lat==null && long==null){
              var nearDistanceLatitude=  sessionStorage.getItem("nearDistanceLatitude");
              var nearDistanceLongitude= sessionStorage.getItem("nearDistanceLongitude");
                var nearPark = new google.maps.LatLng(nearDistanceLatitude, nearDistanceLongitude);
            }
            else
            {
                var nearPark = new google.maps.LatLng(lat, long);
                sessionStorage.setItem("nearDistanceLatitude",lat);
                sessionStorage.setItem("nearDistanceLongitude",long);
            }

            directionsRenderer.setMap(map);

            var request = {
                origin: userLocation,
                destination: nearPark,
                // Note that JavaScript allows us to access the constant
                // using square brackets and a string value as its
                // "property."
                travelMode: google.maps.TravelMode['DRIVING']
            };
            directionsService.route(request, function(response, status) {
                if (status == 'OK') {
                    directionsRenderer.setDirections(response);
                }
            });

        })
    }

    document.getElementById("showNearLocationButton").style.display="none";
    document.getElementById("rezerveParkArea").style.display="";

}

function rezerveLocation(){
    alert("hello");
    var status="BUSY";

    changePark(status);
    addParkingSpacesUsages();

    document.getElementById("rezerveParkArea").style.display="none";
    document.getElementById("iptalEt").style.display="";
}


function changePark(status){
    var changeParkStatus={
        nameId: sessionStorage.getItem("parkId"),
        ownerId:sessionStorage.getItem("ownerId"),
        parkStatus: status
    }

    data=JSON.stringify(changeParkStatus);
    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/parkingSpacesApi/changeParkStatus",
        data: data,
        success:function (data) {
           // alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })
}

function addParkingSpacesUsages(){

    var parkingSpacesUsages={
        name: sessionStorage.getItem("parkId"),
        owner:sessionStorage.getItem("ownerId"),
        driver: sessionStorage.getItem("userId"),
        district: sessionStorage.getItem("district"),
        province: sessionStorage.getItem("province"),
        address: sessionStorage.getItem("address"),
    }

    data=JSON.stringify(parkingSpacesUsages);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/parkingSpacesUsagesApi/addUsages",
        data: data,
        success:function (data) {
            alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })


}





var lastname = sessionStorage.getItem("userId");




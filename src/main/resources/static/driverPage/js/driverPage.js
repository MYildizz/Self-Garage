var longitude;
var latitude;
var marker;
var map;
var nearDistanceLongitude;
var nearDistanceLatitude;
var directionsService;


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
                    var distance= google.maps.geometry.spherical.computeDistanceBetween (new google.maps.LatLng(pos.lat, pos.lng), new google.maps.LatLng(data[0].latitude, data[0].longitude)).toFixed(0);
                    var directionsDisplay = new google.maps.DirectionsRenderer();
                    if(data.length!=0){
                        var i;
                        for(i=0;i<data.length;i++){
                            marker = new google.maps.Marker({
                                position: new google.maps.LatLng(data[i].latitude, data[i].longitude),
                                map: map,
                                title: "Hello World!",
                            });

                            var temp=google.maps.geometry.spherical.computeDistanceBetween (new google.maps.LatLng(pos.lat, pos.lng), new google.maps.LatLng(data[i].latitude, data[i].longitude)).toFixed(0);

                            if(temp>=distance){
                                distance=temp;
                                nearDistanceLatitude=data[i].latitude;
                                nearDistanceLongitude=data[i].longitude;
                            }

                            google.maps.event.addListener(marker, 'click', function() {
                                alert(marker.getPosition().lat()+" "+marker.getPosition().lng());

                                showNearLocation(this.getPosition().lat(),this.getPosition().lng(),directionsDisplay);
                            });

                        }


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
        directionsRenderer= new google.maps.DirectionsRenderer();

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
}







var lastname = sessionStorage.getItem("userId");


window.onload = getParkSpaces();



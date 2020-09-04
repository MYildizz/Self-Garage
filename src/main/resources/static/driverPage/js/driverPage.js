var longitude;
var latitude;
let markers= [];
let map;
var nearDistanceLongitude;
var nearDistanceLatitude;
var directionsService;
var marker=[];
let parkData=[];
var diff;
var distanceInterval;

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
                     //   icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png'
                    });

                    /*
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
                    */
                    var marker2 = new google.maps.Marker({
                        position: new google.maps.LatLng(pos.lat, pos.lng),
                        map: map,
                        title: "Buradasınız",
                        icon: '/driverPage/img/bluecircle.png',
                        scale: 200
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
                                icon: '/driverPage/img/test4.png',
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
                                document.getElementById("showNearLocationButton").style.display="none";
                                document.getElementById("rezerveParkArea").style.display="";
                            });

                            markers.push(marker);

                        }

                        sessionStorage.setItem("parkId",parkId);
                        sessionStorage.setItem("ownerId",ownerId);
                        sessionStorage.setItem("address",address);
                        sessionStorage.setItem("district",district);
                        sessionStorage.setItem("province",province);
                        sessionStorage.setItem("nearDistanceLatitude",nearDistanceLatitude);
                        sessionStorage.setItem("nearDistanceLongitude",nearDistanceLongitude);
                        sessionStorage.setItem("distance",distance);

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


function showNearLocation(lat,long,directionsRenderer,flag){

    if(directionsRenderer==null)
    {
        directionsRenderer= new google.maps.DirectionsRenderer();

    }
    if (flag==1){
        document.getElementById("showNearLocationButton").style.display="none";
        document.getElementById("rezerveParkArea").style.display="";
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



}

function rezerveLocation(){

    var status="BUSY";

    changePark(status);
    addParkingSpacesUsages();

    document.getElementById("rezerveParkArea").style.display="none";
    document.getElementById("iptalEt").style.display="";

    var currentdate = new Date();
    var datetime =currentdate.getFullYear()  + "/"
        + (currentdate.getMonth()+1)  + "/"
        + currentdate.getDate() + " "
        + currentdate.getHours() + ":"
        + currentdate.getMinutes() + ":"
        + currentdate.getSeconds();
//    currentdate=Date.parse(datetime);
    var  b=new Date(datetime);
    sessionStorage.setItem("data.entry",b);
    displayTime(null);
    setInterval("displayTime(null)", 100000);

    var lat=sessionStorage.getItem("nearDistanceLatitude");
    var lot=sessionStorage.getItem("nearDistanceLongitude");

   // window.location="https://www.google.com/maps/dir//"+lat+","+lot+"/@"+lat+","+lot+","+"20.74z/data=!4m2!4m1!3e0";
    window.open("https://www.google.com/maps/dir//"+lat+","+lot+"/@"+lat+","+lot+","+"20.74z/data=!4m2!4m1!3e0",'_blank');
    deleteMarker();
    distanceInterval=setInterval("checkDistance()", 200);
    document.getElementById("roadCounter").style.display="";
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
            //  alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })
}

function addParkingSpacesUsages(){

    var distance= sessionStorage.getItem("distance");
    var parkStatus;
    if(distance <=20)
    {
        parkStatus="USAGE";
    }
    else
    {
        parkStatus="REZERVE";
    }
    var parkingSpacesUsages={
        name: sessionStorage.getItem("parkId"),
        owner:sessionStorage.getItem("ownerId"),
        driver: sessionStorage.getItem("userId"),
        district: sessionStorage.getItem("district"),
        province: sessionStorage.getItem("province"),
        address: sessionStorage.getItem("address"),
        usageStatus: parkStatus
    }

    data=JSON.stringify(parkingSpacesUsages);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/parkingSpacesUsagesApi/addUsages",
        data: data,
        success:function (data) {
          //  alert(data + "aa");
        },error:function (data) {
            alert(data+"ufak  Error");
        }
    })


}

setTimeout(checkActiveParking, 400);
function checkActiveParking(){



    var name;
    var driver;
    var owner;
    var entry;
    var departure;
    var totalTime;
    var price;
    var district;
    var province;
    var address;
    var usageStatus;

    var id=sessionStorage.getItem("userId")

    var activePark ={
        name:null,
        driver:null,
        owner:null,
        entry:null,
        departure:null,
        totalTime:null,
        price:null,
        district:null,
        province:null,
        address:null,
        usageStatus:null
    }
    data=JSON.stringify(activePark);

    $.ajax({
        type:"GET",
        contentType: 'application/json; charset=UTF-8',
        url:"/information/parkingSpacesUsagesApi/getActiveParking/"+id,
        success:function (data) {

            if(data.usageStatus=="REZERVE")
            {
                document.getElementById("showNearLocationButton").style.display="none";
                document.getElementById("rezerveParkArea").style.display="none";
                document.getElementById("iptalEt").style.display="";
                sessionStorage.setItem("data.entry",data.entry)

                distanceInterval=setInterval("checkDistance()", 200);
                deleteMarker();

            }
            else if(data.usageStatus=="USAGE")
            {
                document.getElementById("showNearLocationButton").style.display="none";
                document.getElementById("rezerveParkArea").style.display="none";
                document.getElementById("iptalEt").style.display="";

                displayTime(null);
                setInterval("displayTime(null)", 100000);
                setInterval("checkDistance()", 200);
                deleteMarker();

            }
            else{
                document.getElementById("rezerveParkArea").style.display="none";
                document.getElementById("iptalEt").style.display="none";
                document.getElementById("showNearLocationButton").style.display="";
            }

            if(data.usageStatus!="FINISH"){
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

                parkData=JSON.stringify(parkArea);

                $.ajax({
                    type:"GET",
                    contentType: 'application/json; charset=UTF-8',
                    url:"/information/parkingSpacesApi/getAllByParkStatusBusy",
                    success:function (parkData) {
                        var i;

                        for(i=0;i<parkData.length;i++){
                            if(parkData[i].nameId==data.name){
                                showNearLocation(parkData[i].latitude,parkData[i].longitude,null,0);
                                break;
                            }
                        }

                    },error:function (data) {
                        alert(data+" Error");
                    }
                })

            }


        },error:function (data) {
            alert(data+" Error");
        }
    });




}

function cancel(){
    var parkStatus="FINISH";
    changePark("OPEN");
    updateParkingStatus(parkStatus);

    var minute=diff;
    var price =minute*0.5;
    var text="";

    if(minute < 60){
        if(minute <10){
            text="<p> İŞLEMİNİZ SONLANDIRILMIŞTIR <br>";
            text+= "GEÇEN SÜRE : "+ "00:0"+minute+" DAKİKA ";
            text+="- UCRET : "+price +" TL </p>";
        }
        else{
            text="<p> İŞLEMİNİZ SONLANDIRILMIŞTIR <br>";
            text+= "GEÇEN SÜRE : "+ "00:"+minute+" DAKİKA ";
            text+="- UCRET : "+price +" TL </p>";
        }
    }
    else{
        if(minute<10){
            var hours = minute/60;
            var minute= minute%60;
            text="<p> İŞLEMİNİZ SONLANDIRILMIŞTIR <br>";
            text+= "GEÇEN SÜRE : "+ "00:0"+minute+" DAKİKA ";
            text+="- UCRET : "+price+" TL </p>";
        }
        else{
            var hours = minute/60;
            var minute= minute%60;
            text="<p> İŞLEMİNİZ SONLANDIRILMIŞTIR <br>";
            text+= "GEÇEN SÜRE : "+ "00:"+minute+" DAKİKA ";
            text+="- UCRET : "+price+" TL </p>";
        }
    }

    document.getElementById("finishModalText").innerHTML = text;

    setTimeout(reloadPage, 5000);


}

function reloadPage(){
    location.reload();
}

function updateParkingStatus(parkStatus){

    var parkingSpacesUsages={
        name: sessionStorage.getItem("parkId"),
        owner:sessionStorage.getItem("ownerId"),
        driver: sessionStorage.getItem("userId"),
        district: sessionStorage.getItem("district"),
        province: sessionStorage.getItem("province"),
        address: sessionStorage.getItem("address"),
        usageStatus: parkStatus
    }

    data=JSON.stringify(parkingSpacesUsages);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/parkingSpacesUsagesApi/finishParking",
        data: data,
        success:function (data) {
            //  alert(data + "aa");
        },error:function (data) {
            alert(data+"ufak  Error");
        }
    })
}



function parkUsageState() {

}
function checkDistance() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

           var parkLat=  sessionStorage.getItem("nearDistanceLatitude");
            var parkLot= sessionStorage.getItem("nearDistanceLongitude");

            var distance= google.maps.geometry.spherical.computeDistanceBetween (new google.maps.LatLng(pos.lat, pos.lng), new google.maps.LatLng(parkLat, parkLot));

            if(distance <= 2000000000000){
                document.getElementById("map").style.display="none";
                document.getElementById("roadCounter").style.display="none";
                document.getElementById("iptalEt").style.display="none";
                document.getElementById("parkedButton").style.display="";
                document.getElementById("baslik").innerHTML = "";
                document.getElementById("mapAndNavBar").style.backgroundImage = "url('/driverPage/img/2.jpg')";
                document.getElementById("activePark").style.display="";
                clearInterval(distanceInterval);
                updateParkingStatus("USAGE");
            }

        })
    }
}


function displayTime(beginDate){
    if(beginDate==null){
        beginDate=sessionStorage.getItem("data.entry");
    }
    var minute=diff_dates(beginDate);
    var price =minute*0.5;
    var text="";
    var time="";
    if(minute < 60){
        if(minute <10){
            text="<p> LÜTFEN PARK ALANINA DOĞRU İLERLEYİNİZ <br>";
            text+= "GEÇEN SÜRE : "+ "00:0"+minute+" DAKİKA ";
            text+="- UCRET : "+price +" TL </p>";
            time+="00:0"+minute+" DAKİKA ";
        }
        else{
            text="<p> LÜTFEN PARK ALANINA DOĞRU İLERLEYİNİZ <br>";
            text+= "GEÇEN SÜRE : "+ "00:"+minute+" DAKİKA ";
            text+="- UCRET : "+price +" TL </p>";
            time+="00:"+minute+" DAKİKA ";
        }
    }
    else{
        if(minute<10){
            var hours = minute/60;
            var minute= minute%60;
            text="<p> LÜTFEN PARK ALANINA DOĞRU İLERLEYİNİZ <br>";
            text+= "GEÇEN SÜRE : "+hours+":0"+minute+" DAKİKA ";
            text+="- UCRET : "+price+" TL </p>";
            time+=hours+":0"+minute+" DAKİKA ";
        }
        else{
            var hours = minute/60;
            var minute= minute%60;
            text="<p> LÜTFEN PARK ALANINA DOĞRU İLERLEYİNİZ <br>";
            text+= "GEÇEN SÜRE : "+hours+":"+minute+" DAKİKA ";
            text+="- UCRET : "+price+" TL </p>";
            time+=hours+":"+minute+" DAKİKA ";
        }
    }

    document.getElementById("roadCounter").innerHTML = text;
    document.getElementById("activeTime").innerHTML = time;
    document.getElementById("activePrice").innerHTML = price+" TL";





}



function diff_dates(beginDate)
{

    var currentdate = new Date();
    var datetime =currentdate.getFullYear()  + "/"
        + (currentdate.getMonth()+1)  + "/"
        + currentdate.getDate() + " "
        + currentdate.getHours() + ":"
        + currentdate.getMinutes() + ":"
        + currentdate.getSeconds();
//    currentdate=Date.parse(datetime);

  var   a=new Date(beginDate);
  var  b=new Date(datetime);

    diff =(b.getTime() - a.getTime()) / 1000;
    diff /= 60;
    return Math.abs(Math.round(diff));
}

function deleteMarker(){
    for (let i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers=[];
}






//window.onload = checkActiveParking();

var lastname = sessionStorage.getItem("userId");




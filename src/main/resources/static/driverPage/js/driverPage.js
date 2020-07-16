function initMap() {
    var myLatLng = { lat: 39.9680616, lng: 32.9380175 };

    var map = new google.maps.Map(document.getElementById("map"), {
        zoom: 15,
        center: myLatLng
    });

    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: "Hello World!"
    });
}
var lastname = sessionStorage.getItem("userId");
console.log(lastname);



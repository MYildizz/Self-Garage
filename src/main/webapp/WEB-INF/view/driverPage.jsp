<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Markers</title>
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/css/agency.min.css" rel="stylesheet">
    <link href="/promotion/css/agency.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBZ1OVeG7pkOgFgNe7h_WiLRLlA4RazZ28&callback=initMap&libraries=&v=weekly"
            defer
    ></script>
    <link rel="stylesheet" type="text/css" href="/driverPage/css/driverPage.css" />

    <script src="/driverPage/js/driverPage.js"></script>

</head>
<body>

<div class="mapAndNavBar">
    <nav class="  fixed-top ortala" id="mainNav" style="position: relative;bottom: 50px">
        <div class="ortala container navbar-brand">
            <a>Self Garage</a>

        </div>
    </nav>

    <div id="map"></div>

</div>

<div class="buttons">

    <div class="btn parkArea" >
        <span class="noselect">En Yakın Park Yeri</span>
        <div class="circle"></div>
    </div>

    <div class="others" style="clear: both">
        <a href="/driverUsages">
            <div  class="btn " >
                <span class="noselect">Önceki Kullanımlarınız</span>
                <div class="circle"></div>
            </div>
        </a>

        <a href="/driverCreditCard">
        <div class="btn" >
            <span class="noselect">Ödeme Bilgileri</span>
            <div class="circle"></div>
        </div>
        </a>

         <a href="/driverSettings">
        <div class="btn">
            <span class="noselect">Ayarlar</span>
            <div class="circle"></div>
        </div>
         </a>
    </div>



</div>

<footer class="footer">
    <div class="container">
        <div class="row align-items-center" >
            <div class="col-md-4" >
                <span class="copyright">SelfGarage &copy; 2019</span>
            </div>

        </div>
    </div>
</footer>


</body>




</html>

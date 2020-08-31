<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Driver Page</title>
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/css/agency.min.css" rel="stylesheet">
    <link href="/promotion/css/agency.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBZ1OVeG7pkOgFgNe7h_WiLRLlA4RazZ28&callback=initMap&libraries=&v=weekly&sensor=false&libraries=geometry"
            defer
    ></script>

    <link rel="stylesheet" type="text/css" href="/driverPage/css/driverPage.css" />

    <script src="/driverPage/js/driverPage.js"></script>
    <script src="/promotion/vendor/jquery/jquery.js"></script>
    <script src="/promotion/vendor/jquery-ui-1.12.1/jquery-ui.js"></script>

</head>
<body>

<div class="mapAndNavBar">
    <nav class="  fixed-top ortala" id="mainNav" style="position: relative;bottom: 50px">
        <div class="ortala container navbar-brand">
            <a>Self Garage</a>

        </div>
    </nav>

    <div id="map">
    </div>

</div>

<div class="content" id="roadCounter" style="display: none">

</div>

<div class="buttons">

    <div class="btn parkArea" id="showNearLocationButton" onclick="showNearLocation(null,null,null,1)" style="display: none">
        <span class="noselect" >En Yakın Park Yeri</span>
        <div class="circle"></div>
    </div>

    <div class="btn" id="rezerveParkArea"  data-toggle="modal" data-target="#exampleModal" style="display: none">
        <span class="noselect" >Park Yerini Rezerve Et</span>
        <div class="circle"></div>
    </div>

    <div class="btn" id="iptalEt"  data-toggle="modal" data-target="#exampleModal" style="display: none">
        <span class="noselect" >İptal Et</span>
        <div class="circle"></div>
    </div>

    <div class="others" style="clear: both">

        <a href="/driverSettings">
            <div class="btn">
                <span class="noselect">Ayarlar</span>
                <div class="circle"></div>
            </div>
        </a>
    </div>



</div>

<!-- Toogle -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">PARK REZERVASYON İŞLEMİ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                - REZERVASYON SÜRESİNCE DAKİKASI 0.50 TL 'DEN ÜCRET TAHSİL EDİLECEKTİR. <br>
                - 10 DAKİKA İÇİNDE PARK ALANINA VARMAMANIZ DURUMUNDA İŞLEM SONLANDIRILACAKTIR. <br>
                - PARK YERINE VARDIĞINIZDA DUBANIN AÇILABILMESİ İÇİN UYGULAMANIN AÇIK OLMASI GEREKİR.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">İptal Et</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="rezerveLocation()">Onayla</button>
            </div>
        </div>
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

<script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>




</html>
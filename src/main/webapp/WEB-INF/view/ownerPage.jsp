<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Markers</title>
    <title>Simple Markers</title>
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/ownerPage/css/ownerPage.css" />

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="/promotion/vendor/jquery/jquery.min.js"></script>
</head>
<body>

<div class="mapAndNavBar">

    <nav class="  fixed-top ortala" id="mainNav" style="position: relative;bottom: 50px">

        <button class="solToggler navbar-toggler navbar-toggler-left" type="button" onclick="openNav()" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>

        <div class="ortala container navbar-brand">
            <a>Self Garage</a>

        </div>
    </nav>

    <div id="map"></div>

</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#" onclick="parkingUsages()">Park Alanlarınız</a>
    <a href="#" >Profil Bilgileriniz</a>
    <a href="#" >Hata Bildir !</a>
    <a href="/" >ÇIKIŞ </a>
</div>


<div id="main">
    <div> <h5 class="baslik"> Park Alanlarınız </h5></div>
    <div id="parkPage" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

        <div class="verticalLine" id="verticalLine">
            <a id="Timer"><button id="setTime" type="button" class="btn btn-secondary btn-lg" data-toggle="modal" data-target="#exampleModalCenter">Tarih Ayarla</button></a>
            <a><h id="pLogo">P</h></a>
            <a id="parkButtonClose"><button id="closeButton" type="button" class="btn btn-secondary btn-lg">Kullanıma Kapat</button></a>
            <a id="parkButtonOpen"><button id="openButton" type="button" class="btn btn-secondary btn-lg">Kullanıma Aç</button></a>

        </div>

        <div>
            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>



    </div>

    <div> <h5 class="baslik"> Kullanım Verileri </h5></div>

    <div id="parkUsages" class="shadow-lg p-3 mb-5 bg-white rounded backFont">


        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Park Id</th>
                <th scope="col">İl</th>
                <th scope="col">İlçe</th>
                <th scope="col">Adres</th>
                <th scope="col">Griş Saati</th>
                <th scope="col">Çıkış Saati</th>
                <th scope="col">Toplam Süre</th>
                <th scope="col">Tutar</th>
            </tr>
            </thead>
            <tbody>

            <tr id="getParkingInfo">

            </tr>


            </tbody>
        </table>



    </div>

</div>



<script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/ownerPage/js/ownerPage.js"></script>
</body>

</html>
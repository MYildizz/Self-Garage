<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Markers</title>
    <title>Simple Markers</title>
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/css/agency.min.css" rel="stylesheet">
    <link href="/promotion/css/agency.css" rel="stylesheet">
    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/driverPage/css/driverSettings.css" />
    <script src="/promotion/vendor/jquery/jquery.js"></script>
    <script src="/promotion/vendor/jquery-ui-1.12.1/jquery-ui.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="/promotion/vendor/jquery/jquery.min.js"></script>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link rel="icon" href="/promotion/img/service/self-garage.jpeg">
    <meta name="mobile-web-app-capable" content="yes">
</head>
<body>

<div class="mapAndNavBar">

    <nav class="  fixed-top ortala" id="mainNav" style="position: relative; ">

     <div style="float: left">
        <button class="solToggler navbar-toggler navbar-toggler-left" type="button" onclick="openNav()" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
             <i class="fas fa-bars"></i>
         </button>
    </div>

        <div style="float: none" class="ortala container navbar-brand">
            <a>Self Garage</a>

        </div>
    </nav>

    <div id="map"></div>

</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#" onclick="profile()">Profil Bilgileriniz</a>
    <a href="#" onclick="parkingUsages()">Önceki Kullanımlarınız</a>
    <a href="#" onclick="cardInformation()">Ödeme Bilgileriniz</a>
    <a href="#" onclick="reportError()">Hata Bildir !</a>
    <a href="/" onclick="exit()">ÇIKIŞ </a>
</div>


<div id="main">

    <div id="profile" class="shadow-lg p-3 mb-5 bg-white rounded backFont">
        <div class="container" id="container2">
            <div> <h5 class="baslik"> Kişisel Bilgileriniz </h5></div>
            <div class="jumbotron">
                <div class="row">
                    <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4" id="imageCard">
                        <img src="/driverPage/img/profile.png" alt="stack photo" class="img">
                    </div>
                    <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8" id="nameId">
                        <div class="container" style="border-bottom:1px solid black">
                            <h2 id="nameSurname">-</h2>
                        </div>
                        <hr>
                        <ul class="container details">
                            <li><p id="idName"><span class="glyphicon glyphicon-earphone one" style="width:50px;"></span></p></li>
                            <li><p id="mail"><span class="glyphicon glyphicon-envelope one" style="width:50px;"></span></p></li>
                            <li><p id="phoneNumber"><span class="glyphicon glyphicon-map-marker one" style="width:50px;"></span></p></li>
                            <li><p id="carPlate"><span class="glyphicon glyphicon-new-window one" style="width:50px;"></span> </p></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="driverUsages" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

        <div> <h5 class="baslik"> Önceki Kullanımlarınız </h5></div>

    <div style="overflow-y:scroll; height:auto; max-height: 400px; overflow: auto;">
        <table class="table" >
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Id</th>
                <th scope="col">İl/ilçe</th>
                <th scope="col">Giriş Saati</th>
                <th scope="col">Çıkış Saati</th>
                <th scope="col">Süre</th>
                <th scope="col">Tutar</th>
            </tr>
            </thead>
            <tbody  id="getParkingInfo" >

            <tr>

            </tr>


            </tbody>
        </table>
    </div>
    </div>

    <div id="cardInformation" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

        <div> <h5 class="baslik"> Kart Bilgileriniz </h5></div>
        <div style="overflow-y:scroll; height:auto; max-height: 400px; overflow: auto;">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">İsim</th>
                <th scope="col">Soyisim</th>
                <th scope="col">Kart Numarası</th>
                <th scope="col">Son Kullanma Tarihi</th>
                <th scope="col">CVC</th>
            </tr>
            </thead>
            <tbody>

            <tr id="getCardInfo">


            </tr>
            </tbody>
        </table>
        </div>
    </div>

    <div id="reportError" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

        <div> <h5 class="baslik"> Bize Hata Bildirin </h5></div>

        <div class="form-group">
            <label style="position: center" for="FormControlTextarea">Uygulamamız demo aşamasında olduğu için bir çok hata bulundurabilir. Gördüğünüz problemleri belirtip bize geri dönüş yaparsanız size daha iyi hizmet verebiliriz.</label>
            <textarea class="form-control" id="FormControlTextarea" rows="10"></textarea>
            <button type="button" class="btn btn-secondary btn-lg btn-block" onclick="reportErrorMessage()">Gönder</button>
        </div>

    </div>



</div>


<div>
    <footer class="footer">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-4">
                    <span class="copyright">SelfGarage &copy; 2020</span>
                </div>
                <div class="col-md-4">
                    <img src="/promotion/img/service/self-garage.jpeg" alt="logo" width="100" height="50">
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li class="list-inline-item">
                            <a href="#">SelfGarage Tüm Hakları Saklıdır</a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>


<script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/driverPage/js/driverSettings.js"></script>

</body>

</html>
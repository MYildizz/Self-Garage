<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Park Alanları</title>
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/vendor/jquery-ui-1.12.1/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="/promotion/vendor/jquery-ui-1.12.1/jquery-ui.structure.css" rel="stylesheet" type="text/css">
    <link href="/promotion/vendor/jquery-ui-1.12.1/jquery-ui.theme.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/ownerPage/css/ownerPage.css" />
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="/promotion/vendor/jquery/jquery.js"></script>
    <script src="/promotion/vendor/jquery-ui-1.12.1/jquery-ui.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://rawgit.com/tempusdominus/bootstrap-4/master/build/js/tempusdominus-bootstrap-4.js"></script>
    <link href="https://rawgit.com/tempusdominus/bootstrap-4/master/build/css/tempusdominus-bootstrap-4.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>


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
            <a id="Timer"><button id="setTime" type="button" class="btn " data-toggle="modal" data-target="#exampleModalCenter">Tarih Ayarla</button></a>
            <a><h id="pLogo">P</h></a>
            <a id="parkButtonClose"><button id="closeButton" type="button" class="btn btn-outline-warning">Kullanıma Kapat</button></a>
            <a id="parkButtonOpen"><button id="openButton" type="button" class="btn btn-outline-warning">&nbsp Kullanıma Aç &nbsp  </button></a>

        </div>

        <div>
            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Lütfen Belirlediğiniz Tarih Aralıklarınızı Giriniz</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body" >
                            <div class="container">
                                <div class='col-md-5' style="width: 90%">
                                    <div class="form-group">
                                        <div class="input-group date" id="datetimepicker7" data-target-input="nearest">
                                            <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker7"/>
                                            <div class="input-group-append" data-target="#datetimepicker7" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class='col-md-5' style="width: 90%">
                                    <div class="form-group">
                                        <div class="input-group date" id="datetimepicker8" data-target-input="nearest">
                                            <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker8"/>
                                            <div class="input-group-append" data-target="#datetimepicker8" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">İptal</button>
                            <button type="button" class="btn btn-primary">Kaydet</button>
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
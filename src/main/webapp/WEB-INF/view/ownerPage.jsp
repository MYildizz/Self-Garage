<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Park Alanları</title>
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="/promotion/css/agency.min.css" rel="stylesheet">
    <link href="/promotion/css/agency.css" rel="stylesheet">
    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
    <script src="/promotion/vendor/jquery/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://rawgit.com/tempusdominus/bootstrap-4/master/build/js/tempusdominus-bootstrap-4.js"></script>
    <link href="https://rawgit.com/tempusdominus/bootstrap-4/master/build/css/tempusdominus-bootstrap-4.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link rel="icon" href="/promotion/img/service/self-garage.jpeg">
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


</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#" onclick="parkInfo()">Park Alanlarınız</a>
    <a href="#" onclick="profile()">Profil Bilgileriniz</a>
    <a href="#" onclick="reportError()">Hata Bildir !</a>
    <a href="/" >ÇIKIŞ </a>
</div>


<div id="main">

    <div id="parkInfo">
        <div> <h5 class="baslik"> Park Alanlarınız </h5></div>
        <div id="parkPage" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

            <div id="parkSpaces"> </div>

            <div>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalCenterTitle">Lütfen Park Alanınızın Açık Kalmasını İstediğiniz Tarih Aralıklarınızı Giriniz</h5>
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
                                <button type="button" class="btn btn-primary" id="saveTime">Kaydet</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

        <div> <h5 class="baslik"> Kullanım Verileri </h5></div>

        <div id="parkUsages" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

            <div style="overflow-y:scroll; height:auto; max-height: 400px; overflow: auto;">
            <table class="table">
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
                <tbody id="getParkingInfo">




                </tbody>
            </table>
            </div>


        </div>

    </div>

    <div id="profile" class="shadow-lg p-3 mb-5 bg-white rounded backFont">
        <div class="container" style="margin-top: 40px">
            <div> <h5 class="baslik"> Kişisel Bilgileriniz </h5></div>
            <div class="jumbotron">
                <div class="row">
                    <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                        <img src="https://www.svgimages.com/svg-image/s5/man-passportsize-silhouette-icon-256x256.png" alt="stack photo" class="img">
                    </div>
                    <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
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

    <div id="reportError" class="shadow-lg p-3 mb-5 bg-white rounded backFont">

        <div> <h5 class="baslik"> Bize Hata Bildirin </h5></div>

        <div class="form-group">
            <label style="position: center" for="FormControlTextarea">Uygulamamız demo aşamasında olduğu için bir çok hata bulundurabilir. Gördüğünüz problemleri belirtiniz seviniriz.</label>
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

<script>

function getParks(size){
   // var size=sessionStorage.getItem("size");
    var i;
    var parkArea="";
    for(i=0;i<size;i++){
        var number=i;
        parkArea+= '<div class="verticalLine" id="verticalLine'+i+ '">'
        parkArea+=' <a class="Timer" id="Timer'+i+ '"><button id="setTime'+i+ '" type="button" class="btn setTime" data-toggle="modal" data-target="#exampleModalCenter" onclick="changeCurrentPark(this.id)">Tarih Ayarla</button></a>'
        parkArea+=' <a><h class="pLogo" id="pLogo'+i+ '">P</h></a>'
        parkArea+=' <a class="parkButtonClose" id="parkButtonClose'+i+ '"><button id="ButtonClose'+i+ '" type="button" class="btn btn-outline-warning closeButton " onclick="closeButtons(this.id)" >Kullanıma Kapat</button></a>'
        parkArea+=' <a class="parkButtonOpen" id="parkButtonOpen'+i+ '"><button id="ButtonOpen'+i+ '" type="button" class="btn btn-outline-warning openButton" onclick="openButtons(this.id)">&nbsp Kullanıma Aç &nbsp  </button></a>'
        parkArea+=' </div>'
        parkArea+="";

    }
    document.getElementById("parkSpaces").innerHTML = parkArea;
}

</script>
<script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/ownerPage/js/ownerPage.js"></script>
</body>

</html>
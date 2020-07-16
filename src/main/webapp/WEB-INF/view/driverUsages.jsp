<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>

    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css" href="/driverPage/css/driverUsages.css" />
</head>
<body>

<div class="shadow-lg p-3 mb-5 bg-white rounded backFont">

    <div> <h5 class="baslik"> Önceki Kullanımlarınız </h5></div>

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
        <tr id="getInfo">

        </tr>


        </tbody>
    </table>





</div>

<!-- Bootstrap core JavaScript -->
<script src="/promotion/vendor/jquery/jquery.min.js"></script>
<script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/driverPage/js/driverUsages.js"></script>
<!-- Plugin JavaScript -->


</body>




</html>
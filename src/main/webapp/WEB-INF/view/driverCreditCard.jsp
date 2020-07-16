<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>

    <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css" href="/driverPage/css/driverCreditCard.css" />
</head>
<body>

<div class="shadow-lg p-3 mb-5 bg-white rounded backFont">

    <div> <h5 class="baslik"> Kart Bilgileriniz </h5></div>

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

        <tr id="getInfo">


        </tr>



        </tbody>
    </table>





</div>

<!-- Bootstrap core JavaScript -->
<script src="/promotion/vendor/jquery/jquery.min.js"></script>
<script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/driverPage/js/driverCreditCard.js"></script>
<!-- Plugin JavaScript -->


</body>




</html>
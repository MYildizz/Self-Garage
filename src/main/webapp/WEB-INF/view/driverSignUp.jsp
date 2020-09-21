<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Self Garage Sürücü Kayıt</title>

    <link href="/register/driverRegister/css/driverSignUp.css" rel="stylesheet">
    <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link rel="icon" href="/promotion/img/service/self-garage.jpeg">
    <meta name="mobile-web-app-capable" content="yes">
</head>
<body>

<nav class="  fixed-top ortala" id="mainNav" style="position: relative;bottom: 50px">
    <div class="ortala container navbar-brand">
        <a>Self Garage</a>

    </div>
</nav>

<div class="container h-100" >
    <div class="d-flex justify-content-center h-100">
        <div class="user_card">
            <div class="d-flex justify-content-center">
                <div class="brand_logo_container">
                    <img src="/login/driverLogin/img/driverLogo.jpg" class="brand_logo" alt="Logo">
                </div>
            </div>
            <div class="d-flex justify-content-center form_container">
                <form>
                    <div class="input-group mb-3">

                        <input type="text" name="" class="form-control input_user" id="getName" value="" placeholder="İsim">
                    </div>

                    <div class="input-group mb-3">

                        <input type="text" name="" class="form-control input_user" id="getSurname" value="" placeholder="Soyisim">
                    </div>

                    <div class="input-group mb-3">

                        <input type="text" name="" class="form-control input_user" id="getIdName" value="" placeholder="Kullanıcı id">
                    </div>

                    <div class="input-group mb-3">

                        <input type="text" name="" class="form-control input_user" id="getMail" value="" placeholder="Mail Adresi">
                    </div>

                    <div class="input-group mb-3">

                        <input type="text" name="" class="form-control input_user" id="getPhone" value="" placeholder="Telefon">
                    </div>

                    <div class="input-group mb-3">

                        <input type="text" name="" class="form-control input_user" id="getPlaka" value="" placeholder="Plaka">
                    </div>

                    <div class="input-group mb-3">

                        <input type="password" name="" class="form-control input_pass" id="getPassword" value="" placeholder="Şifre">
                    </div>

                    <div class="input-group mb-3">

                        <input type="password" name="" class="form-control input_pass" id="getPasswordAgain" value="" placeholder="Şifre Tekrar">
                    </div>

                    <div class="d-flex justify-content-center mt-3 login_container">
                        <button type="button" name="button" class="btn login_btn" id="signUp">Kayıt</button>
                    </div>
                </form>
            </div>

            <div class="mt-4">
                <div class="d-flex justify-content-center links">
                    Zaten bir hesabınız var mı? <a href="/driverLogin" class="ml-2">Giriş</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/register/driverRegister/js/driverSingup.js"></script>

</html>
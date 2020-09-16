var userName;
var userSurname;
var userIdName;
var userEmail;
var userPhoneNumber;
var userPassword;
var userPasswordVerify;
var userPassword;
var userDistrict;
var userProvince;
var userAddress;

function saveUser(name,surname,idName,e_mail,phoneNumber,carPlate,password,district,province,address){
    var userCard={
        name: name,
        surname:surname,
        idName:idName,
        mail:e_mail,
        phoneNumber:phoneNumber,
        carPlate:carPlate,
        password:password,
        district:district,
        province:province,
        address:address
    }

    var data=JSON.stringify(userCard);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/rentalRequestsApi/saveRegister",
        data: data,
        success:function (data) {
            alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })
}


$("#signUp").click(function () {
    userName=$("#getName").val();
    userSurname=$("#getSurname").val();
    userIdName=$("#getIdName").val();
    userEmail=$("#getMail").val();
    userPhoneNumber=$("#getPhone").val();
    userCarPlate=$("#getPlaka").val();
    userPassword=$("#getPassword").val();
    userPasswordVerify=$("#getPasswordAgain").val();
    userDistrict=$("#getIlce").val();
    userProvince=$("#getPassword").val();
    userAddress=$("#getIl").val();

    if(userPassword < 8){
        alert("Lütfen En Az 8 Karakterli Bir Parola Belirleyiniz");
        flag=0;
    }

    if(userPassword != userPasswordVerify) {
        alert("Girdğiniz Şifreler Uyuşmamaktadır Lütfen Tekrar Deneyin !");
        flag=0;
    }
    if(userName.length < 3 || userSurname.length < 3){
        alert("Kullanıcı ismi ve soysimi 3 harften küçük olamaz !");
        flag=0;
    }
    if(userIdName.length < 5 ){
        alert("Id Name 5 harften küçük olamaz !");
        flag=0;
    }

    if(userPhoneNumber.length <10  ){
        alert(" lütfen geçerli bir telefon numarası giriniz !");
        flag=0;
    }
    if(userEmail.length < 12 || userEmail.indexOf("@")==-1 || userEmail.indexOf("com")==-1  ){
        alert(" lütfen geçerli bir mail adresi giriniz !");
        flag=0;
    }

    else
    {
        saveUser(userName, userSurname, userIdName, userEmail, userPhoneNumber, userCarPlate, userPassword,userDistrict,userProvince,userAddress);
        alert("Kayıt Aktivasyonunuz Tamamlanmıştır En Kısa Süre İçerisinde Sizinle İletişime Geçilecektir.");
        window.location.href = "/";
    }


});
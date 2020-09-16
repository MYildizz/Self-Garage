var userName;
var userSurname;
var userIdName;
var userEmail;
var userPhoneNumber;
var userCarPlate;
var userPassword;
var userPasswordVerify;
var userPassword;

function saveUser(name,surname,idName,e_mail,phoneNumber,carPlate,password){
    var userCard={
        name: name,
        surname:surname,
        idName:idName,
        mail:e_mail,
        phoneNumber:phoneNumber,
        carPlate:carPlate,
        password:password
    }

    var data=JSON.stringify(userCard);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/driverInformationApi/saveDriver",
        data: data,
        success:function (data) {
            alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })
}


$("#signUp").click(function () {

    var flag=1;

    userName=$("#getName").val();
    userSurname=$("#getSurname").val();
    userIdName=$("#getIdName").val();
    userEmail=$("#getMail").val();
    userPhoneNumber=$("#getPhone").val();
    userCarPlate=$("#getPlaka").val();
    userPassword=$("#getPassword").val();
    userPasswordVerify=$("#getPasswordAgain").val();

    if(userPassword<8){
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



    if(flag==1)
    {
      saveUser(userName, userSurname, userIdName, userEmail, userPhoneNumber, userCarPlate, userPassword);
       alert("Kayıt Aktivasyonunuz Tamamlanmıştır Sisteme Giriş Yapabilirsiniz.")
        window.location.href = "/driverLogin";
    }


});
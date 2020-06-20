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
    userName=$("#getName").val();
    userSurname=$("#getSurname").val();
    userIdName=$("#getIdName").val();
    userEmail=$("#getMail").val();
    userPhoneNumber=$("#getPhone").val();
    userCarPlate=$("#getPlaka").val();
    userPassword=$("#getPassword").val();
    userPasswordVerify=$("#getPasswordAgain").val();

    if(userPassword != userPasswordVerify)
        alert("Girdğiniz Şifreler Uyuşmamaktadır Lütfen Tekrar Deneyin !");
    else
    {
      saveUser(userName, userSurname, userIdName, userEmail, userPhoneNumber, userCarPlate, userPassword);
    }


});
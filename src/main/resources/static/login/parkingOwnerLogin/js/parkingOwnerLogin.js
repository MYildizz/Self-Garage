var userId;
var userPassword;
var returnedData;
function checkUser(name,password){
    var userCard={
        idName:name,
        password:password
    }

    var data=JSON.stringify(userCard);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/parkingOwnerInformationApi/checkParkingOwner",
        data: data,
        success:function (data) {
            returnedData=data;
            if(returnedData==false) {
                alert("Yanlış kullanıcı adı veya şifre girdiniz, lütfen tekrar deneyiniz.");
            }
            else{
                window.location.href = "/ownerPage";
            }

        },error:function (data) {
            alert(data+" Error");
        }
    })
}

$("#LoginButton").click(function (event) {
    userId=$("#getId").val();
    userPassword=$("#getPassword").val();
    checkUser(userId,userPassword);

    var obj = {};
    obj.ownerId=userId;
    var jsonString = JSON.stringify(obj)
    document.cookie = jsonString

 //   sessionStorage.setItem("owner",owner);
});



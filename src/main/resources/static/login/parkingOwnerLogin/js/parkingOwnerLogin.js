var userId;
var userPassword;
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
            alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })
}

$("#LoginButton").click(function () {
    userId=$("#getId").val();
    userPassword=$("#getPassword").val();
    checkUser(userId,userPassword);

});
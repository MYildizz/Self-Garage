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
            alert(data);
        },error:function (data) {
            alert(data+" Error");
        }
    })
}

$("#LoginButton").click(function (event) {
    userId=$("#getId").val();
    userPassword=$("#getPassword").val();
    checkUser(userId,userPassword);

    if(returnedData!=true){
        event.preventDefault();
    }
    var owner=userId;
    sessionStorage.setItem("owner",owner);
});


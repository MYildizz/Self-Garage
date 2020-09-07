var userId;
var userPassword;
var returnedData;
function checkUser(name,password){
    var userCard={
        idName:name,
        password:password
    }

    data=JSON.stringify(userCard);

    $.ajax({
        type:"POST",
        contentType: 'application/json; charset=UTF-8',
        url:"information/driverInformationApi/checkDriver",
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

    deleteCookies();
    var obj = {}
    obj.userId=userId
    var jsonString = JSON.stringify(obj)
    document.cookie = jsonString

    sessionStorage.setItem("userId",userId);
});

function deleteCookies() {
    var allCookies = document.cookie.split(';');

    // The "expire" attribute of every cookie is
    // Set to "Thu, 01 Jan 1970 00:00:00 GMT"
    for (var i = 0; i < allCookies.length; i++)
        document.cookie = allCookies[i] + "=;expires="
            + new Date(0).toUTCString();

}








function register(){
    let email = $("#registerEmail").val();
    let username = $("#registerUsername").val();
    let password = $("#registerPassword").val();
    password = md5(password);
    var data={
        "email":email,
        "username" : username,
        "password" : password,
    }
    $.ajax({
        type:"post",
        url:"http://localhost:8080/register/",
        data : data,
        cache: false,
        async: false,
        dataType: "json",
        success: function (data){
            // 登录成功
            if(data["status"]=="200"){

                window.alert(data["msg"]);
                window.location.replace("http://localhost:8080/");
            }else if(data["status"]==201){
                window.alert(data["msg"]);
            }else{
                window.alert(data["msg"]);
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            alert("服务器异常,请联系管理员QQ919179287");
        }
    })
};
function login(){
    let username = $("#loginUsername").val();
    let password = $("#loginPassword").val();
    password = md5(password)
    var data = {
        "username": username,
        "password":password
    };
    $.ajax({
        type:"post",
        url:"http://localhost:8080/login/",
        data:data,
        cache: false,
        async : false,
        dataType: 'json',
        success: function (data)
        {
            console.log(data);
            // 登录成功
            if(data["status"]=="200"){
                console.log("登录成功");
                window.alert(data["msg"]);
                window.location.replace("http://localhost:8080/");
            }else if(data["status"]==201){
                window.alert(data["msg"]);
            }else{
                window.alert(data["msg"]);
            }
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert("服务器异常,请联系管理员QQ919179287");
        }
    })
}
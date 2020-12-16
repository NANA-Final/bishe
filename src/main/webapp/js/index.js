var userId=0;
function getUserCurrent() {
    $.post("api/user/user/getUserCurrent",
        function(result){
            if (result.status != 200) {
                userId = 0;
                $("#login_show").removeClass("hide");
                $("#login_hide").addClass("hide");
            }else{
                userId = result.data.userId;
                $("#login_show").removeClass("hide");
                $("#login_hide").addClass("hide");
                $(".username_text").html(result.data.username);
            }
        });
}
function login() {
    var phone = $("#login_number").val();
    var password = $("#login_password").val();
    $.post("api/all/user/login",{phone:phone,password:password},
        function(result){
            if (result.status ==200) alert("登录成功");
            else alert("用户名或密码错误")
        });
    getUserName();
}
function changeSendVerification() {
    $("#send_verification").html("发送验证码");
}
function sendVerification() {
    var phone = $("#register_number").val();
    $.post("api/all/user/sendVerification",{phone:phone},
        function(result){
            if (result.status == 200){
                $("#send_verification").html("已发送");
                setTimeout("changeSendVerification()",300);
            }
        });
}
function register() {
    var phone = $("#register_number").val();
    var verification = $("#register_verification").val();
    var password = $("#register_password").val();
    $.post("api/all/user/addUser",{phone:phone,verification:verification,password:password},
        function(result){
            if (result.status ==200) alert("注册成功");
        });
}

function init() {
    getUserCurrent();


}
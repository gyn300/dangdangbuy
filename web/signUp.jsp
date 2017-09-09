
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link href="signUpcss.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="jquery-3.2.1.js"></script>
    <script type="text/javascript">
        /*当鼠标放在用户名文本框时，提示文本及样式*/
        $(function () {

            $("#user_name").focus(function () {
                var $userNameId=$("#userNameId");
                $userNameId[0].className="import_prompt";
                $userNameId.html("1、由字母、数字组成4-16位字符<br/>2、只能以字母开头");
            });
            /*当鼠标离开通行证用户名文本框时，提示文本及样式*/
            $("#user_name").blur(flagUserName=function (){
                var $userName=$("#user_name");
                var $userNameId=$("#userNameId");
                var reg=/^[a-zA-Z][(0-9a-zA-Z]{2,14}[0-9a-zA-Z]$/;
                if($userName[0].value==""){
                    $userNameId[0].className="error_prompt";
                    $userNameId.html("通行证用户名不能为空，请输入通行证用户名");
                    return false;
                }
                if(reg.test($userName[0].value)==false){
                    $userNameId[0].className="error_prompt";
                    $userNameId.html("1、由字母、数字组成4-16位字符<br/>2、只能以字母开头");
                    return false;
                }
                $userNameId[0].className="ok_prompt";
                $userNameId.html("通行证用户名输入正确");
                return true;
            });

            /*当鼠标放在密码文本框时，提示文本及样式*/
            $("#password").focus(function (){
                var $pwdId=$("#passwordId");
                $pwdId[0].className="import_prompt";
                $pwdId[0].innerHTML="密码由英文字母和数字组成的4-10位字符";
            });

            /*当鼠标离开密码文本框时，提示文本及样式*/
            $("#password").blur(flagPwd=function (){
                var $pwd=$("#password");
                var $pwdId=$("#passwordId");
                var reg=/^[0-9a-zA-Z]{3,9}[0-9a-zA-Z]$/;
                if($pwd[0].value==""){
                    $pwdId[0].className="error_prompt";
                    $pwdId[0].innerHTML="密码不能为空，请输入密码";
                    return false;
                }
                if(reg.test($pwd[0].value)==false){
                    $pwdId[0].className="error_prompt";
                    $pwdId[0].innerHTML="密码由英文字母和数字组成的4-10位字符";
                    return false;
                }
                else{
                    $pwdId[0].className="ok_prompt";
                    $pwdId[0].innerHTML="密码输入正确";
                    return true;
                }
            });


            /*当鼠标离开重复密码文本框时，提示文本及样式*/
            $("#repassword").blur(flagRepwd=function (){
                var $repwd=$("#repassword");
                var $pwd=$("#password");
                var $repwdId=$("#repasswordId");
                if($repwd[0].value==""){
                    $repwdId[0].className="error_prompt";
                    $repwdId[0].innerHTML="重复密码不能为空，请重复输入密码";
                    return false;
                }
                if($repwd[0].value!=$pwd[0].value){
                    $repwdId[0].className="error_prompt";
                    $repwdId[0].innerHTML="两次输入的密码不一致，请重新输入";
                    return false;
                }
                $repwdId[0].className="ok_prompt";
                $repwdId[0].innerHTML="两次密码输入正确";
                return true;
            });


            /*当鼠标放在邮箱文本框时，提示文本及样式*/
            $("#user_email").focus(function (){
                var $emailId=$("#EmailId");
                $emailId[0].className="import_prompt";
                $emailId[0].innerHTML="请输入您常用的电子邮箱";
            });

            /*当鼠标离开邮箱文本框时，提示文本及样式*/
            $("#user_email").blur( flagEmail= function (){
                var $email=$("#user_email");
                var $emailId=$("#EmailId");
                var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
                if($email[0].value==""){
                    $emailId[0].className="error_prompt";
                    $emailId[0].innerHTML="邮箱不能为空，请输入邮箱";
                    return false;
                }
                else if(reg.test($email[0].value)==false){
                    $emailId[0].className="error_prompt";
                    $emailId[0].innerHTML="邮箱格式不正确，请重新输入";
                    return false;
                }else {
                    $emailId[0].className="ok_prompt";
                    $emailId[0].innerHTML="邮箱输入正确";
                    return true;
                }

            });
            /*当鼠标离开邮箱文本框时，提示文本及样式*/
            $("#user_email").blur( flagEmail= function (){
                var $email=$("#user_email");
                var $emailId=$("#EmailId");
                var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
                if($email[0].value==""){
                    $emailId[0].className="error_prompt";
                    $emailId[0].innerHTML="邮箱不能为空，请输入邮箱";
                    return false;
                }
                else if(reg.test($email[0].value)==false){
                    $emailId[0].className="error_prompt";
                    $emailId[0].innerHTML="邮箱格式不正确，请重新输入";
                    return false;
                }else {
                    $emailId[0].className="ok_prompt";
                    $emailId[0].innerHTML="邮箱输入正确";
                    return true;
                }

            });
            /*表单提交时验证表单内容输入的有效性*/
            $("#signUp").click(function () {

                if(flagUserName()==true &&flagPwd()==true &&flagRepwd()==true&&flagEmail()==true){

                    $.post("signUp",
                        {"user_name":$("#user_name").val(),
                            "password":$("#password").val(),
                            "user_email":$("#user_email").val(),
                            "vcode":$("#vcode").val()
                        },function (data,status) {
                            $("#message").html(data);

                            flag=$("#message").text().length;

                            if($("#message").html()=="注册成功"){
                                window.location.href="http://localhost:8080/login.jsp";
                            }

                        }
                    );

                }
                    return false;

            });

        });

    </script>
</head>
<body>
<div id="container">
    <!--头部-->
    <div id="top">
        <img src="image/logo.jpg" height="100" width="360"/><hr/>
    </div>
    <!--左边-->
    <div id="middle">
        <p>注册步骤:1.填写信息>2.验证邮箱>3.注册成功</p>
        <h4>以下均为必填项</h4>
        <table>
            <tr>
                <td>
                    <form action="signUp" method="post">
                        <dl>
                            <dt>请填写您的Email地址：</dt>
                            <dd><input id="user_email" name="user_email" type="text"/></dd>
                            <div id="EmailId"></div>


                            <dt>设置你在当当网的昵称：</dt>
                            <dd><input id="user_name" name="user_name" type="text"/></dd>
                            <div id="userNameId"></div>


                            <dt>设置密码：</dt>
                            <dd><input id="password" name="password" type="password"/></dd>
                            <div id="passwordId"></div>

                            <dt >再次输入您设置的密码：</dt>
                            <dd><input id="repassword" name="password" type="password"/></dd>
                            <div id="repasswordId"></div>
                            <dt>验证码：</dt>
                            <dd><input type="text" id="vcode" name="vcode" style="width: 100px"/><img src="${pageContext.request.contextPath}/vcode"></dd>
                            <div class="import_prompt">请输入图中的验证码。<a href="${pageContext.request.contextPath}/signUp.jsp">看不清楚?换个图片</a></div>
                            <div style="clear: left;margin:0px 0px 0px 270px"><input type="submit" id="signUp" name="signUp" value="注册"/></div>
                            <div id="message" style="color: red; margin:10px 0px 40px 250px"></div>
                        </dl>

                    </form>
                </td>
            </tr>
        </table>

    </div>
    <div id="foot">
        <hr/>
        <p>Copyright (C) 当当网 2004-2017, All Rights Reserved京ICP证041189号<br/>

            <img src="image/validate.gif" height="47" width="128"/></p>
    </div>
</div>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <title>登录</title>
    <link href="logincss.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(function () {
            var flag=false;
            $("#login").click(function () {

              $.post("login",
                    {"user_name":$("#user_name").val(),
                        "password":$("#password").val(),
                        "remember":$("#remember").is(":checked")
                    },function (data,status) {
                        $("#message").html(data);


                        if($("#message").html()=="true"){
                        $("#message").html("登录成功");

                         window.location.href="http://localhost:8080/book";
                        }else if($("#message").html()=="admintrue"){
                         window.location.href="http://localhost:8080/admin.jsp?user_name="+$("#user_name").val();
                        }
                        else {
                            $("#message").html("账号密码错误");
                        }
                    }
                );

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
    <div id="left">
        <h2>当当网,全球最大的中文网上书店</h2><hr/>
        <ul>
            <li>更多选择</li>
            <p>60万种图书音像,共计百万种商品</p>
            <li>更低价格</li>
            <p>电脑购物3-5折,传统书店5-7折,其他网站7-9折</p>
            <li>更方便、更安全</li>
            <p>全国超过300个成熟送货上门,货到付款，零风险购物,便捷到家。</p>
        </ul>
    </div>
    <!--右边-->
    <div id="right">
        <hr/>
        <h3>登录当当网</h3><br/>
        <form action="login"  method="post">
            <font style="margin-left: 4px">请输入用户名：</font><input id="user_name" name="user_name" type="text"/><br/><br/>
            <font style="margin-left: 55px">密码：</font><input id="password" name="password" type="password"/><br/><br/>
            <input id="login" style="margin-left: 95px" type="submit" value="登录"/> <br/>
            <input id="remember" style="margin-left: 95px" type="checkbox" checked="checked" />记住我
            <div id="message" style="margin-left: 95px;color: red"></div>
        </form>
        <hr/>
        <h3>您还不是当当网用户?</h3><br/>
        <a href="signUp.jsp">创建一个新用户>></a>
    </div>
    <div id="foot">
        <hr/>
        <p>Copyright (C) 当当网 2004-2017, All Rights Reserved京ICP证041189号<br/>

            <img src="image/validate.gif" height="47" width="128"/></p>
    </div>
</div>
</body>
</html>

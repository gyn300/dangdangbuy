
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
    <link href="commodity.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function getRequest() {
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
                }
            }
            return theRequest;
        }
        $(function () {
           $("#add").click(function () {
               if(user_name==""||user_name==undefined){
                    window.location.href="login.jsp";
               }else{
                   $.post("addShoppingTrolley",
                       {"user_name":user_name,
                           "book_id": ${book.getId()}
                       },function (data,status) {
                           $("#message").html(data);
                           $("#message").fadeOut(2000);
                       }

                   );
               }
           });
            $("#shoppingTrolley").click(function () {
                if(user_name==""||user_name==undefined){
                    window.location.href="login.jsp";
                }else{
                    window.location.href="checkTrolley";
                }
            });
        });
    </script>
</head>
<body>
<div id="container">
    <!--头部-->
    <div >
        <div id="login">
            <span ><font style="font-weight: bold">你好,欢迎光临当当网</font><span id="user_name">[<a href="login.jsp" style="color: #1f69b4;font-weight: bold">登录</a>|<a href="signUp.jsp" style="color: #1f69b4;font-weight: bold">注册</a>]</span>
                <span>| <a href="book">返回首页</a></span>
                <span style="float: right;font-weight: bold"><a id="shoppingTrolley" href="#">购物车</a>|<a id="userInformation" href="#">我的当当</a>|<a href="#">帮助</a>|</span>
          </span>
        </div>
        <div style="background: #d8e4c6">
            <p><img src="image/logo.jpg" height="100" width="360"/></p>
        </div>
    </div>
    <hr/>

    <!--中部-->
    <div id="commodity">

       <h3>${book.getBook_name()}</h3>
        <img src="/image/${book.getId()-1}.jpg" height="200">
        <dl>
            <dt style="margin-top: 0px">书名：</dt>
            <dd>${book.getBook_name()}</dd>
            <dt>作者：</dt>
            <dd>${book.getAuthor()} 著</dd>
            <dt>出版社：</dt>
            <dd>${book.getPublishing()}</dd>
            <dt>简介：</dt>
            <dd>${book.getSynopsis()}</dd>
            <dt>定价：</dt>
            <dd>¥${book.getBook_price()} 当当价：¥${book.getDangdang_price()} </dd>
            <dt><input id="add" type="button" value="加入购物车"><div style="color: red;margin-top:5px;margin-bottom: 10px;height: 20px" id="message"></div></dt>
            <br/><br/>


        </dl>

    </div>
    <!--底部-->
    <div id="foot">
        <hr/>
        <p>Copyright (C) 当当网 2004-2017, All Rights Reserved京ICP证041189号<br/>

            <img src="image/validate.gif" height="47" width="128"/></p>
    </div>
</div>
        <script type="text/javascript">

            var user_name;
            window.onload=function getUserName() {

                user_name="${sessionScope.user_name}";

                if(user_name!=null&&user_name!=""&&user_name!=undefined){

                    $("#user_name").html(" "+user_name+" <a href='quit'>[退出]</a>").css("color","blue");
                    $("#userInformation").attr("href","userInformation.jsp");
                }
            }
        </script>
</body>
</html>

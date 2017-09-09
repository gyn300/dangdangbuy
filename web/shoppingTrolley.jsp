<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link href="shoppingTrolley.css" rel="stylesheet" type="text/css">
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

            $("#shoppingTrolley").click(function () {
                if(user_name==""||user_name==undefined){
                    window.location.href="login.jsp";
                }else{
                    window.location.href="checkTrolley";
                }
                return false;
            });
            <!-- 更改数量-->
            $(".changecount").click(function () {

                if($(this).siblings().val()!=""){

                    $.post("mdTrolley",
                        {"count":$(this).siblings().val(),
                        "book_id":$(this).parent().parent().attr("id"),
                            "user_name":user_name
                        },function (data,status) {
                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else{
                    $("#message").html("数量不能为空");
                    $("#message").fadeOut(2000);
                }
            });
            <!--删除-->
            $(".del").click(function () {

                    $.post("mdTrolley",
                        {
                            "book_id":$(this).parent().parent().attr("id"),
                            "user_name":user_name
                        },function (data,status) {
                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }

                    );
                $(this).parent().parent().remove();
                location.reload();
            });

            <!--删除全部-->
            $("#delAll").click(function () {

                $.post("mdTrolley",
                    {   "user_name":user_name
                    },function (data,status) {
                        $("#message").html(data);
                        $("#message").fadeOut(2000);
                    }

                );
                $("tr").eq(0).siblings().remove();
                location.reload();

            });
            <!--结算-->
            $("#pay").click(function (){
                if(total!=0){
                  if(${user.getUser_address()!=null&&user.getUser_address()!=""}){
                    $.post("buyBook",{
                            "user_name":user_name,
                            "consumeMoney":total,
                            "content":content
                        },function (data,status) {
                        $("#message").html(data);
                        $("#message").fadeOut(2000);
                        if($("#message").html()==("购买成功")){
                            $("tr").eq(0).siblings().remove();
                          }
                        }
                    );
                    }else{
                        alert("前往填写电话号码和收货地址");
                        window.location.href="userInformation.jsp";
                  }
                }else{
                    $("#message").html("没有可结算的商品");

                }
            });

        });
    </script>
</head>
<body>
<div id="container">
    <div >
        <div id="login">
            <span ><font style="font-weight: bold">你好,欢迎光临当当网</font><span id="user_name">[<a href="login.jsp" style="color: #1f69b4;font-weight: bold">登录</a>|<a href="signUp.jsp" style="color: #1f69b4;font-weight: bold">注册</a>]</span>
                <span>| <a href="book">返回首页</a></span>
                <span style="float: right;font-weight: bold"><a id="shoppingTrolley" href="#">购物车</a>|<a id="userInformation" href="login.jsp">我的当当</a>|<a href="#">帮助</a>|</span>
          </span>
        </div>
        <div style="background: #d8e4c6">
            <p><img src="image/logo.jpg" height="100" width="360"/></p>
        </div>
    </div>
    <h2>我的购物车</h2>
    <p><span style="font-size: 15px">你已购买以下商品</span><input  id="delAll" type="button" value="清空购物车"> </p>
    <div>
        <table>
            <tr style="background: #d8e4c6">
                <td>商品名</td>
                <td>封面</td>
                <td>市场价</td>
                <td>当当价</td>
                <td>数量</td>
                <td>变更数量</td>
                <td>删除</td>
            </tr>
            <div id="content">
                <c:forEach items="${list}" var="list" varStatus="status">

                    <tr id="${list.getBook_id()}">

                        <td>${bc.getBook(list.getBook_id()).getBook_name()}</td>
                        <td><img src="/image/${list.getBook_id()-1}.jpg" height="100px"></td>
                        <td>¥${bc.getBook(list.getBook_id()).getBook_price()}</td>
                        <td>¥${bc.getBook(list.getBook_id()).getDangdang_price()}</td>
                        <td>${list.getCount()}</td>
                        <td><input type="text" style="width: 30px">
                            <input class="changecount" type="button" value="变更"></td>
                        <td><input class="del" type="button" value="删除"> </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><span id="totalMoney" style="font-weight: bold"></span></td>
                    <td>
                    <input id="pay" type="button" value="结算" style="background: #78e5c8;height: 30px;font-weight: bold">

                    </td></tr>
            </div>

        </table>


        <div style="color: red;margin-top:10px;margin-left: 400px" id="message"></div>
    </div>
</div>
<script type="text/javascript">
    var total=0;
    var user_name;
    var content="";
    window.onload=function getUserName() {

        <c:forEach items="${list}" var="list" varStatus="status">
        total+=${bc.getBook(list.getBook_id()).getDangdang_price()};
        content+="${bc.getBook(list.getBook_id()).getBook_name()}"+","
        </c:forEach>
        content+="¥"+total;
        $("#totalMoney").html("商品总额: ¥"+total);

        user_name="${sessionScope.user_name}";

        if(user_name!=null&&user_name!=""&&user_name!=undefined){

            $("#user_name").html(" "+user_name+" <a href='quit'>[退出]</a>").css("color","blue");
            $("#userInformation").attr("href","userInformation.jsp");
        }
    }
</script>
</body>
</html>

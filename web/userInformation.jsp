<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link href="userInformation.css" rel="stylesheet" type="text/css">
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

            $("li").mouseover(function () {
                $(this).css({"color":"blue","font-size":"18px"}) ;
            });
            $("li").mouseout(function () {
                $(this).css({"color":"black","font-size":"17px"}) ;
            });
            $("li").mousedown(function () {
                $(this).css("color","red") ;
            });
            $("li").mouseup(function () {
                $(this).css("color","blue") ;
            });
            $("#pageUp").click(function () {
                window.location.href="${pageContext.request.contextPath}/checkOrders?pageNum=${pageData.pageNum -1}";
            });
            $("#pageDown").click(function () {
                window.location.href="${pageContext.request.contextPath}/checkOrders?pageNum=${pageData.pageNum +1}";
            });
            /*点击修改密码*/
            $("#mdpassword").click(function () {
                $("#password").val("");
                $("#repassword") .val("");
                $("#tel").val("");
                $("#address").val("");

                $("#checkordersId").css("display","none");
                $(".hide").css("display","none") ;
                $("#mdpasswordId").css("display","block") ;
            });
            /*点击修改电话号码*/
            $("#mdtel").click(function () {
                $("#password").val("");
                $("#repassword") .val("");
                $("#tel").val("");
                $("#address").val("");
                $("#checkordersId").css("display","none");
                $(".hide").css("display","none") ;
                $("#mdtelId").css("display","block") ;
            });
            /*点击修改收货地址*/

            $("#mdaddress").click(function () {
                $("#password").val("");
                $("#repassword") .val("");
                $("#tel").val("");
                $("#address").val("");

                $("#checkordersId").css("display","none");
                $(".hide").css("display","none") ;
                $("#mdaddressId").css("display","block") ;
            });
            /*点击查看购买记录*/
            $("#checkorders").click(function () {
                $(".hide").css("display","none") ;
                $("#checkordersId").css("display","block") ;
            });

            /*点击充值*/
            $("#rechange").click(function () {
                $("#checkordersId").css("display","none");
                $(".hide").css("display","none") ;
                $("#rechangeId").css("display","block") ;
            });
            /*提交充值信息*/
             $("#rechangesubmit").click(function () {
                 if($("#rechange_name").val()!=""&&$("#rechange_money").val()!=""){
                     $.post("rechange",
                         {"user_name":$("#rechange_name").val(),
                             "rechangeMoney":$("#rechange_money").val(),
                         },function (data,status) {
                             $("#message").html(data);
                             $("#message").fadeOut(2000);
                         }
                     );
                 }
                 return false;
             });
            /*提交修改信息*/
            $("input:submit").click(function () {
                if((flagPwd()&&flagRepwd()||flagTel()||flagAddress())){
                     $.post("modify",
                        {"user_name":user_name,
                            "password":$("#password").val(),
                            "tel":$("#tel").val(),
                            "address":$("#address").val()
                        },function (data,status) {
                            $("#message").html(data);

                            if($("#message").html()=="密码修改成功"){

                                window.location.href="http://localhost:8080/quit";
                            }
                        }
                    );
                }
                return false;
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

            /*当鼠标放在手机号文本框时，提示文本及样式*/
            $("#tel").focus(function (){
                var $telId=$("#telId");
                $telId[0].className="import_prompt";
                $telId[0].innerHTML="1、手机号码以13，15，18开头<br/>2、手机号码由11位数字组成";
            });

            /*当鼠标离开手机号文本框时，提示文本及样式*/
            $("#tel").blur(flagTel=function () {
                var $tel = $("#tel");
                var $telId = $("#telId");
                var reg = /^(13|15|18)\d{9}$/;
                if ($tel[0].value == "") {
                    $telId[0].className = "error_prompt";
                    $telId[0].innerHTML = "手机号码不能为空，请输入手机号码";
                    return false;
                }
                if (reg.test($tel[0].value) == false) {
                    $telId[0].className = "error_prompt";
                    $telId[0].innerHTML = "手机号码输入不正确，请重新输入";
                    return false;
                } else {
                    $telId[0].className = "ok_prompt";
                    $telId[0].innerHTML = "手机号码输入正确";
                    return true;
                }

            });
            /**
             * 当鼠标离开地址框
             */
            $("#address").blur(flagAddress=function () {
                var $address = $("#address");
                var $addressId = $("#addressId");
               if($("#address").val()==""||$("#address").val()==null){
                   $addressId[0].className="error_prompt";
                   $addressId[0].innerHTML="地址栏不能为空";
                   return false;
               }else{
                   $addressId[0].className="prompthide";
                   $addressId[0].innerHTML="";
                   return true;
               }
            });
            /**
             * 当鼠标离开充值用户名栏
             */
            $("#rechange_name").blur(function () {
                var $rechange_name = $("#rechange_name");
                var $rechange_nameId = $("#rechange_nameId");
                if($("#rechange_name").val()==""||$("#rechange_name").val()==null){
                    $rechange_nameId[0].className="error_prompt";
                    $rechange_nameId[0].innerHTML="不能为空";
                    return false;
                }else{
                    $rechange_nameId[0].className="prompthide";
                    $rechange_nameId[0].innerHTML="";
                    return true;
                }
            });
            /**
             * 当鼠标离开充值金额栏
             */
            $("#rechange_money").blur(function () {
                var $rechange_money = $("#rechange_money");
                var $rechange_moneyId = $("#rechange_moneyId");
                if($("#rechange_money").val()==""||$("#rechange_money").val()==null){
                    $rechange_moneyId[0].className="error_prompt";
                    $rechange_moneyId[0].innerHTML="不能为空";
                    return false;
                }else{
                    $rechange_moneyId[0].className="prompthide";
                    $rechange_moneyId[0].innerHTML="";
                    return true;
                }
            });

        });
    </script>
</head>
<body>
<div id="container">


    <div id="top">
            <span ><font style="font-weight: bold">你好,欢迎光临当当网</font><span id="user_name"></span>
               <span>| <a href="book">返回首页</a></span>
                <span style="float: right;font-weight: bold"><a id="shoppingTrolley" href="#">购物车</a>|<a id="userInformation" href="#">我的当当</a>|<a href="#">帮助</a>|</span>
          </span>
    </div>
    <div style="background: #d8e4c6">
        <p><img src="image/logo.jpg" height="100" width="360"/></p>
    </div>


    <!--左侧-->
    <div id="left">
        <p >修改资料</p>
        <ul>
            <li id="rechange">充值</li>
            <li id="mdpassword">修改密码</li>
            <li id="mdtel">修改电话号码</li>
            <li id="mdaddress">修改收货地址</li>
            <li id="checkorders">查看购买记录</li>
        </ul>

    </div>

    <!--右侧-->

    <div id="right">
        <div class="hide" id="rechangeId">
            <form method="post">
                用户名：<br/>
                <input id="rechange_name" type="text"/>
                <div class="prompthide" id="rechange_nameId"></div>
                <br/><br/>
                充值的金额(元)：<br/>
                <input id="rechange_money" type="text"/>
                <div class="prompthide" id="rechange_moneyId"></div>
                <br/><br/>
                <input id="rechangesubmit" type="submit" value="提交"/>
            </form>

        </div>
        <div class="hide" id="mdpasswordId">
            <form method="post">
                新密码：<br/>
                <input id="password" type="password"/>
                <div class="prompthide" id="passwordId"></div>
                <br/><br/>
                重新输入新密码：<br/>
                <input id="repassword" type="password"/>
                <div class="prompthide" id="repasswordId"></div>
                <br/><br/>
                <input id="passwordsubmit" type="submit" value="提交"/>
            </form>

        </div>
        <div class="hide" id="mdtelId">
            <form method="post">
                新电话号码：<br/>
                <input id="tel" type="text"/>
                <div class="prompthide" id="telId"></div>
                <br/><br/>
                <input id="telsubmit" type="submit" value="提交"/>
            </form>

        </div>
        <div class="hide" id="mdaddressId">
            <form method="post">
                新收货地址：<br/>
                <textarea id="address" ></textarea>
                <div class="prompthide" id="addressId"></div>
                <br/><br/>
                <input id="addresssubmit" type="submit" value="提交"/>
            </form>

        </div>
        <div id="checkordersId">
            <h1>显示书本列表</h1>

            <c:forEach items="${pageData.list}" var="order">
                <h3>${order}</h3>
            </c:forEach>
            <div id="pageMessage">
            <h3 >[ 当前页：${pageData.pageNum } ] </h3>
            <h3 >[ 每页记录数：${pageData.pageSize } ] </h3>
            <h3 >[ 总记录数：${pageData.count } ] </h3>
            <h3 [ 总页数：${pageData.pageCount } ] </h3>
            </div>

        <div id="page" >
            <a id="pageUp" href="#">上一页</a>
            <a id="pageDown" href="#">下一页</a>
        </div>
        </div>
        <div id="message"></div>
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
        }
    }
</script>
</body>
</html>

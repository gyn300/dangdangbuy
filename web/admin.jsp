<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link href="admin1.css" rel="stylesheet" type="text/css">
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
            $("dd").mouseover(function () {
                $(this).css({"color":"blue","font-size":"16px"}) ;
            });
            $("dd").mouseout(function () {
                $(this).css({"color":"black","font-size":"15px"}) ;
            });
            $("dd").mousedown(function () {
                $(this).css("color","red") ;
            });
            $("dd").mouseup(function () {
                $(this).css("color","blue") ;
            });
            $("#pageUp").click(function () {
                window.location.href="${pageContext.request.contextPath}/checkBook?pageNum=${pageData.pageNum -1}";
            });
            $("#pageDown").click(function () {
                window.location.href="${pageContext.request.contextPath}/checkBook?pageNum=${pageData.pageNum +1}";
            });


            /*点击修改收货地址*/
            $("#mdaddress").click(function () {
                $("#checkbookId").css("display","none") ;
                $("#message").html("");
                $(".hide").css("display","none") ;
                $("#mdaddressId").css("display","block") ;
            });

            /*点击添加商品*/
            $("#addbooks").click(function () {
                $("#checkbookId").css("display","none") ;
                $("#message").html("");
                $(".hide").css("display","none") ;
                $("#addbook").css("display","block") ;
            });
            /*点击查看商品*/
            $("#checkbook").click(function () {
                $("#message").html("");
                $(".hide").css("display","none") ;
                $("#checkbookId").css("display","block") ;
                $.post("checkBook"
                    ,function (data,status) {


                    }
                );
            });
            /*点击修改商品*/
            $("#mdbook").click(function () {
                $("#message").html("");
                $("#checkbookId").css("display","none") ;
                $(".hide").css("display","none") ;
                $("#mdbookId").css("display","block") ;

            });
            /*点击查看用户*/
            $("#checkUser").click(function () {
                $("#message").html("");
                $("#checkbookId").css("display","none") ;
                $(".hide").css("display","none") ;
                $("#checkUserId").css("display","block") ;

            });
            /*提交修改用户信息*/
            $("#addresssubmit").click(function () {
                if(flagMdUserName()&&flagAddress()){
                    $.post("modify",
                        {"user_name":$("#mduser_name").val(),

                            "address":$("#address").val()
                        },function (data,status) {
                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }
                return false;
            });
            /*提交查看用户*/
            $("#cuser_nameId") .click(function () {
                if($("#cuser_name").val()!=""){
                    $.post("checkUser",
                        {"user_name":$("#cuser_name").val(),

                        },function (data,status) {
                            $("#message").html(data);

                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*提交添加商品信息*/
            $("#addbooksubmit").click(function () {
                var flag=($("#addbook textarea")[0].value!=""&&$("#addbook textarea")[0].value!=null)&&($("#addbook textarea")[1].value!=""&&$("#addbook textarea")[1].value!=null)&&($("#addbook textarea")[2].value!=""&&$("#addbook textarea")[2].value!=null)&&($("#addbook textarea")[3].value!=""&&$("#addbook textarea")[3].value!=null)&&($("#addbook textarea")[4].value!=""&&$("#addbook textarea")[4].value!=null)&&($("#addbook textarea")[5].value!=""&&$("#addbook textarea")[5].value!=null)&&($("#addbook textarea")[6].value!=""&&$("#addbook textarea")[6].value!=null)
                if(flag){
                    $.post("addBook",
                        {"book_name":$("#book_name").val(),
                            "book_price":$("#book_price").val(),
                            "dangdang_price":$("#dangdang_price").val(),
                            "author":$("#author").val(),
                            "publishing":$("#publishing").val(),
                            "synopsis":$("#synopsis").val(),
                            "family":$("#family").val()
                        },function (data,status) {
                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改名字*/
                    $("#mdbook_nameId").click(function () {

                        if($("#mdbook_id").val()!=""&&$("#mdbook_name").val()!=""){
                            $.post("mdBook",
                                {"id":$("#mdbook_id").val(),
                                    "book_name":$("#mdbook_name").val(),

                                },function (data,status) {

                                  $("#message").html(data);
                                    $("#message").fadeOut(2000);
                                }
                    );
                }else {
                    $("#message").html("选项不能为空");
                      $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改定价*/
            $("#mdbook_priceId").click(function () {

                if($("#mdbook_id").val()!=""&&$("#mdbook_price").val()!=""){
                    $.post("mdBook",
                        {"id":$("#mdbook_id").val(),
                            "book_price":$("#mdbook_price").val(),

                        },function (data,status) {

                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改当当定价*/
            $("#mddangdang_priceId").click(function () {

                if($("#mdbook_id").val()!=""&&$("#mddangdang_price").val()!=""){
                    $.post("mdBook",
                        {"id":$("#mdbook_id").val(),

                            "dangdang_price":$("#mddangdang_price").val(),

                        },function (data,status) {

                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改作者*/
            $("#mdauthorId").click(function () {

                if($("#mdbook_id").val()!=""&&$("#mdauthor").val()!=""){
                    $.post("mdBook",
                        {"id":$("#mdbook_id").val(),

                            "author":$("#mdauthor").val(),

                        },function (data,status) {

                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改出版社*/
            $("#mdpublishingId").click(function () {

                if($("#mdbook_id").val()!=""&&$("#mdpublishing").val()!=""){
                    $.post("mdBook",
                        {"id":$("#mdbook_id").val(),

                            "publishing":$("#mdpublishing").val(),

                        },function (data,status) {

                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改简介*/
            $("#mdsynopsisId").click(function () {

                if($("#mdbook_id").val()!=""&&$("#mdsynopsis").val()!=""){
                    $.post("mdBook",
                        {"id":$("#mdbook_id").val(),

                            "synopsis":$("#mdsynopsis").val(),

                        },function (data,status) {

                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                    $("#message").fadeOut(2000);
                }
                return false;
            });
            /*修改分类*/
            $("#mdfamilyId").click(function () {

                if($("#mdbook_id").val()!=""&&$("#mdfamily").val()!=""){
                    $.post("mdBook",
                        {"id":$("#mdbook_id").val(),

                            "family":$("#mdfamily").val()
                        },function (data,status) {

                            $("#message").html(data);
                            $("#message").fadeOut(2000);
                        }
                    );
                }else {
                    $("#message").html("选项不能为空");
                }
                return false;
            });
            /*当鼠标离开通行证用户名文本框时，提示文本及样式*/
            $("#mduser_name").blur(flagMdUserName=function (){
                var $userName=$("#mduser_name");
                var $userNameId=$("#mduser_nameId");
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


        });
    </script>
</head>
<body>
<div id="container">


    <div id="top">
            <span ><font style="font-weight: bold">你好,欢迎光临当当网</font><span id="user_name"></span>
                <span style="float: right;font-weight: bold"><a href="#">购物车</a>|<a href="#">我的当当</a>|<a href="#">帮助</a>|</span>
          </span>
    </div>
    <div style="background: #d8e4c6">
        <p><img src="image/logo.jpg" height="100" width="360"/></p>
    </div>


    <!--左侧-->
    <div id="left">
        <p >菜单</p>
        <dl>
            <dt>商品管理</dt>
            <dd id="addbooks">添加商品</dd>
            <dd id="checkbook">查看商品</dd>
            <dd id="mdbook">修改商品</dd>
            <hr/>
            <dt>用户管理</dt>
            <dd id="checkUser">查看用户信息</dd>
            <dd id="mdaddress">修改用户收货地址</dd>


        </dl>

    </div>

    <!--右侧-->
    <div id="right">
        <div class="hide" id="addbook">
            <form method="post">
                <p style="color: red">以下选项不能为空</p>
                书名：<br/>
                <textarea id="book_name" ></textarea>
                <div class="prompthide" id="book_nameId"></div><br/><br/>
                作者：<br/>
                <textarea id="author" ></textarea>
                <div class="prompthide" id="authorId"></div>
                <br/><br/>
                出版社和出版时间：<br/>
                <textarea id="publishing" ></textarea>
                <div class="prompthide" id="publishingId"></div>
                <br/><br/>
                简介：<br/>
                <textarea id="synopsis" ></textarea>
                <div class="prompthide" id="synopsisId"></div>
                <br/><br/>
                分类：<br/>
                <textarea id="family" ></textarea>
                <div class="prompthide" id="familyId"></div>
                <br/><br/>
                定价：<br/>
                <textarea id="book_price" ></textarea>
                <div class="prompthide" id="book_priceId"></div>
                <br/><br/>
                当当价：<br/>
                <textarea id="dangdang_price" ></textarea>
                <div class="prompthide" id="dangdang_priceId"></div>
                <br/><br/>
                <input id="addbooksubmit" type="submit" value="添加"/>
            </form>

        </div>
        <div  id="checkbookId">
            <h1>显示书本列表</h1>

            <c:forEach items="${pageData.list}" var="book">
                <h3>${book}</h3>
            </c:forEach>
            <div id="pageMessage" style="clear: left">
            <h3 >[ 当前页：${pageData.pageNum } ] </h3>
            <h3 >[ 每页记录数：${pageData.pageSize } ] </h3>
            <h3 >[ 总记录数：${pageData.count } ] </h3>
            <h3 [ 总页数：${pageData.pageCount } ] </h3>
            </div>
            <div id="page" style="margin-left: 100px">
            <a id="pageUp" href="#">上一页</a>
            <a id="pageDown" href="#">下一页</a>
            </div>
        </div>
        <div class="hide" id="mdbookId">
            <form method="post">
                请输入要修改的书本ID：<br/>
                <input id="mdbook_id" /><br/><br/>
                修改书名：<br/>
                <textarea id="mdbook_name" ></textarea>
                <input type="button" id="mdbook_nameId" value="修改"><br/><br/>
                修改作者：<br/>
                <textarea id="mdauthor" ></textarea>
                <input type="button" id="mdauthorId" value="修改"><br/><br/>
                修改出版社和出版时间：<br/>
                <textarea id="mdpublishing" ></textarea>
                <input type="button" id="mdpublishingId" value="修改"><br/><br/>
                修改简介：<br/>
                <textarea id="mdsynopsis" ></textarea>
                <input type="button" id="mdsynopsisId" value="修改"><br/><br/>
                修改分类：<br/>
                <textarea id="mdfamily" ></textarea>
                <input type="button" id="mdfamilyId" value="修改"><br/><br/>
                修改定价：<br/>
                <textarea id="mdbook_price" ></textarea>
                <input type="button" id="mdbook_priceId" value="修改"><br/><br/>
                修改当当价：<br/>
                <textarea id="mddangdang_price" ></textarea>
                <input type="button" id="mddangdang_priceId" value="修改"><br/><br/>
            </form>

        </div>
        <div class="hide" id="checkUserId">
            请输入要查看的用户名字：<br/>
            <input type="text" id="cuser_name" /><br/><br/>
            <input type="button"id="cuser_nameId" value="提交"/>
        </div>

        <div class="hide" id="mdaddressId">
            <form method="post">
                用户名：<br/>
                <input id="mduser_name" />
                <div class="prompthide" id="mduser_nameId"></div><br/><br/>
                新收货地址：<br/>
                <textarea id="address" ></textarea>
                <div class="prompthide" id="addressId"></div>
                <br/><br/>
                <input id="addresssubmit" type="submit" value="提交"/>
            </form>

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

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/17
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>当当网上图书商店</title>
    <link href="welcss.css" rel="stylesheet" type="text/css">
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

            $("#panfan").click(function () {
                if(user_name==""||user_name==undefined){
                    window.location.href="commodity?id=1";
                }else{
                    window.location.href="commodity?id=1";
                }
            });

            $("#nahan").click(function () {
                if(user_name==""||user_name==undefined){
                    window.location.href="commodity?id=2";
                }else{
                    window.location.href="commodity?id=2";
                }
            });

            $("#newbooks img").click(function () {

                    window.location.href="commodity?id="+$(this).attr("id");

            });

            $("#shoppingTrolley").click(function () {
                if(user_name==""||user_name==undefined){
                    window.location.href="login.jsp";
                }else{
                    window.location.href="checkTrolley";
                }
                return false;
            });

        });

    </script>
</head>

<body>
<!--整体div-->
<div id="container">
    <!--登录注册-->
    <div >
        <div id="login">
            <span ><font style="font-weight: bold">你好,欢迎光临当当网</font><span id="user_name">[<a href="login.jsp" style="color: #1f69b4;font-weight: bold">登录</a>|<a href="signUp.jsp" style="color: #1f69b4;font-weight: bold">注册</a>]</span>
                <span style="float: right;font-weight: bold"><a id="shoppingTrolley" href="#">购物车</a>|<a id="userInformation" href="login.jsp">我的当当</a>|<a href="#">帮助</a>|</span>
          </span>
        </div>
        <div style="background: #d8e4c6">
            <p><img src="image/logo.jpg" height="100" width="360"/></p>
        </div>
    </div>
    <!--banner-->
    <div id="banner">
        <img src="image/banner.jpg" height="65" width="1200"/></div>
    <!--左侧-->
    <div id="left">
        <p >分类浏览</p>
        <dl>
            <dt>[小说]</dt>
            <dd><a href="family?family=当代小说">当代小说</a>|</dd>
            <dd><a href="family?family=近现代小说">近现代小说</a>|</dd>
            <dd><a href="family?family=古典小说">古典小说</a>|</dd>
            <dd><a href="family?family=四大名著">四大名著</a>|</dd>
            <dd><a href="family?family=世界名著">世界名著</a>|</dd>
        </dl>
        <hr/>
        <dl>
            <dt>[青春]</dt>
            <dd><a href="#">校园</a>|</dd>
            <dd><a href="#">爱情/情感</a>|</dd>
            <dd><a href="#">叛逆/成长</a>|</dd>
            <dd><a href="#">玄幻</a>|</dd>
            <dd><a href="#">原创</a>|</dd>
        </dl>
        <hr/>
        <dl>
            <dt>[人文社科]</dt>
            <dd><a href="#">政治</a>|</dd>
            <dd><a href="#">经济</a>|</dd>
            <dd><a href="#">法律</a>|</dd>
            <dd><a href="#">哲学</a>|</dd>
            <dd><a href="#">历史</a>|</dd>
        </dl>
        <hr/>
        <dl>
            <dt>[管理]</dt>
            <dd><a href="#">管理学</a>|</dd>
            <dd><a href="#">战略管理</a>|</dd>
            <dd><a href="#">市场营销</a>|</dd>
            <dd><a href="#">商业史传</a>|</dd>
            <dd><a href="#">电子商务</a>|</dd>
        </dl>
        <hr/>
        <dl>
            <dt>[少儿]</dt>
            <dd><a href="#">0-2岁</a>|</dd>
            <dd><a href="#">3-6岁</a>|</dd>
            <dd><a href="#">7-10岁</a>|</dd>
            <dd><a href="#">11-14岁</a>|</dd>
            <dd><a href="#">儿童文学</a>|</dd>
        </dl>
        <hr/>
        <dl>
            <dt>[外语]</dt>
            <dd><a href="#">英语</a>|</dd>
            <dd><a href="#">日语</a>|</dd>
            <dd><a href="#">韩语</a>|</dd>
            <dd><a href="#">俄语</a>|</dd>
            <dd><a href="#">德语</a>|</dd>
        </dl>
        <hr/>
        <dl>
            <dt>[计算机]</dt>
            <dd><a href="#">计算机理论</a>|</dd>
            <dd><a href="#">数据库</a>|</dd>
            <dd><a href="#">程序设计</a>|</dd>
            <dd><a href="#">人工智能</a>|</dd>
            <dd><a href="#">计算机考试</a>|</dd>
        </dl>
        <hr/><br/>

    </div>
    <!--中间-->
    <div id="middle">

        <div id="middle-top">
            <p>编辑推荐</p>
            <div>
                <img id="img-top" src="image/0.jpg" height="100" />
                <dl>
                    <a id="panfan" href="#">书名:平凡的世界</a><br/>
                    <dt>作者:</dt>
                    <dd>路遥 著</dd>
                    <dt>出版社:</dt>
                    <dd>北京十月文艺出版社 &nbsp;出版时间:2012-03-01</dd>
                    <dt>简介:</dt>
                    <dd>茅盾文学奖皇冠上的明珠,激励千万青年的不朽经典</dd>
                    <dt>定价:</dt>
                    <dd>¥79.8 当当价:¥59.8 <hr/></dd>

                </dl>

            </div>
            <div>
                <img style="margin-left: 10px;margin-right: 10px" src="image/1.jpg" height="100"/>
                <dl>
                    <a id="nahan" href="#">书名:鲁迅-呐喊·彷徨</a><br/>
                    <dt>作者:</dt>
                    <dd>鲁迅 著</dd>
                    <dt>出版社:</dt>
                    <dd>译林出版社 &nbsp;出版时间:2012-03-01</dd>
                    <dt>简介:</dt>
                    <dd>重读鲁迅文字,体会他对现实社会人生的冷峻刻画</dd>
                    <dt>定价:</dt>
                    <dd>¥26.8 当当价:¥16.3 <hr/></dd>

                </dl>
            </div>
        </div>
        <div id="middle-mid">
            <p>热销图书<a href="#" style="float:right;color: #8a8a8a">更多>></a></p>
        </div>
        <div style="height: 240px;" id="middle-bottom">
            <p ><span id="p1">最新上架图书</span><a href="#" style="float:right;color: #8a8a8a">更多>></a></p>
            <div id="newbooks">
                <ul>
                    <li style=" float: left;list-style-type: none" id="new1">
                       <img id="${books.size()}" src="image/${books.size()-1}.jpg" height="100"/><br/>
                        <h3 style="margin-left: 25px">${books.get(books.size()-1).getBook_name()}</h3>
                        <span style="margin-left: 25px">定价：¥${books.get(books.size()-1).getBook_price()}</span>
                        <br/><span style="margin-left: 25px">当当价：¥${books.get(books.size()-1).getDangdang_price()}</span>
                    </li>
                    <li style=" float: left;list-style-type: none"  id="new2">
                        <img id="${books.size()-1}" src="image/${books.size()-2}.jpg" height="100"/><br/>
                        <h3 style="margin-left: 15px">${books.get(books.size()-2).getBook_name()}</h3>
                        <span style="margin-left: 15px">定价：¥${books.get(books.size()-2).getBook_price()}</span>
                        <br/><span style="margin-left: 15px">当当价：¥${books.get(books.size()-2).getDangdang_price()}</span>
                    </li>
                    </li>
                    <li style="float: left;list-style-type: none"  id="new3">
                        <img id="${books.size()-2}" src="image/${books.size()-3}.jpg" height="100"/><br/>
                        <h3 style="margin-left: 15px">${books.get(books.size()-3).getBook_name()}</h3>
                        <span style="margin-left: 15px">定价：¥${books.get(books.size()-3).getBook_price()}</span>
                        <br/><span style="margin-left: 15px">当当价：¥${books.get(books.size()-3).getDangdang_price()}</span>
                    </li>
                    </li>
                    <li style="float: left;list-style-type: none"  id="new4">
                        <img id="${books.size()-3}" src="image/${books.size()-4}.jpg" height="100"/><br/>
                        <h3 style="margin-left: 15px">${books.get(books.size()-4).getBook_name()}</h3>
                        <span style="margin-left: 15px">定价：¥${books.get(books.size()-4).getBook_price()}</span>
                        <br/><span style="margin-left: 15px">当当价：¥${books.get(books.size()-4).getDangdang_price()}</span>
                    </li>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--右侧-->
    <div id="right">
        <p >新书热卖榜<a href="#" style="float:right">更多>></a></p>
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

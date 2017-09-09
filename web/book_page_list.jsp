<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>用户列表</title>
</head>
<body>

<h1>显示书本列表</h1>

<c:forEach items="${pageData.list}" var="book">
    <h3>${book}</h3>
</c:forEach>

<h1>[ 当前页：${pageData.pageNum } ] </h1>
<h1>[ 每页记录数：${pageData.pageSize } ] </h1>
<h1>[ 总记录数：${pageData.count } ] </h1>
<h1>[ 总页数：${pageData.pageCount } ] </h1>
<a href="${pageContext.request.contextPath}/checkBook?pageNum=${pageData.pageNum -1}">上一页</a>
<a href="${pageContext.request.contextPath}/checkBook?pageNum=${pageData.pageNum +1}">下一页</a>
</body>
</html>

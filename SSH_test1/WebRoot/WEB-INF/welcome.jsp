<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.row {
	width: 500px;
	height: 30px;
	background-color: green;
	text-align:center;
	margin-top:2px;
	border-radius:6px;
	box-shadow:2px 2px 2px gray
}

.row div {
	float: left;
	width: 120px;
	height:30px;
	line-height:20px;
}
</style>
</head>

<body>

	<c:forEach items="${request.infoes }" var="teacher">
		<div class="row">
			<div>${teacher.tid }</div>
			<div>${teacher.tname }</div>
			<div>${teacher.tage }</div>
		</div>
	</c:forEach>

</body>
</html>

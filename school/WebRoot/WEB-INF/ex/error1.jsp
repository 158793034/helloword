<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isErrorPage="true"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'error1.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#err {
	font-size: 14px; 
	font-weight: bold;
	margin-top:100px;
}

#err_head {
	font-size: 36px;
	font-weight: bold;
	font-family: 黑体;
	color: #66ccaa;
	box-shadow: 6px 6px 6px gray;
	border-radius:6px;
	background-color:#ffffcc;
	line-height:80px;
	
}
#second{
color:red;
font-size:20px;
}
</style>
<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div id="err_head">温馨提示</div>
	<hr>
	<div id="err">
		<%=exception != null ? exception.getMessage():"您所请求的页面页面不存在，请检查操作"%>
		系统将于<span id="second"></span>秒之后<a href="/school/index.jsp">转回主页</a>
	</div>
</body>
<script type="text/javascript">
	(function(){
		var second=6;
		$("").ready(function(){
			
			window.setInterval(function() {
				if(second==0){
					window.location.href="/school/index.jsp";
					return;
				}
				$("#second").html(second--);
				
			}, 1000)
			
		});
	})();
</script>
</html>

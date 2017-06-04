<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE ">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
 
  <c:if test="${param.msgState==0 }">
   <script type="text/javascript">
  window.alert("对不起，您的用户名或密码有误");
  </script>
  </c:if>
  <body>
   <form action="/SSH_test1/app1/act/loginAction_login" method="post">
	 用户名:<input type="text" name="user.logName"><br>
	  密  码:<input type="text" name="user.keyword">
	  <button>login</button>
	</form> <br>
  </body>
</html>

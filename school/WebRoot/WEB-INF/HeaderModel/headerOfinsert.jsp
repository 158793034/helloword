 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
    <base href="<%=basePath%>">
    
    <title>My JSP 'insert_student.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="syscss/insert_update.css">
	<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>
	 <script type="text/javascript" src="/school/sysjs/insertOrUpdate.js"></script>

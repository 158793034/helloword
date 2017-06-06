<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!--  这个是日期格式化标签-->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<base href="<%=basePath%>">

<title>My JSP 'info_student.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">


	<link rel="stylesheet" type="text/css" href="syscss/info.css">
<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/school/sysjs/info.js"></script>
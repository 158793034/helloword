<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>系统登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
   #tb1{
   margin:auto;
   width:500px;
   font-size:13px;
   line-height:50px;
   margin-top:100px;
   border:1px solid #668BB0;
   border-radius:6px
   }
 
   #tb1 td input{
   border-radius:3px;
   border:1px solid black;
   }
</style>
 <script type="text/javascript" src="/school/sysjs/insertOrUpdate.js"></script>
 <script type="text/javascript">
 <c:if test="${requestScope.msg=='no' }">
 alert("您未输入用户名和密码或您的用户名或密码有误");
 </c:if>
 <c:if test="${requestScope.msg=='exit' }">
 alert("用户已经安全退出，如需操作请重新登录");
 </c:if>
 </script>
  </head>
  
  <body>

    <form id="fmt" action="/school/wy/crol/loginAction/login" method="post">
<table border="1" id="tb1" >
<tr >
    <td colspan="2" style="text-align:center;line-height:30px;background-color:#668BB0;color:#ffffff;
    border-radius:0px 0px 9px 9px;
    ">
     <img alt="" src="/school/imgs/icon/Users.gif" >
    系统登陆</td>
 
</tr>

   <tr >
      <td style="border:0px;text-align:right">用户名:</td>
      <td style="border:0px;text-align:left"><input type="text" name="userinfo.logname" placeholder="请输入用户名"  notnull="true" title="用户名"></td> 
   </tr>
  <tr  >
      <td style="border:0px;text-align:right">密&nbsp;&nbsp;码:</td>
      <td style="border:0px"><input type="text" placeholder="请输入密码" name="userinfo.keyword" notnull="true" title="密码"></td> 
   </tr>
   <tr>
   <td colspan="2" style="text-align:center;line-height:20px;background-color:#668BB0;
   border-radius: 9px 9px 0px 0px;
   ">
      <button style="border-radius:3px">
      <img alt="" src="/school/imgs/icon/key_obj.gif">
      登陆</button>
      <button style="border-radius:3px">
       <img alt="" src="/school/imgs/icon/refresh.gif">
      重置</button>
   </td> 
   </tr>
</table>
    
    </form>
  </body>
 
</html>

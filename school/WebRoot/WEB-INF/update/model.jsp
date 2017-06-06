<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 这个是更新页面的模板页 -->
<html>
  <head>
 <%@include file="/WEB-INF/HeaderModel/headerOfinsert.jsp" %>

  </head> 
  <body>
<form id="fmt" action="/school/wy/crol/studentAction/insertOrUpdate" method="post">
    <table  id="table_update" >
    <tr><td >id1:</td><td>
    <c:if test="${false }">
    ${student.stid }<input type="hidden" name="" title="" value="">
    <input type="hidden" name="saveOrUpdate" value="update" notnull="true">
    </c:if>
    <c:if test="${false }">
    <input type="text" name="" title="" >
   <input type="hidden" name="saveOrUpdate" value="insert">
    </c:if>
    </td></tr>
    <tr><td>item2:</td><td><input type="text" name="" title="" value="" ></td></tr>
    <tr><td>item2:</td><td><input type="text" name="" title=" " value=""></td></tr>
    <tr><td>item2:</td><td><input type="text" name="" title=" " value=""></td></tr>
   
  <tr><td colspan="2" style="text-align:center;"><input type="submit" >&nbsp;&nbsp;&nbsp;
  <input type="reset" >
  </td></tr>
    </table></form>  
         
     
  </body>
  
</html>

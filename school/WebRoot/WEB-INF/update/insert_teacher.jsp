<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 这个是更新页面的模板页 -->
<html>
  <head>
 <%@include file="/WEB-INF/HeaderModel/headerOfinsert.jsp" %>

  </head> 
  <body>
<form id="fmt" action="/school/wy/crol/teacherAction/insertOrUpdate" method="post">
    <table  id="table_update" >
    <tr><td >教师编号:</td><td>
    <c:if test="${requestScope.teacher!=null }">
    ${teacher.tid }<input type="hidden" name="teacher.tid" title="教师编号" value="${teacher.tid }" >
    <input type="hidden" name="saveOrUpdate" value="update">
    </c:if>
    <c:if test="${requestScope.teacher==null }">
    <input type="text" name="teacher.tid" title="教师编号"  notnull="true">
   <input type="hidden" name="saveOrUpdate" value="insert">
    </c:if>
    </td></tr>
    <tr><td>教师姓名:</td><td><input type="text" name="teacher.tname" title="教师姓名" value="${teacher.tname }"  notnull="true"></td></tr>
    <tr><td>教师年龄:</td><td><input type="text" name="teacher.tage" title="教师年龄" value="${teacher.tage }"  notnull="true"></td></tr>

   
  <tr><td colspan="2" style="text-align:center;"><input type="submit" >&nbsp;&nbsp;&nbsp;
  <input type="reset" >
  </td></tr>
    </table></form>  
         
     
  </body>
  
</html>

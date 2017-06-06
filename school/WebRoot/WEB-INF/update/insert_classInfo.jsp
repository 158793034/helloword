<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
 <%@include file="/WEB-INF/HeaderModel/headerOfinsert.jsp" %>

  </head> 
  <body>
<form id="fmt" action="/school/wy/crol/classInfoAction/insertOrUpdate" method="post">
    <table  id="table_update" >
    <tr><td>编号:${classinfo.clid }</td><td>
    <c:if test="${requestScope.classinfo!=null }">
   <input type="hidden" name="classinfo.clid" title="班级编号" notnull="true" value="${classinfo.clid }">
    <input type="hidden" name="saveOrUpdate" value="update">
    </c:if>
    <c:if test="${requestScope.classinfo==null }">
    <input type="text" name="classinfo.clid"  title="班级编号" notnull="true" >
   <input type="hidden" name="saveOrUpdate" value="insert">
    </c:if>
    </td></tr>
    <tr><td>班级名称:</td><td><input type="text" name="classinfo.clname" title="班级名称" value="${classinfo.clname }" notnull="true"></td></tr>
    <tr><td>开班日期:</td><td><input type="date" name="classinfo.clbegindate" title="开班日期 " value="${classinfo.clbegindate }" notnull="true">
    <c:if test="${requestScope.classinfo!=null }">
   <fmt:formatDate value="${classinfo.clbegindate }"/>
   </c:if>
    </td></tr>
   
    <tr><td>结课日期:</td><td><input type="date" name="classinfo.clenddate" title="结课日期 " value="${classinfo.clenddate }" notnull="true">
      <c:if test="${requestScope.classinfo!=null }"><fmt:formatDate value="${classinfo.clenddate }"/>
   
   </c:if></td></tr>
   
  <tr><td colspan="2" style="text-align:center;"><input type="submit" >&nbsp;&nbsp;&nbsp;
  <input type="reset" >
  </td></tr>
    </table></form>  
         
     
  </body>
  
</html>

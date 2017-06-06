<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

  <head>
   <%@include file="/WEB-INF/HeaderModel/headerOfinsert.jsp" %>

  </head> 
  <body>
<form id="fmt" action="/school/wy/crol/studentAction/insertOrUpdate" method="post">
    <table  id="table_update" >
    <tr><td >编号:</td><td>
    <c:if test="${requestScope.student!=null }">
    ${student.stid }<input type="hidden" name="student.stid" notnull="true" title="编号" value="${student.stid }">
    <input type="hidden" name="saveOrUpdate" value="update">
    </c:if>
    <c:if test="${requestScope.student==null }">
    <input type="text" name="student.stid" notnull="true" title="编号" ">
   <input type="hidden" name="saveOrUpdate" value="insert">
    </c:if>
    </td></tr>
    <tr><td>姓名:</td><td><input type="text" name="student.stname" notnull="true" title="姓名" " value="${student.stname }"></td></tr>
    <tr><td>性别:</td><td><input type="radio" value="1" name="student.stsex" checked="checked"> 男   <!-- 性别这里采用了复选按钮 默认男性被选中-->
    <input type="radio" value="2" name="student.stsex" ${student.stsex==2? "checked='checked'":"" } >女
   
    </td></tr>   
    <tr><td>生日:</td><td><input type="date" name="student.stbirthday" notnull="true" title="生日" value="${student.stbirthday }"></td></tr>         <!-- 生日这里采用html5中的date即可是实现 -->
    <tr><td>班级:</td><td>
             <select name="student.classinfo.clid">
             
           <c:forEach items="${requestScope.infoes }" var="cl">
           
	<option   value="${cl.clid }"
	${student.classinfo.clid == cl.clid ? "selected='selected'" :""}
	>${cl.clname }</option> 
	</c:forEach>            
             </select></td>
    </tr>
  <tr><td colspan="2" style="text-align:center;"><input type="submit" >&nbsp;&nbsp;&nbsp;
  <input type="reset" >
  </td></tr>
    </table>  </form>  
         
     
  </body>

</html>

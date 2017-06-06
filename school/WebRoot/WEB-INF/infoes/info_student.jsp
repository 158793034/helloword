<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<%@include file="/WEB-INF/HeaderModel/header.jsp" %>

</head>

<body>
   <form action="/school/wy/crol/studentAction/toinsertOrupdateInfo" method="post">
	<div class="bt_insert">
		<button  >添加</button>
	</div></form>
  <form id="fm" action="/school/wy/crol/studentAction/deleteInfo" method="post" onsubmit="return window.confirm('是否确认操作？')">
	<table id="table">
		<thead>
			<tr>
				<td>编号</td>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>所在班级</td>
				<td>课程</td>
				<td><input type="checkbox" id="chooseBt1">
			  
                 <button style="border:0px;margin-left:22px;float:left;background-color:transparent">  <img alt="" src="/school/imgs/icon/rem_all_co.gif"> </button>  </td>
				
			</tr>
		</thead>
		
		<c:forEach items="${infoes }" var="student" varStatus="vst" >
			<tbody>
				<tr>
					<td>${vst.count }</td>
					<td>${student.stid }</td>
					<td >${student.stname }</td>
					<td>${student.stsex==1?"男":"女" }</td>
					<td><fmt:formatDate value="${student.stbirthday }" /></td>
					<td>${student.classinfo.clname }</td>
				<form class="fm" action="/school/wy/crol/studentAction/toSubject" method="post" >
				<td><button class="bt" style="width:16px;height:16px;border;border:0px;background-color:transparent"
				name="student.stid" value="${student.stid }">
					<img alt="" src="/school/imgs/icon/taglib.gif">
					</button></td></form>
					<form action="/school/wy/crol/studentAction/deleteInfo" method="post"  onsubmit="return window.confirm('你确认删除么？')">
					
				<td><button class="bu_delete" name="student.stid" value="${student.stid }">删除<div></div></button>
						<!-- 把pageNum传递给action，这样就能让画面停留在当前页面 -->
						<input type="hidden" name="pageNum"
						 value="${requestScope.pageNum }">
						 
			    </form><form action="/school/wy/crol/studentAction/toinsertOrupdateInfo" method="post"><button  name="student.stid" value="${student.stid }">更新</button></form>
						<input type="checkbox" id="quanxuan" name="studentlist.stid" value="${student.stid }">
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</form>
	<!-- *******************底部显示************************ -->
	<form action="/school/wy/crol/studentAction/getInfo" method="post">
	<div id="bu_index">
	<button name="pagenNum" value="1">首页</button>
	<button name="pageNum" value="${requestScope.pageNum-1 }">上一页</button>
	<button name="pageNum" value="${requestScope.pageNum+1 }">下一页</button>
	<button name="pageNum" value="${requestScope.pageCount }">尾页</button>
	</div></form>
	
</body>
<script type="text/javascript">

 
</script>
</html>

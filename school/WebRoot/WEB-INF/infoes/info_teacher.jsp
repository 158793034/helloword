<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 这个是显示页面的模板页 -->
<html>
<head>
<%@include file="/WEB-INF/HeaderModel/header.jsp" %>
<script type="text/javascript" src="/school/sysjs/info.js"></script>
</head>

<body>
   <form action="/school/wy/crol/teacherAction/toinsertOrupdateInfo" method="post">
	<div class="bt_insert">
		<button  >添加</button>
	</div></form>
  <form action="/school/wy/crol/teacherAction/deleteInfo" method="post" onsubmit="return window.confirm('是否确认操作？')">
	<table id="table">
		<thead>
			<tr>
				<td>序号</td>
				<td>教师编号</td>
				<td>教师姓名</td>
				<td>教师年龄</td>
				<td><input type="checkbox" id="chooseBt1">
			  
                 <button style="border:0px;margin-left:22px;float:left;background-color:transparent">  <img alt="" src="/school/imgs/icon/rem_all_co.gif"> </button>  </td>
				
			</tr>
		</thead>
		<c:forEach items="${requestScope.infoes }" var="teacher" begin="1" end="10" varStatus="vt" >
			<tbody>
				<tr>
					<td>${vt.count }</td>
					<td>${teacher.tid }</td>
					<td>${teacher.tname }</td>
					<td>${teacher.tage }</td>
					
					<form action="/school/wy/crol/teacherAction/deleteInfo" method="post"  onsubmit="return window.confirm('你确认删除么？')">
					
					
				
						<td><button class="bu_delete" name="teacher.tid" value="${teacher.tid }" >删除<div></div></button>
						<!-- 把pageNum传递给action，这样就能让画面停留在当前页面 -->
						
			    </form><form action="/school/wy/crol/teacherAction/toinsertOrupdateInfo" method="post"><button  name="teacher.tid"  value="${teacher.tid }" >更新</button></form>
						<input type="checkbox" id="quanxuan" name="bach_list.tid" value="${teacher.tid }">
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

</html>

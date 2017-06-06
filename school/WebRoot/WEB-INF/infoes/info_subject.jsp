<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 这个是显示页面的模板页 -->
<html>
<head>
<%@include file="/WEB-INF/HeaderModel/header.jsp" %>
<script type="text/javascript" src="/school/sysjs/info.js"></script>
</head>

<body>
   <form action="" method="post">
	<div class="bt_insert">
		<button  >添加</button>
	</div></form>
  <form action="" method="post" onsubmit="return window.confirm('是否确认操作？')">
	<table id="table">
		<thead>
			<tr>
				<td>序号</td>
				<td>科目编号</td>
				<td>科目名称</td>
				<td><input type="checkbox" id="chooseBt1">
			  
             </td>
				
			</tr>
		</thead>
		<c:forEach items="${infoes }" var="subject" begin="0" end="9" varStatus="vt" >
			<tbody>
				<tr>
					<td>${vt.count }</td>
					<form action="" method="post"  onsubmit="return window.confirm('你确认删除么？')">
					<td>${subject.subid }</td>
					<td>${subject.subname }</td>
				
						<td><button class="bu_delete" name="" value="">删除<div></div></button>
						<!-- 把pageNum传递给action，这样就能让画面停留在当前页面 -->
						
			    </form>
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

</html>

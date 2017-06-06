<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<table id="table">
		<thead>
			<tr>
				<td>序号</td>
				<td>学生证号</td>
				<td>学生姓名</td>
				<td>发证时间</td>
				<td>发证版本</td>
				
				
			</tr>
		</thead>
		<c:forEach items="${infoes }" var="card" begin="0" end="9" varStatus="vt" >
			<tbody>
				<tr>
					<td>${vt.count }</td>
					
					<td>${card.stid }</td>
					<td>${card.student.stname }</td>
				    <td><fm:formatDate value="${card.carddate }"/></td>
				    <td>${card.cardbg }</td>
						
				</tr>
			</tbody>
		</c:forEach>
		
	</table>
	
	<!-- *******************底部显示************************ -->
	<form action="/school/wy/crol/studentCardAction/getInfo" method="post">
	<div id="bu_index">
	<button name="pagenNum" value="1">首页</button>
	<button name="pageNum" value="${requestScope.pageNum-1 }">上一页</button>
	<button name="pageNum" value="${requestScope.pageNum+1 }">下一页</button>
	<button name="pageNum" value="${requestScope.pageCount }">尾页</button>
	</div></form>
	
</body>

</html>

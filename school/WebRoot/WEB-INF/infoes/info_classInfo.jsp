<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<%@include file="/WEB-INF/HeaderModel/header.jsp" %>
<script type="text/javascript" src="/school/sysjs/info.js"></script>
</head>

<body>
   <form action="/school/wy/crol/classInfoAction/toinsertOrupdateInfo" method="post">
	<div class="bt_insert">
		<button  >添加</button>
	</div></form>
  <form action="/school/wy/crol/classInfoAction/deleteInfo" method="post" onsubmit="return window.confirm('是否确认操作？')">
	<table id="table">
		<thead>
			<tr>
				<td>编号</td>
				<td>班号</td>
				<td>班名</td>
				<td>开班日期</td>
				<td>结课日期</td>
		
				<td><input type="checkbox" id="chooseBt1" style="right:5px">
			  
                 <button style="border:0px;margin-left:22px;float:left;background-color:transparent">  <img alt="" src="/school/imgs/icon/rem_all_co.gif"> </button>  </td>
				
			</tr>
		</thead>
		<c:forEach items="${requestScope.infoes }" var="classinfo" begin="0" end="9"  varStatus="vt" >
			<tbody>
				<tr>
					<td>${vt.count }</td>
					<td>${classinfo.clid }</td>
					<td>${classinfo.clname }</td>
					
					<td><fmt:formatDate value="${classinfo.clbegindate }"/></td>
					<td><fmt:formatDate value="${classinfo.clenddate }"/></td>
					
					<form action="/school/wy/crol/classInfoAction/deleteInfo" method="post"  onsubmit="return window.confirm('你确认删除么？')">
					
				
						<td><button class="bu_delete" name="classinfo.clid" value="${classinfo.clid }" >删除</button>
						<!-- 把pageNum传递给action，这样就能让画面停留在当前页面 -->
						
			    </form><form action="/school/wy/crol/classInfoAction/toinsertOrupdateInfo" method="post"><button name="classinfo.clid" value="${classinfo.clid }">更新</button></form>
							<input type="checkbox" id="quanxuan" name="bach_list.clid" value="${classinfo.clid }" style="margin-right:10px;">
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

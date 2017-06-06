<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<meta charset="utf-8">
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/school/syscss/main.css">
<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>


</head>

<body>

	<table id="container">
   
		<tr>
		
			<td rowspan="2" class="lift">

				<div id="logo1"></div>
				<div class="menu" role="msg">
					<div class="menu_head">信息管理</div>
					<form action="" method="post" target="showArea">   <!-- 为了让表单的结果在本页面显示，需要把target设置成本页面的区域名字 -->
					<button url="/school/wy/crol/teacherAction/getInfo">
						<div class="bage1"></div>
						讲师信息
					</button >
					<button url="/school/wy/crol/classInfoAction/getInfo">
						<div class="bage1" style="background-position:-116px -152px"></div>
						班级信息
					</button>
					<button url="/school/wy/crol/studentAction/getInfo">
						<div class="bage1" style="background-position:-146px -190px"></div>
						学生信息
					</button>
					<button url="/school/wy/crol/subjectAction/getInfo">
						<div class="bage1"></div>
						科目信息
					</button>
					<button url="/school/wy/crol/studentCardAction/getInfo">
						<div class="bage1"></div>
						证件信息
					</button>
					
					<input type="hidden" value="1" name="pageNum">
					</form>
				</div>
				<div class="menu"  role="logout">
				
				<form action="/school/wy/crol/loginAction/logout" method="post">
				<div class="menu_head">其他</div>
				<button  >
						<img alt="" src="/school/imgs/icon/connect_disconnected.gif" style=" float:left;width:20px;margin-top:6px">
						安全退出
						
					</button>
					
				</form>
				</div>
			</td>
			
			
			<td style="height:120px">
				<div class="logotext">学校信息管理系统</div>
			</td>
			
			
		</tr>

		<tr>
			<td id="border" style="background-color:#ffffff;border-radius:0px 6px 6px 0px;">
			<iframe name="showArea" style="width:860px;height:430px;border:0px;" 
			
			 ></iframe>
			
			</td>
		</tr>


	</table>

	<script type="text/javascript">
		(function() {
			$("").ready(function() {
				$("[role='msg'] button").click(function(){      //添加点击事件
					$(this).parents("form").attr("action",$(this).attr("url"));//给上一级的form表单的action属性赋上url的值
				});
			});
		})();
	</script>
</html>

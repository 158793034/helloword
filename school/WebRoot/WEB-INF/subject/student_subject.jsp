<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 这个是显示页面的模板页 -->
<html>
<head>
<%@include file="/WEB-INF/HeaderModel/header.jsp" %>
<script type="text/javascript" src="/school/sysjs/info.js"></script>
<style type="text/css">
body{
font-size:13px;
margin-top:20px;
}

#dv1,#dv2{
width:300px;
float:left;
margin:10px;
border:0px solid red;
height:190px;
overflow:auto;  /* 添加滚动条 */
}
#dv1{
margin-left:100;
text-align:right;

}

#dv1 div,#dv2 div{
width:90%;
line-height:30px;
padding-left:10px;
font-size:13px;
margin:10px;
}
#dv2{

border:3px double #226699;
width:230px;
border-radius:6px;
box-shadow:0px 3px 6px black;   /*  添加阴影  */
text-align:left
}
#dv2 h3{
background-color:#226699;
color:#ffffff;
line-height:40px;
margin-top:0px;

}
#dv1 div button{
 float:right;
 background-color:transparent;border:0px;margin-top:5px
}
#dv2 div button{
float:left;
background-color:transparent;border:0px;margin-top:5px
}
#dv1 div:BEFORE{
content: url("/school/imgs/icon/ctxhelp_cls.gif");  
}
#dv2 div:AFTER{
content: url("/school/imgs/icon/ctxhelp_opn.gif");
}
</style>
</head>

<body>
     学生姓名:${student.stname }
     &nbsp;&nbsp;&nbsp;
   所在班级:${student.classinfo.clname }
  
    <div style="float:right;margin-top:-6px;border:1px" >
     <button id="bt_sub" style="border-radius:4px;font-size:10px;margin-left:-70px">
  <img alt="" src="/school/imgs/icon/P_Save_Md_N.png"> 保存
  </button>
 <form action="/school/wy/crol/studentAction/toSubject" method="post"  >
  <button  style="border-radius:4px;font-size:10px;margin-top:-24" name="student.stid" value="${student.stid }">
   <img alt="" src="/school/imgs/icon/refresh.gif"> 重置
  </button>
 </form>
 
    
 
  
   
  </div>
<hr>
  <div id="dv1">

  <h3>系统课程</h3>
   <c:forEach items="${subjects_all }" var="subject">
   
    <div>${subject.subname }
    <button type="button" >
      <img alt="" src="/school/imgs/icon/go_1.gif">
       <input type="hidden" name="sub_infoes.subid" value="${subject.subid }">
    </button>
  
  </div>
  
  </c:forEach>
  </div>
  
  <form id="fm_sub" action="/school/wy/crol/studentAction/updateSubjectOfStudent" method="post">
  <div id="dv2">
  
  <input type="hidden" name="student.stid" value="${student.stid }">
  <h3 style="text-align:center">已选课程</h3>
  
   <c:forEach items="${subjects_now }" var="studentAndSubject">
<div>
    <button type="button"  >
      <img alt="" src="/school/imgs/icon/go_2.gif">
        <input type="hidden" name="sub_infoes.subid" value="${studentAndSubject.id.subjectinfo.subid }">
    </button>${studentAndSubject.id.subjectinfo.subname }
   
    <!-- 这里的按钮时不能提交数据的，必须通过隐藏来提交信息 -->
 

  </div>
   </c:forEach>
   
   </div>
 </form>
   
  <hr style="clear:both;margin-top:280px;">
<pre style="font-size:13px;color:red;line-height:20px">
操作说明:1、单击向左或向右的箭头按钮实现课程的调整。
        2、点击保存，提交操作，确认选课内容。
        3、在没有提交操作之前,可以点击重置取消操作。
</pre>
</body>
<script type="text/javascript">
(function(){
	$("").ready(function(){
		
	/*	$("#dv1 div,#dv2 div").dblclick(function(){  //添加双击事件
			if($(this).parent()[0].id=="dv1"){     //如果它上一个父节点也就是第一个div的id值==dv1,这个时候dv2的层就会增加这个双击的事件
				$(this).children("img").css("float","left");  //如果信息跳转到右边的话，那么箭头应该要显示在左边
				$(this).children("img").attr("src","/school/imgs/icon/go_2.gif");//图片的src属性也要跟着更改
				$("#dv2").append(this);
			}
			else{
				$(this).children("img").css("float","right");  //如果信息跳转到左边的话，那么箭头应该要显示在右边
				$(this).children("img").attr("src","/school/imgs/icon/go_1.gif");//图片的src属性也要跟着更改
				$("#dv1").append(this);
			}
		});*/
		
		$("#dv1 div button,#dv2 div button").click(function(){
			
			if($(this).parent().parent()[0].id=="dv1"){     //如果它上一个父节点也就是第一个div的id值==dv1,这个时候dv2的层就会增加这个双击的事件
				$(this).children("img").css("float","left");  //如果信息跳转到右边的话，那么箭头应该要显示在左边
				$(this).children("img").attr("src","/school/imgs/icon/go_2.gif");//图片的src属性也要跟着更改
				$("#dv2").append($(this).parent());
			}
			else{
				$(this).children("img").css("float","right");  //如果信息跳转到左边的话，那么箭头应该要显示在右边
				$(this).children("img").attr("src","/school/imgs/icon/go_1.gif");//图片的src属性也要跟着更改
				$("#dv1").append($(this).parent());
			}
		});
		
		
		$("#bt_sub").click(function(){
			
			$("#fm_sub")[0].submit();
		});
		
	});
	
})();
</script>
</html>

 
//用于进行非空验证的方法
(function(){
	 $("").ready(function(){
		$("#fmt").submit(function(){
			var ok=true;
			$(this).find("[notnull=true]").each(function(){    //这里采用了自定义便签，便于选取对象
				if(isNull(this)){
					ok=false;
					
				};
			});
			return ok;
		});
		/* 用于进行非空验证的方法*/
		function isNull(ipt){
			$(ipt).next("#check_1").remove();
			if(ipt.value==""){
			  $(ipt).after("<span id='check_1'><img src='/school/imgs/icon/status-redeploy.gif'>"+ipt.title+"不能为空</span>");
			  $(ipt).next("#check_1").css({
				  left:$(ipt).offset().left,
				  top:$(ipt).offset().top	  
			  }).fadeIn(200);  //200毫秒出现
			  
			  $(ipt).next().click(function(){   //获取下一个节点的点击事件
				 $(this).fadeOut(200);  //200毫秒消失
			  });
				return true;
			}
			return false;
		}
		
	 });
	  
  })();
//实现项目的全选和全部不选按钮

(function(){
	$("").ready(function(){
		$(".bu_delete").click(function(){
		
		});
		
		$("#chooseBt1").click(function(){
			$("[id='quanxuan']").prop("checked",this.checked); //实现全选全不选，把全选按钮的属性给所有的checkbox，这里不能用attr
		});
		$("#chooseBt2").click(function(){
			$("[name=studentlist]").each(function(){
				this.checked=!this.checked; //实现反选，每一个按钮的当前选择的相反值给现在选择的属性
			});
		});
	});
  })();
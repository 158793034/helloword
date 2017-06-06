package org.school.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entity.Classinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Lazy(true)
@ParentPackage("struts-default")
@Namespace(value="/wy/crol/classInfoAction")
@Results(value={
		@Result(name="infoes",location="/WEB-INF/infoes/info_classInfo.jsp"),
		@Result(name="insert_or_update",location="/WEB-INF/update/insert_classInfo.jsp")
})
public class ClassInfoAction  extends BaseAction{

	private Classinfo classinfo;
	
	private List<Classinfo>bach_list;
	



	public Classinfo getClassinfo() {
		return classinfo;
	}



	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}



	public List<Classinfo> getBach_list() {
		return bach_list;
	}



	public void setBach_list(List<Classinfo> bach_list) {
		this.bach_list = bach_list;
	}



	@Override
	public String getKey() {
		// TODO 自动生成的方法存根
		return this.getService().CLASSINFO;
	}



	@Override
	public Serializable getEntity() {
		// TODO 自动生成的方法存根
		return this.classinfo;
	}

//******************************************************
	@Action(value="toinsertOrupdateInfo")    //跳转到接口
	public String updateInfo(){
	     
		if(classinfo!=null&&classinfo.getClid()!=null){
			this.classinfo=(Classinfo)getService().getInfoById(getKey(), classinfo.getClid());
		}
		return "insert_or_update";
	}


}

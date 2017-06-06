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

import org.school.hb.entity.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Lazy(true)
@ParentPackage("struts-default")
@Namespace(value="/wy/crol/teacherAction")
@Results(value={
		@Result(name="infoes",location="/WEB-INF/infoes/info_teacher.jsp"),
		@Result(name="insert_or_update",location="/WEB-INF/update/insert_teacher.jsp")
})
public class TeacherAction extends BaseAction {

	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}
    
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	private List<Teacher>bach_list;
	
	public void setBach_list(List<Teacher> bach_list) {
		this.bach_list = bach_list;
	}
	@Override
	public List getBach_list() {
		
		return this.bach_list;
	}
//*********************************************
	@Action(value="toinsertOrupdateInfo")    //跳转到接口
	public String updateInfo(){
		
		
		if(teacher!=null&&teacher.getTid()!=null){   //判断是否是更新操作还是插入操作
			this.teacher=(Teacher)getService().getInfoById(getKey(), teacher.getTid());
			 
		}
	
		return "insert_or_update";
	}
	@Override
	public String getKey() {
	
		return getService().TERCHER;
	}

	

	@Override
	public Serializable getEntity() {
		// TODO 自动生成的方法存根
		return this.teacher;
	}
}

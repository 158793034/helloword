package org.school.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entity.Subjectinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
@Controller
@Lazy(false)
@ParentPackage("struts-default")
@Namespace(value="/wy/crol/subjectAction")   //命名空间这里也可以提取共性
@Results(value={
			@Result(name="infoes",location="/WEB-INF/infoes/info_subject.jsp"),
			@Result(name="insert_or_update",location="/WEB-INF/update/insert_student.jsp"),
			@Result(name="student_subject",location="/WEB-INF/subject/student_subject.jsp")
	})
public class SubjectAction extends BaseAction {
    
	private Subjectinfo subjectinfo;
	
	private List<Subjectinfo>bach_list;
	
	
	
	
	
	
	public void setBach_list(List<Subjectinfo> bach_list) {
		this.bach_list = bach_list;
	}

	public Subjectinfo getSubjectinfo() {
		return subjectinfo;
	}

	public void setSubjectinfo(Subjectinfo subjectinfo) {
		this.subjectinfo = subjectinfo;
	}

	@Override
	public String getKey() {
		// TODO 自动生成的方法存根
		return getService().SUBJECTINFO;
	}

	@Override
	public List getBach_list() {
		// TODO 自动生成的方法存根
		return this.bach_list;
	}

	@Override
	public Serializable getEntity() {
		// TODO 自动生成的方法存根
		return this.subjectinfo;
	}

}

package org.school.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entity.Studentcard;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;





import com.opensymphony.xwork2.ActionContext;


@Controller
@Lazy(true)
@ParentPackage("struts-default")
@Namespace(value="/wy/crol/studentCardAction")
@Results(value={
		@Result(name="infoes",location="/WEB-INF/infoes/info_card.jsp"),
		@Result(name="insert_or_update",location="/WEB-INF/update/insert_student.jsp"),
		@Result(name="student_subject",location="/WEB-INF/subject/student_subject.jsp")
})
public class StudentCardAction extends BaseAction {
     
	private Studentcard studentcard;
	
	
	
	public Studentcard getStudentcard() {
		return studentcard;
	}

	public void setStudentcard(Studentcard studentcard) {
		this.studentcard = studentcard;
	}

	@Override
	public String getKey() {
		// TODO 自动生成的方法存根
		return getService().STUDENTCARD;
	}

	@Override
	public List getBach_list() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Serializable getEntity() {
		// TODO 自动生成的方法存根
		return this.studentcard;
	}

}

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
import org.school.hb.entity.Student;
import org.school.hb.entity.Studentandsubject;
import org.school.hb.entity.Subjectinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Lazy(false)
@ParentPackage("struts-default")
@Namespace(value="/wy/crol/studentAction")   //命名空间这里也可以提取共性
@Results(value={
			@Result(name="infoes",location="/WEB-INF/infoes/info_student.jsp"),
			@Result(name="insert_or_update",location="/WEB-INF/update/insert_student.jsp"),
			@Result(name="student_subject",location="/WEB-INF/subject/student_subject.jsp")
	})
public class StudentAction extends BaseAction {
	

	private Student student;
	
	private List<Subjectinfo>sub_infoes;
	
	private List<Student>studentlist;
   
	
	
	
	
	public List<Subjectinfo> getSub_infoes() {
		return sub_infoes;
	}
	public void setSub_infoes(List<Subjectinfo> sub_infoes) {
		this.sub_infoes = sub_infoes;
	}
	//实现父类的抽象接口
	public List getBach_list() {
		
		return this.studentlist;
	}
    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	public List<Student> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
	/*************重写父类的删除和函数***********/
	@Action(value="deleteInfo")
	public String deleteInfo(){
		if(studentlist!=null&&studentlist.size()>0){
			Student[]sts=new Student[studentlist.size()];
			sts=studentlist.toArray(sts);
			
			this.getService().delete_student_clear(sts);  //如果list不为空就删除list
			
		}else if(getEntity()!=null){
			this.getService().delete_student_clear(this.student);
			
		}
	
		return getInfo();  //删除信息后需要显示，如果直接返回"infoes"的话就没有传递的参数，这个时候直接调用方法，就不用考虑值的问题。
	}
	
	
	@Action(value="toinsertOrupdateInfo")    //跳转到接口
	public String updateInfo(){
		List<Classinfo>infoes=this.getService().getAll(getService().CLASSINFO);//把班级信息传递过去
		Map<String, Object>mp=(Map<String, Object>)ActionContext.getContext().get("request");
		mp.put("infoes", infoes);
		
		if(student!=null&&student.getStid()!=null){   //判断是否是更新操作还是插入操作
			this.student=(Student)getService().getInfoById(getKey(), student.getStid());
			 
		}
	
		return "insert_or_update";
	}
	
	@Action(value="updateSubjectOfStudent")
	
	public String updateSubjectOfStudent(){
	Subjectinfo[] ob=null;
	if(sub_infoes!=null&&sub_infoes.size()>0){
      
		ob=new Subjectinfo[sub_infoes.size()];
		ob=sub_infoes.toArray(ob); //转化为你需要的Subject类型的数组
	}
	boolean ok=  this.getService().subjectUpdate(student, ob);
		return this.toSubject();
	}
	
	/**
	 * 学生选课页面展示
	 * @return
	 */

    @Action(value="toSubject")
	 public String toSubject(){
    	   //把学生信息传递到页面上
    	   this.student=(Student)getService().getInfoById(getKey(), student.getStid());
    	   //把所有的科目列出来供选择
    		List<Subjectinfo>subjects_all=getService().getAll(getService().SUBJECTINFO);
    	
    		//学生当前选修的课程
    		List<Studentandsubject>subjects_now=getService().getSubjectByStudent(student);
          //注意：这里的循环不能用foreach循环，因为里面涉及到了删除操作
    		
    		for(int j=0;j<subjects_now.size();j++){
    			Studentandsubject snow=subjects_now.get(j);
    			for(int i=0;i<subjects_all.size();i++){
        			Subjectinfo subjectinfo=subjects_all.get(i);
    				//如果学生选修的课程和中的课程相同的话，那么在展示总课程的时候就不会把学生选修的课程展示出来
    				if(subjectinfo.getSubid().intValue()==snow.getId().getSubjectinfo().getSubid().intValue())
    					subjects_all.remove(i);
        		}
			}
    	Map mp=(Map	)ActionContext.getContext().get("request");
    	  mp.put("subjects_all", subjects_all) ;
    	  mp.put("subjects_now", subjects_now) ;
    
		 return "student_subject";
	 }
	@Override
	public String getKey() {
		
		return getService().STUDENT;
	}



	@Override
	public Serializable getEntity() {
		
		return this.student;
	}

	
	
	
}

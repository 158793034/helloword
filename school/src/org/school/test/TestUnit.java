package org.school.test;



import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.school.Service.ModelService;
import org.school.hb.entity.Classinfo;
import org.school.hb.entity.Student;
import org.school.hb.entity.Studentandsubject;
import org.school.hb.entity.Subjectinfo;
import org.school.hb.entity.Teacher;
import org.school.hb.entity.Userinfo;
import org.school.interfaces.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestUnit {
	private static ApplicationContext app;
	@BeforeClass
	public static void before(){
		app=new ClassPathXmlApplicationContext("app1.xml");
	}
	@Test
	public void testOfStudent(){
	Dao<Student>dao=(Dao<Student>)app.getBean("studentDao");
//	int ps=	dao.getPageCountByRowCount(6);
//	System.out.println(ps);
		ModelService md=(ModelService)app.getBean("modelService");
		
//		List<Student>infoes=md.getInfoByPageNum(md.STUDENT, 1, 8);
//		for (Student student : infoes) {
//			System.out.println(student);
//		}
		List<Student>students=dao.getAll();
		for (Student student : students) {
		System.out.println(student);
		}
//		 List<Student>student=dao.getInfoesByProperties(1, 6);
//		 for (Student student2 : student) {
//			System.out.println(student2);
//		}
//		Student student=dao.getById(new Integer(1));
//		System.out.println(student);
//		Student st1=dao.getById("st_1");
//		System.out.println(st1.getStname());
//		System.out.println(st1.getStudentcard().getStudent());
	}
    
	
	public void test1() throws SQLException{
	//	Dao<Teacher>dao=(Dao<Teacher>)app.getBean("teacherDao");
//		List<Teacher>teachers=dao.getAll();
//		for (Teacher teacher : teachers) {
//			System.out.println(teacher);
//		}
//		Teacher t=dao.getById(1);
//		System.out.println(t);
		
//	List<Teacher>T=	dao.getInfoesByProperties(Restrictions.like("tname", "%子%"));
//	for (Teacher teacher : T) {
//		System.out.println(teacher);
		
		//测试插入测试
//		Teacher t1 =new Teacher(7,"TM1",31);
//		Teacher t2 =new Teacher(8,"TM2",32);
//		Teacher t3 =new Teacher(9,"TM3",33);
//		Teacher t4 =new Teacher(10,"TM4",34);
//		Teacher t5 =new Teacher(11,"TM5",35);
//		Teacher t5 =new Teacher(12,"TM1",31);
//		dao.execute_delete(t5);
	}
 
	public void testofclass(){
    Student student=new Student();
    student.setStid("st_2");
	}
	
	public void testOfStudentAndSubject(){
		ModelService service=(ModelService)app.getBean("modelService");
		Student stu1=new Student();
		stu1.setStid("st_2");
		List<Studentandsubject>al=service.getSubjectByStudent(stu1);
		for (Studentandsubject studentandsubject : al) {
			System.out.println(studentandsubject.getId().getSubjectinfo().getSubname());
		}
	}

	public void testOfdeleteOfStudent(){
		Student st=new Student();
		st.setStid("st_3");
		ModelService service=(ModelService)app.getBean("modelService");
		service.delete_student_clear(st);
	}
//	@Test
	public void testLoginfo(){
		Userinfo user=new Userinfo("tom", "66666");
		ModelService service=(ModelService)app.getBean("modelService");
		user=service.login(user);
		System.out.println(user.getLogname());
	}
	}


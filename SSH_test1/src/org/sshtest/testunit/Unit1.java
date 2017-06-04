package org.sshtest.testunit;





import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sshtest.dao.TeacherDao;
import org.sshtest.entity.userInfo;
import org.sshtest.service.ModelService;


public class Unit1 {
	private static  ApplicationContext app;
	@BeforeClass
	public static void before(){
		app=new ClassPathXmlApplicationContext("app1.xml");
	}
	@Test
	public void test1(){
		//不要Dao在其他的层次出现，要用service来查询
		ModelService service=(ModelService)app.getBean("modelservice");
		System.out.println(service.getAll("teacherDao"));
		System.out.println(service.login(new userInfo("zhangsan","5555",null)));
	}
}

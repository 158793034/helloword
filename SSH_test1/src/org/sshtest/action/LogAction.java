package org.sshtest.action;

import java.util.List;
import java.util.Map;





import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.sshtest.entity.Teacher;
import org.sshtest.entity.userInfo;
import org.sshtest.service.ModelService;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Lazy(true)  //��ֹ��������ǰʵ��������
@ParentPackage(value="struts-default") //����̳и���
@Namespace(value="/app1/act")
@Results(value={
		@Result(name="login",location="/WEB-INF/welcome.jsp"),
		@Result(name="index",location="/index.jsp",type="redirect",params={"msgState","${msgState}"})
		
})
public class LogAction extends BaseAction{
	
	private userInfo user;
	
	public userInfo getUser() {
		return user;
	}

	public void setUser(userInfo user) {
		this.user = user;
	}
public LogAction() {
	// TODO �Զ����ɵĹ��캯�����
	System.out.println("....action....."+this);
}
@Action(value="loginAction_login")
	public String login(){
		
		userInfo user_log=getService().login(user);
	
		//��ʾ
		if(user_log==null){
			setMsgState(0);
			return "index";
		}
		List<Teacher>infoes=getService().getAll(TEACHER);
		
		Map mp=(Map)ActionContext.getContext().get("request");
		
		mp.put("infoes", infoes);
		return "login";
	}
	
}

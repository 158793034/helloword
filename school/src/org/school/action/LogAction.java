package org.school.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entity.Userinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Lazy(true)
@ParentPackage("struts-default")
@Namespace(value="/wy/crol/loginAction")
@Results(value={
		@Result(name="login",location="/login.jsp"),
		@Result(name="main",location="/WEB-INF/index.jsp")
})
public class LogAction extends BaseAction {
	private Userinfo userinfo;
	

	public Userinfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	@Action(value="login")
	public String login(){
		this.userinfo=getService().login(userinfo);
		if(userinfo!=null){
			ActionContext.getContext().getSession().put("user", userinfo);
			return "main";
		}
		
		ActionContext.getContext().put("msg", "no");
		return "login";
	}
	
	@Action(value="logout")
	public String loginout(){
		//首先在session中获取user信息
	 userinfo=(Userinfo)ActionContext.getContext().getSession().get("user");
	getService().exit(userinfo);
	ActionContext.getContext().put("msg", "exit");
		return "login";
	}
	
	
	@Override
	public String getKey() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List getBach_list() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Serializable getEntity() {
		// TODO 自动生成的方法存根
		return null;
	}

}

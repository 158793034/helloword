package org.sshtest.action;

import javax.annotation.Resource;

import org.sshtest.entity.userInfo;
import org.sshtest.service.ModelService;

public class BaseAction {
	/**
	 * ��ȡ��ʦ��Ϣ���ݿ���ʹ��������Ĺؼ���
	 */
	public static final String TEACHER="teacherDao";
	/**
	 * ��ȡѧ����Ϣ���ݿ���ʹ��������Ĺؼ���
	 */
	public static final String STUDENT="studentDao";
	/**
	 * ��ȡϵͳ���û���Ϣ���ݿ���ʹ��������Ĺؼ���
	 */
	public static final String USERIFO="userifoDao";
	@Resource(name="modelservice")
	private ModelService service;
	private int msgState;
	private String key;
	
	
public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
public ModelService getService() {
		return service;
	}
	public void setService(ModelService service) {
		this.service = service;
	}
	
	public int getMsgState() {
		return msgState;
	}
	public void setMsgState(int msgState) {
		this.msgState = msgState;
	}
}

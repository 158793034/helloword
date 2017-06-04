package org.sshtest.entity;

public class Teacher {
	private Integer tid;
	private String tname;
	private Integer tage;
	public Teacher() {
		// TODO 自动生成的构造函数存根
	}
	
	public Teacher(Integer tid, String tname, Integer tage) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tage = tage;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getTage() {
		return tage;
	}
	public void setTage(Integer tage) {
		this.tage = tage;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tage=" + tage
				+ "]";
	}
	
}

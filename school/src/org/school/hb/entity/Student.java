package org.school.hb.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String stid;
	private Classinfo classinfo;
	private String stname;
	private Date stbirthday;
	private Integer stsex;
	private Studentcard studentcard;
    private int tage;
    
	// Constructors

	public int getTage() {
		return tage;
	}


	public void setTage(int tage) {
		this.tage = tage;
	}


	/** default constructor */
	public Student() {
	}

	
	// Property accessors

	public Student(String stid, Classinfo classinfo, String stname,
			Date stbirthday, Integer stsex, Studentcard studentcard) {
		super();
		this.stid = stid;
		this.classinfo = classinfo;
		this.stname = stname;
		this.stbirthday = stbirthday;
		this.stsex = stsex;
		this.studentcard = studentcard;
	}


	public String getStid() {
		return this.stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public Classinfo getClassinfo() {
		return this.classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public String getStname() {
		return this.stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public Date getStbirthday() {
		return this.stbirthday;
	}

	public void setStbirthday(Date stbirthday) {
		this.stbirthday = stbirthday;
	}

	public Integer getStsex() {
		return this.stsex;
	}

	public void setStsex(Integer stsex) {
		this.stsex = stsex;
	}

	


	public Studentcard getStudentcard() {
		return studentcard;
	}


	public void setStudentcard(Studentcard studentcard) {
		this.studentcard = studentcard;
	}


	@Override
	public String toString() {
		return "Student [stid=" + stid + ", classinfo=" + classinfo
				+ ", stname=" + stname + ", stbirthday=" + stbirthday
				+ ", stsex=" + stsex + "]";
	}



	

	
	

}
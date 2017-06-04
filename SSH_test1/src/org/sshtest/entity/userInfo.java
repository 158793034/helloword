package org.sshtest.entity;

public class userInfo {
	private String logName;
	private String keyword;
	private String userType;
	public userInfo() {
	}
	


	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public userInfo(String logName, String keyword, String userType) {
		super();
		this.logName = logName;
		this.keyword = keyword;
		this.userType = userType;
	}



	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "userInfo [logName=" + logName + ", keyword=" + keyword + "]";
	}
	
}

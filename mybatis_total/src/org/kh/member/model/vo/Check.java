package org.kh.member.model.vo;

public class Check {
	private String chName;
	private String chAddr;
	private String chGender;
	private String chHobby;
	
	public Check() {}
	
	
	public Check(String chName, String chAddr, String chGender, String chHobby) {
		super();
		this.chName = chName;
		this.chAddr = chAddr;
		this.chGender = chGender;
		this.chHobby = chHobby;
	}


	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getChAddr() {
		return chAddr;
	}
	public void setChAddr(String chAddr) {
		this.chAddr = chAddr;
	}
	public String getChGender() {
		return chGender;
	}
	public void setChGender(String chGender) {
		this.chGender = chGender;
	}
	public String getChHobby() {
		return chHobby;
	}
	public void setChHobby(String chHobby) {
		this.chHobby = chHobby;
	}
	
	
}

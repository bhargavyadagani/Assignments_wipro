package com.curd.model;

public class department {
	private int deptId;
	private String deptName;
	private String location;
public department() {
		// TODO Auto-generated constructor stub
	}
		public department(int deptId, String deptName, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + "]";
	}
	
}

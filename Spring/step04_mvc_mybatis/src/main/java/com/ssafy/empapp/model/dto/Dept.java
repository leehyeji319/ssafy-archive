package com.ssafy.empapp.model.dto;

// Model : DTO, DO, VO
public class Dept {

	private int deptno;
	private String dname;
	private String loc;
	
	public Dept() {
		System.out.println("Dept().....");
	}
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		System.out.println("setDeptno");
		this.deptno = deptno;
	}



	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}

package com.ssafy.empapp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Model : DTO, DO, VO

//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dept {

	private int deptno;
	private String dname;
	private String loc;
	
	private List<Emp> emps;  // 1:n

  public Dept(int deptno, String dname, String loc) {
    super();
    this.deptno = deptno;
    this.dname = dname;
    this.loc = loc;
  }
	
	
	
}

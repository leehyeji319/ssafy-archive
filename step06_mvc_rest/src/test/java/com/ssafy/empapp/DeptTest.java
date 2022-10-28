package com.ssafy.empapp;

import org.junit.Test;

import com.ssafy.empapp.model.dto.Dept;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeptTest {

	@Test
	public void buildTest() {
		Dept d = Dept.builder().deptno(100).build();
		log.info(d.toString());
		d = Dept.builder().deptno(100).dname("개발1팀").build();
		log.info(d.toString());
		d= Dept.builder().dname("개발1팀").deptno(100).loc("제주도").build();
	}
}

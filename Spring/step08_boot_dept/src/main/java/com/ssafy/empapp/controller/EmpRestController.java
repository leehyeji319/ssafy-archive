package com.ssafy.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

@RequestMapping("/api/emps")
@RestController
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	@DeleteMapping
	public ResponseEntity<?> deleteEmps(@RequestParam(required = false) int[] empno) {
		if(empno != null) empService.deleteEmps(empno);
		return ResponseEntity.noContent().build();
	}	
	@GetMapping
	public ResponseEntity<List<Emp>> getEmps(@RequestParam(required = false) int deptno) {
		List<Emp> emps = empService.getEmpsByDeptNo(deptno);
		return ResponseEntity.ok().body(emps);
	}	

}

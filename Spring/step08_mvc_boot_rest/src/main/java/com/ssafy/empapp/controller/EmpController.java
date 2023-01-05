package com.ssafy.empapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;


@RequestMapping("/api/emps")
@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping
	protected ResponseEntity<List<Emp>> getEmpList() {
		
		return ResponseEntity.ok(empService.selectEmps());
	}
	
//	@GetMapping("/rest/list.do")
//	protected List<Emp> getEmpRestList() throws Exception {
//		return empService.selectEmps();
//	}
//	
	@GetMapping("/{empno}")
	protected ResponseEntity<Emp> getEmpDetail(@PathVariable int empno) throws Exception {
		
		return ResponseEntity.ok(empService.selectEmp(empno));
	}
	
//	@RequestMapping("/detail_with_emps.do")
//	protected ModelAndView getEmpDetialWith
	
	//등록
	@PostMapping
	protected ResponseEntity<?> register(@RequestBody Emp emp) {
		boolean res = empService.insertEmp(emp);
//		System.out.println(emp.toString());
		
		if (res) {
			return ResponseEntity.created(URI.create("/api/emps/" + emp.getEmpno())).build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	//수정
	@PutMapping("/{empno}")
	protected ResponseEntity<?> modify(@RequestBody Emp emp) {
		Emp emp2 = empService.selectEmp(emp.getEmpno());
		if (emp2 != null) {
			boolean res = empService.modifyEmp(emp);
			if (res) {
				return ResponseEntity.ok(emp);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{empno}")
	protected ResponseEntity<?> remove(@PathVariable int empno) {
		
		Emp emp2 = empService.selectEmp(empno);
		if (emp2 != null) {
			boolean res = empService.deleteEmp(empno);
			if (res) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//dept에서 emp 체크박스로 삭제하기
	@DeleteMapping
	public ResponseEntity<?> deleteEmps(@RequestBody int[] empNos) { //바디로 배열로 받아온다
		
		for (int i = 0; i < empNos.length; i++) {
			int j = empNos[i];
			System.out.println(j);
			Emp emp = empService.selectEmp(j);
			if (emp == null) {
				return ResponseEntity.notFound().build();
			}
			
		}
		
		boolean res = empService.deleteEmps(empNos);
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}	
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model model) {
		System.out.println("exception 발생 : "+e.getMessage());
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
	

}

package com.ssafy.empapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/depts")
//@Controller
@RestController
public class DeptRestController  {

	@Autowired
	private DeptService deptService;
	
//	@ResponseBody
//	@GetMapping
//	protected List<Dept> getDeptList() {
//		return deptService.getDepts(null);
//	}
	
//	@ResponseBody
//	@GetMapping("/{deptno}")
//	protected Dept getDeptDetail(@PathVariable int deptno){		
//		return deptService.getDept(deptno);
//	}
	@ApiOperation("부서목록 데이터를 조회한다") //좀더 디테일하게 하고싶으면
	@GetMapping
	protected ResponseEntity<List<Dept>> getDeptList(@RequestParam(required = false) String dname,
			@RequestParam(required = false) String loc) {
		//직접 맵 만들기
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		if (dname != null) conditions.put("dname", dname);
		if (loc != null) conditions.put("loc", loc);
		return ResponseEntity.ok(deptService.getDepts(conditions));
//		return new ResponseEntity<List<Dept>>(deptService.getDepts(null), HttpStatus.OK);
//		return ResponseEntity.ok().body(deptService.getDepts(null));
	}
	
	@GetMapping("/{deptno}")
	protected ResponseEntity<Dept> getDeptDetail(@PathVariable int deptno){
		Dept dept = deptService.getDept(deptno);
		if(dept != null) {
			return ResponseEntity.ok(dept);
		}else {			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	protected ResponseEntity<?> register(@RequestBody Dept dept)  {
		
		boolean res = deptService.registerDept(dept);
		
		// 4. view page by result
		if(res) {
			return ResponseEntity.created(URI.create("/api/depts/"+dept.getDeptno())).build();
		}else {			
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{deptno}")
	protected ResponseEntity<?> modify(@RequestBody Dept dept) {
		
		Dept dept2 = deptService.getDept(dept.getDeptno());
		if(dept2 != null) {
			boolean res = deptService.modifyDept(dept);
			if(res) {
				return ResponseEntity.ok(dept);
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{deptno}")
	protected ResponseEntity<?> remove(@PathVariable int deptno) {
		
		Dept dept2 = deptService.getDept(deptno);
		if(dept2 != null) {
			boolean res = deptService.deleteDept(deptno);
			if(res) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 검색 조건
//	@GetMapping(params = {"dname","loc"})
//	protected ResponseEntity<List<Dept>> getDeptListByCondition(@RequestParam Map<String,Object> condition){
//		logger.info("getDeptList with params...");
//		List<Dept> depts = deptService.getDepts(condition);
//		return ResponseEntity.ok(depts);
//	}	

	@GetMapping("/{deptno}/emps")
	protected ResponseEntity<Dept> getDeptDetailWithEmps(@PathVariable int deptno) {
		Dept dept = deptService.getDeptWithEmps(deptno);
		if (dept != null) {
			return ResponseEntity.ok(dept);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}

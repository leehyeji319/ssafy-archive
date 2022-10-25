package com.ssafy.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.empapp.model.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/delete.do")
	public String deleteEmps(@RequestParam(required = false) int[] empno) {
		empService.deleteEmps(empno);
		return "redirect:/index.do";

	}
}

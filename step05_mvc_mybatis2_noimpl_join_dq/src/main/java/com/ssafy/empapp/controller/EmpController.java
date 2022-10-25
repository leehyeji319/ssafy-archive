package com.ssafy.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

@RequestMapping("/emp")
@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/list.do")
	protected String getEmpList(Model model) throws Exception {
		List<Emp> emps = empService.selectEmps();
		model.addAttribute("empList", emps);
		
		return "emp/list";
	}
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Emp> getEmpRestList() throws Exception {
		return empService.selectEmps();
	}
	
	@RequestMapping("/detail.do")
	protected ModelAndView getEmpDetail(@RequestParam int empno) throws Exception {
		
		Emp emp = empService.selectEmp(empno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp", emp);
		mav.setViewName("emp/detail_form");
		return mav;
	}
	
//	@RequestMapping("/detail_with_emps.do")
//	protected ModelAndView getEmpDetialWith
	
	//등록
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	protected String register(@RequestParam int empno, @RequestParam String ename, 
			@RequestParam String job, @RequestParam int deptno, Model model) throws Exception {
		boolean res = empService.insertEmp(new Emp(empno, ename, job, deptno));
		
		if (res) {
			return "redirect:/emp/list.do";
		} else {
			model.addAttribute("errorMsg", "등록에 실패하였습니다.");
			return "emp/register_form";
		}
	}
	
	//수정
	@PostMapping("/update.do")
	protected String update(Emp emp, RedirectAttributes rAttributes) throws Exception {
		
		boolean res = empService.updateEmp(emp);
		
		if (res) {
			rAttributes.addFlashAttribute("mgs", "사원 수정에 성공하였습니다.");
		} else {
			rAttributes.addFlashAttribute("msg", "사원 수정에 실패하였습니다.");
		}
		
		return "redirect:/emp/list.do";
	}
	
	@GetMapping("/remove.do")
	protected ModelAndView remove(int empno) throws Exception {
		
		boolean res = empService.deleteEmp(empno);
		
		ModelAndView mav = new ModelAndView();
		
		if (res) {
			mav.addObject("msg", "사원 삭제에 성공하였습니다");
		} else {
			mav.addObject("mgs", "사원 삭제에 실패하였습니다.");
		}
		mav.setView(new InternalResourceView("/emp/list.do"));
		return mav;
	}
	
	
	//dept에서 emp 체크박스로 삭제하기
	@PostMapping("/delete.do")
	public String deleteEmps(@RequestParam(required = false) int[] empno) {
		if(empno != null) empService.deleteEmps(empno);
		return "redirect:/index.do";
	}	
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model model) {
		System.out.println("exception 발생 : "+e.getMessage());
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
	

}

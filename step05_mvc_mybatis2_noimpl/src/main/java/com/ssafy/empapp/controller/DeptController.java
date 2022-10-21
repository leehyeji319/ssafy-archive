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

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;

@RequestMapping("/dept/")
@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("list.do")
	protected String getDeptList(Model model) throws Exception {
		List<Dept> depts = deptService.getDepts();
		model.addAttribute("deptList", depts);
		return "dept/list";
	}
	
	@RequestMapping("rest/list.do")
	@ResponseBody
	protected List<Dept> getDeptRestList() throws Exception {
		return deptService.getDepts();
	}
	
	@RequestMapping("detail.do")
	protected ModelAndView getDeptDetail(@RequestParam int deptno) throws Exception {
		Dept dept = deptService.getDept(deptno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept", dept);
		mav.setViewName("dept/detail_form");
		return mav;
	}
	
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	protected String registerDept(@RequestParam int deptno, @RequestParam String dname, @RequestParam String loc, Model model) throws Exception {
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		
		if(res) {
			return "redirect:/dept/list.do";
		}else {
			model.addAttribute("errorMsg", "등록에 실패하였습니다.");
			return "dept/register_form";
		}
	}
	
//	@PostMapping("modify.do")
//	protected ModelAndView modifyDept(Dept dept) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		
//		boolean res = deptService.modifyDept(dept);
//		if (res) {
//			mav.addObject("msg", "부서 수정에 성공하였습니다.");
//		} else {
//			mav.addObject("msg", "부서 수정에 실패하였습니다.");
//		}
//		
//		mav.setView(new InternalResourceView("/dept/list.do"));
//		return mav;
//	}
	
	@PostMapping("modify.do")
	protected String modifyDept(Dept dept, RedirectAttributes rAttributes) throws Exception {
		boolean res = deptService.modifyDept(dept);
		
		if (res) {
			rAttributes.addFlashAttribute("msg", "부서 수정에 성공하였습니다.");
		} else {
			rAttributes.addFlashAttribute("msg", "부서 수정에 실패하였습니다.");
		}
		
		return "redirect:/dept/list.do";
	}
	
	@GetMapping("remove.do")
	protected ModelAndView removeDept(int deptno) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		boolean res = deptService.deleteDept(deptno);
		if (res) {
			mav.addObject("msg", "부서 삭제에 성공하였습니다.");
		} else {
			mav.addObject("msg", "부서 삭제에 실패하였습니다.");
		}
		
		mav.setView(new InternalResourceView("/dept/list.do"));
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
	
}

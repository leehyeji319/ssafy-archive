package com.ssafy.empapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;

@RequestMapping("/dept")
@Controller
public class DeptController{

	//이렇게 구체적으로 하지말고 이제 di로 관리하잖아!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	private DeptService deptService = new DeptServiceImpl();
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list.do")
	protected String getDeptList(Model model) throws Exception {
		List<Dept> depts = deptService.getDepts();
		model.addAttribute("deptList", depts);
		
		return "dept/list";
	}
	
	@RequestMapping("/detail.do")
	protected ModelAndView getDeptDetail(@RequestParam int deptno) throws Exception {
		
		Dept dept = deptService.getDept(deptno);
		ModelAndView mav = new ModelAndView();
		//modelAndView로 리턴 
		mav.addObject("dept", dept);
		mav.setViewName("dept/detail_form"); //직접 하니까 reolved 들어갈 필요가없다
		return mav;
	}
	
	
	@RequestMapping("/register_form.do")
	protected String registerForm() {
		return "dept/register_form";
	}
	
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	protected String registerDept(@RequestParam int deptno,@RequestParam String dname,@RequestParam String loc, Model model) throws Exception {
	
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		if(res) {
			return "redirect:/dept/list.do";
		}else {
			model.addAttribute("errorMsg", "등록에 실패하였습니다.");
			return "/dept/rigister_form"; //앞에 redirect없으면 forward
		}
	}
	
	@GetMapping("/remove.do")
	protected ModelAndView removeDept(int deptno) throws Exception {
		
		boolean res = deptService.deleteDept(deptno);
		
		ModelAndView mav = new ModelAndView();
		if (res) {
			mav.addObject("mgs", "부서 삭제에 성공하였습니다.");
		} else {
			mav.addObject("msg", "부서 삭제에 실패하였습니다.");
		}
		mav.setView(new InternalResourceView("/dept/list.do")); //직접 뷰를 설정했음
		return mav;
	}
	
	@PostMapping("/modify.do")//requestMapping중에서도 post
	protected ModelAndView modifyDept(Dept dept) throws Exception {
		
		boolean res = deptService.modifyDept(dept);
		

		ModelAndView mav = new ModelAndView();
		if (res) {
			mav.addObject("mgs", "부서 수정에 성공하였습니다.");
		} else {
			mav.addObject("msg", "부서 수정에 실패하였습니다.");
		}
		mav.setView(new InternalResourceView("/dept/list.do")); //직접 뷰를 설정했음
		return mav;
	}
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Dept> getDeptRestList(Model model) throws Exception {
		
		return deptService.getDepts();
	}

}

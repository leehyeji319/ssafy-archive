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
	
	@PostMapping("/modify.do")//requestMapping중에서도 post
	protected String modifyDept(Dept dept, RedirectAttributes rAttributes) throws Exception {
		
		boolean res = deptService.modifyDept(dept);
		
		if (res) {
			//rAttributes.addAttribute("msg","부서수정성공"); //얘는 받아올게 쿼리스트링에 담긴다
			 //FlashScope은 백엔드에서 요청을 보내고 다시 받아올때까지 리퀘스트랑 세션에 담아서 보내주고, 세션에 잇는거 지운다.
			rAttributes.addFlashAttribute("mgs", "부서 수정에 성공하였습니다."); //FlashAttribute 요청을 세션에 담아서 보낸다. 
		} else {
			rAttributes.addFlashAttribute("msg", "부서 수정에 실패하였습니다.");
		}
		//mav.setView(new InternalResourceView("/dept/list.do")); //직접 뷰를 설정했음
		return "redirect:/dept/list.do"; //Redirection은 응답을 보낸단 얘기고 .,,
	}
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Dept> getDeptRestList(Model model) throws Exception {
		
		return deptService.getDepts();
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
	
	
	//controller안거치고 바로 servlet-content에서 오게끔 설정함. view-controller사용
//	@RequestMapping("/register_form.do")
//	protected String registerForm() {
//		return "dept/register_form";
//	}
	
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
	
	
	@ExceptionHandler(Exception.class) //예외를 잡아서 처리하는 마치 catch같은개념
	public String handleException(Exception e, Model model) {
		System.out.println("exception 발생: " + e.getMessage());
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
}

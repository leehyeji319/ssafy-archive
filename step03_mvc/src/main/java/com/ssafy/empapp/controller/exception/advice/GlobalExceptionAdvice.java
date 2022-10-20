package com.ssafy.empapp.controller.exception.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //컴포넌트를 나타낸다. - 컨트롤러를 어드바이스하는
public class GlobalExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception e, Model model) {
		model.addAttribute("errorMsg", e.getMessage());
		return "global_error";
	}
}

package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController //이렇게 하면 @ResponseBody 명시 안해도 자동으로 다 디폴트 된다
@RequestMapping("/admin")
public class AdminUserController {
	
	private MemberService memberService;
	
	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userList() { //뭐가 들어가도 괜찮으니까 ?
		try {
			List<MemberDto> list = memberService.listMember(null); // JSON Array
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) { //url로 받아온 애는 pathvariable
		try {
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null); // JSON Array
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

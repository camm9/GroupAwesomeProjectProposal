package com.csis3275.controller_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_db.User;
//import com.csis3275.securityconfig.LoginSuccessHandler;
import com.csis3275.service_db.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;
	private int State = 0;
	
	@GetMapping("/login/member")
	public String loginMember() {
		State = 0;
		//return "http://localhost:8080/oauth2/authorization/github";
		return "redirect:/oauth2/authorization/github";
		//return "redirect:/member/valida";
	}
	
	@GetMapping("/login/admin")
	public String loginAdmin() {
		State = 1;
		//model.addAttribute("userList", userService.readUsers());
		//return "/admin/index";
		return "redirect:/oauth2/authorization/github";
	}
	
	@GetMapping ("/login/success")
	public String loginSuccess() {
//		if (State == 0) {
//			return "/member/valida";
//		}
//		else if (State == 1) {
//			return "/admin/index";
//		}
		return "/";
	}
}

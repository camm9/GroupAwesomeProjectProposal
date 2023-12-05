package com.csis3275.controller_auth;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_db.User;
import com.csis3275.securityconfig.LoginSuccessHandler;
import com.csis3275.service_db.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;
	private static UserDetails userDetails;
	private static String token_s;
	
	
	public static String getToken_s() {
		return token_s;
	}

	public static void setToken_s(String _token_s) {
		token_s = _token_s;
	}
	
	public static void voidToken_s( ) {
		token_s = null;
	}
	
	public static UserDetails getUserDetails() {
		return userDetails;
	}

	public static void setUserDetails(UserDetails userDetails) {
		AuthController.userDetails = userDetails;
	}
	
	public static void voidUserDetails() {
		AuthController.userDetails = null;
	}

	@GetMapping("/login/member")
	public String loginMember() {
		LoginSuccessHandler.State = 0;
		//return "http://localhost:8080/oauth2/authorization/github";
		return "redirect:/oauth2/authorization/github";
		//return "redirect:/member/valida";
	}
	
	@GetMapping("/login/admin")
	public String loginAdmin() {
		LoginSuccessHandler.State = 1;
		//model.addAttribute("userList", userService.readUsers());
		//return "/admin/index";
		return "redirect:/oauth2/authorization/github";
	}
	
    @GetMapping("/oauth2user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
    

	@GetMapping("/login/redirectmember")
	public String redirectMember() {
		LoginSuccessHandler.State = 0;
		//return "http://localhost:8080/oauth2/authorization/github";
		return "redirect:/member";
		//return "redirect:/member/valida";
	}
	
	@GetMapping("/login/redirectadmin")
	public String redirectAdmin() {
		LoginSuccessHandler.State = 1;
		//model.addAttribute("userList", userService.readUsers());
		//return "/admin/index";
		return "redirect:/admin";
	}

}

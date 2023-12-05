package com.csis3275.controller_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_db.User;
import com.csis3275.service_db.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login/oauth2/code/github")
	public String deleteUser(@RequestParam("deleteUser") String id) {
		// Delete the student
		//userService.deleteUser(Long.parseLong(id));
		return "redirect:/member";
	}
}

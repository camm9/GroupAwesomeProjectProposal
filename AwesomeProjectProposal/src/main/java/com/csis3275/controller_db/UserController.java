package com.csis3275.controller_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.service_db.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users/list")
	public String listStudents(Model model) {
		model.addAttribute("userList", userService.readUsers());
		return "/users/list";
	}

	@GetMapping("/users/delete")
	public String deleteUser(@RequestParam("deleteUser") String id) {
		// Delete the student
		userService.deleteUser(Long.parseLong(id));
		return "redirect:/users/list";
	}


}

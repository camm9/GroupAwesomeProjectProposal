package com.csis3275.controller_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_db.User;
import com.csis3275.service_db.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/admin")
	public String listStudents(Model model) {
		model.addAttribute("userList", userService.readUsers());
		return "/admin/index";
	}
	
	@GetMapping("/admin/add")
	public String addStudentAdmin() {
		return "/admin/addadmin";
	}

	@GetMapping("/users/delete")
	public String deleteUser(@RequestParam("deleteUser") String id) {
		// Delete the student
		userService.deleteUser(Long.parseLong(id));
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/saveadmin")
	public String renderSaveMember(User newAdmin) {
		//Create Admin
		
		userService.saveUser(newAdmin);
		return "redirect:/admin";
	}


}

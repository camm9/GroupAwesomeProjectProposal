package com.csis3275.controller_db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_db.User;
import com.csis3275.service_db.UserService;

@Controller
public class EditUserController {
	@Autowired
	private UserService userService;
	
	public List<User> selectedUser;
	
	@GetMapping("/users/editUser")
	public String pageLoad(@RequestParam("id") String id, Model model) {
		Long selectedID = Long.parseLong(id);
		User selectedUser = userService.findUser(selectedID);
		model.addAttribute("selected", selectedUser);
		return "users/editForm";
	}
	
	@PostMapping("/editFormPost")
	public String editStudent(@ModelAttribute User userData, Model model) 
	{
		userService.updateStudent(userData);
		return "redirect:/users/list";
	}
}

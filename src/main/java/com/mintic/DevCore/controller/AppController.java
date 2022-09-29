package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaces.IEmployee;
import com.mintic.DevCore.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AppController {

	@Autowired
	private IEmployee userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new Employee());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(Employee user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<Employee> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

	@GetMapping("/home")
	public String home(Authentication auth, HttpSession session) {
		String username = auth.getName();
		if (session.getAttribute("usuario") == null) {
			Employee user = userRepo.findByEmail(username);
			user.setPassword(null);
			session.setAttribute("usuario", user);
		}
		return "home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Employee());
		return "login";
	}


	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}

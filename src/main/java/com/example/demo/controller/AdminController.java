package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entites.Admin;
import com.example.demo.repos.AdminRepo;

@Controller
public class AdminController {

	@Autowired
	private AdminRepo repo;
	
	@GetMapping("/admin")
	public String loginPage()
	{
		return "login";
	}
	@GetMapping("/register")
	public String registerPage()
	{
		return "register";
	}
	@PostMapping("/register")
	public String register(Admin admin,Model model)
	{
		if(repo.findByUsername(admin.getUsername())!=null)
		{
			model.addAttribute("msg","username Already Exits");
			return "register";
		}
		repo.save(admin);
		return "redirect:/admin";
	}
	
	@PostMapping("/login")
	public String login(String username,String password,Model model)
	{
		Admin admin = repo.findByUsername(username);
		if(admin !=null && admin.getPassword().equals(password))
		{
			return "home";
		}
		model.addAttribute("msg","Invalid Username or Password");
		return "login";
	}
	
}

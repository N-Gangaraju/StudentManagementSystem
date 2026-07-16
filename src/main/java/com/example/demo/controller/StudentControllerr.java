package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entites.Student;
import com.example.demo.repos.studentRepo;
@Controller
public class StudentControllerr {

	@Autowired
	private studentRepo repo;
	@GetMapping("/student")
	public String studetnpage()
	{
		return "studentHome";
	}
	@PostMapping("/student")
	public String viewStudent(@RequestParam int id,Model model)
	{
		Student std=repo.findById(id).orElse(null);
			if(std == null)
		    {
		        model.addAttribute("msg","❌ Student ID not found");
		    }
		    else
		    {
		        model.addAttribute("student",std);
		    }
		
		return "studentHome";
	}
}

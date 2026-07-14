package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class stdController {
	
	@Autowired
	private studentRepo repo;
	@GetMapping("/")
	public String index() {
	    return "index";
	}
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	@GetMapping("/insert")
	public String insertPage()
	{
		return"insert";
	}
	@PostMapping("/insert")
	public String insert(@ModelAttribute Student std)
	{
		repo.save(std);
		return"redirect:/read";
	}
	@GetMapping("/read")
	public String read(Model model)
	{
		model.addAttribute("students",repo.findAll());
		return "read";
	}
	@GetMapping("/update")
	public String update()
	{
		return "update";
	}
	@PostMapping("/update")
	public String updatePage(@ModelAttribute Student std)
	{
		if(repo.existsById(std.getId()))
		{
			repo.save(std);
		}
		
		return "redirect:/read";
	}
	@GetMapping("/delete")
	public String deletePage()
	{
		return "delete";
	}
	@PostMapping("/delete")
	public String delete(@ModelAttribute Student std)
	{
		if(repo.existsById(std.getId()))
		{
			repo.deleteById(std.getId());
		}
		return "redirect:/read";
	}
	

}

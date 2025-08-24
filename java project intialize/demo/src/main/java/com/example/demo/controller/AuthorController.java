package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AuthorService;


@Controller
public class AuthorController {
  private AuthorService authorservice;
  
  public AuthorController(AuthorService authorservice) {
	// TODO Auto-generated constructor stub
	  this.authorservice = authorservice;
  }
  
  @RequestMapping("/Authors")
  private String getAuthor(Model model) {
	  model.addAttribute("Authors",authorservice.findAll());
	  
	  return "Authors";
  }
  
}

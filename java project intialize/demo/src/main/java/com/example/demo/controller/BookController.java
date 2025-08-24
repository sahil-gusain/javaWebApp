package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BookService;

@Controller
public class BookController {
  private final BookService bookservice;
  
  public BookController(BookService bookService) {
	  this.bookservice= bookService;
  }
  @RequestMapping("/Books")
  public String getBooks(Model model) {
	  model.addAttribute("books", bookservice.findAll());
	  
	  return "books";
  }
  
  
}

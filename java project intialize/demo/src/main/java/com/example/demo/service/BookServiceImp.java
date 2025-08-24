package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
@Service
public class BookServiceImp implements BookService {
	
	private  final BookRepository bookrepository;
	
	public BookServiceImp(BookRepository bookrepository) {
		this.bookrepository =bookrepository;
	}
	
	
	@Override
	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return bookrepository.findAll();
	}

}

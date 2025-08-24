package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Author;
import com.example.demo.repository.AuthorRepository;
@Service
public class AuthorServiceImp implements AuthorService {

	private AuthorRepository authorrepository;
	
	public AuthorServiceImp(AuthorRepository authorrepository) {
		// TODO Auto-generated constructor stub
		this.authorrepository=authorrepository;
	}
	
	@Override
	public Iterable<Author> findAll() {
		// TODO Auto-generated method stub
		return authorrepository.findAll();
	}

}

package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{

}

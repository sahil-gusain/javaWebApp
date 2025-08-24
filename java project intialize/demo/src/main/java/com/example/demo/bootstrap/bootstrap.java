package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;


@Component
public class bootstrap implements CommandLineRunner{
    public final AuthorRepository authorRepository;
    
    public final BookRepository bookRepository;
    
    public final PublisherRepository publisherRepository;
    
    public bootstrap(AuthorRepository authorRepository,BookRepository bookRepository,PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;	
		this.publisherRepository = publisherRepository;
    }
	
	@Override
    public void run(String... args) throws Exception {
    	// TODO Auto-generated method stub
    	Author Sahil =new Author();
    	Sahil.setFirstname("sahil");
    	Sahil.setLastname("gusain");
    	
    	
    	Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");
        
        Publisher penguin = new Publisher();
        
        penguin.setPublisher_name("Penguin");
        penguin.setAddress("100");
        penguin.setCity("New York");
        penguin.setState("New York");
        penguin.setZipcode(10003);
        Author saveSahil = authorRepository.save(Sahil);
        Book saveEJB =bookRepository.save(noEJB);
        Publisher savePenguin =  publisherRepository.save(penguin);;
        
        saveSahil.getBooks().add(saveEJB);
        saveEJB.getAuthors().add(saveSahil);
        
        saveEJB.setPublisher(savePenguin);
        savePenguin.getBooks().add(saveEJB);
        
        authorRepository.save(saveSahil);
        bookRepository.save(saveEJB);
        publisherRepository.save(savePenguin);
       
        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}

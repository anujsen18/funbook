package com.funbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.funbook.beans.Book;
import com.funbook.dao.BookRepository;


@RestController
@RequestMapping("/api/books")
public class RestLibraryController {

	    @Autowired
	    private BookRepository bookRepository;


	 
	    @Value("${spring.application.name}")
	    String appName;

	 /**
	  * Rest Api for Finding all books
	  * @return
	  */
    
	    @GetMapping
	    public Iterable<Book> findAll() {
	        return bookRepository.findAll();
	    }

	    
	    /**
	     * Rest Api for creating Book record entry in persist store 
	     * @param book
	     * @return
	     */
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Book create(@RequestBody Book book) {
	        Book book1 = bookRepository.save(book);
	        return book1;
	    }
	    
	    /**
	     * Rest Api to find data by title 
	     * @param title
	     * @return json responce of searched string 
	     */
	    
	    @GetMapping("/{title}")
	    public List<Book> findByTitle(@PathVariable String  title) {
	        return bookRepository.findByTitleContaining(title);
	         
	    }
	    

}
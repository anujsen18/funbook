package com.funbook.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.funbook.beans.Book;
import com.funbook.dao.BookRepository;


@Controller
public class LibraryController {

	    @Autowired
	    private BookRepository bookRepository;


	 
	     @Value("${spring.application.name}")
	    String appName;

	 /**
	  * Request mapping for fetch all book 
	  * @param model
	  * @return
	  */

	@RequestMapping(path = "/", method = RequestMethod.GET)
	    public String getAllBooks(Model model) {
		 // loadDummyBooks();
	        model.addAttribute("books", bookRepository.findAll());
	        model.addAttribute("book", new Book());
	        return "librarydsply";
	    }
	
	
	 /**
	   * Controller Mapping for searching   book by title 
	   * @param model
	   * @param book
	   * @return
	   */

		   
		 @RequestMapping(path = "/book/getbookedit/", method = RequestMethod.GET)
		    public String getaddBook(Model model ,@ModelAttribute Book book) {
			     model.addAttribute("book", new Book());
			     
			     return "addabook";
		    }
	
		 
		 /**
		   * Controller Mapping for searching   book by title 
		   * @param model
		   * @param book
		   * @return
		   */

			   
			 @RequestMapping(path = "/book/addbook/", method = RequestMethod.POST)
			    public String saveBook(@Valid @ModelAttribute("book")  Book book , BindingResult result,Model model ) {
				   
				     bookRepository.save(book);
				     if(result.hasErrors()){
				           List<FieldError> err=result.getFieldErrors();

				           for(FieldError e:err){
				             
				           }
				           return "addabook";
				        }
				       
				     return "redirect:/";
			    }
	
	/**
   * Controller Mapping for searching   book by title 
   * @param model
   * @param book
   * @return
   */

	   
	 @RequestMapping(path = "/book/getbytitle/", method = RequestMethod.POST)
	    public String searchByTitle(Model model ,@ModelAttribute Book book) {
		     model.addAttribute("books", bookRepository.findByTitleContaining(book.getTitle()));
		     
		     return "librarydsply";
	    }
	   
	 
	 /**
	  * Controller Mapping for delete the book by id 
	  * @param id
	  * @return
	  */
	   @RequestMapping(path = "/book/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable(name = "id") long id) {
		   
		   System.out.println("deleting "+id);
		   bookRepository.delete(id);
		  
	        return "redirect:/";
	    }
	   

	   private void loadDummyBooks() {
			Book b = new Book();
			Book b2 = new Book();
			Book b3 = new Book();
			b.setAuthor("J. K. Rowling");	b.setTitle("Harry Potter");	 b.setPrice(200.0);	 
			b2.setAuthor("A P J Kalam");	b2.setTitle("Wings of Fire");	 b2.setPrice(500.0);	 
			b3.setAuthor("A P J Kalam");	b3.setTitle("Ignited mind");	 b3.setPrice(600.0);	
			System.out.println("adding books ......");
			bookRepository.save(b);
			bookRepository.save(b2);
			bookRepository.save(b3); 
		}
	   
	   

//		@RequestMapping(path = "/error")
//		    public String handleError() {
//		        return "error";
//		    }
	   
	
}
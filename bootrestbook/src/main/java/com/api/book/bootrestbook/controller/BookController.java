package com.api.book.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.entities.dao.BookRepository;

@RestController
public class BookController 
{
	@Autowired
	BookRepository br;
	
	@PostMapping("/addbook")
	public String addBook(@RequestBody Book s)
	{
		br.save(s);
		return "Data Save";
	}
	@GetMapping("/getbookbyid")
	public Optional<Book> getBookById(@RequestParam int id)
	{
		Optional<Book> b=br.findById(id);
		return b;
	}
	@GetMapping("/all")
	public List<Book> getAllBooks()
	{
		List<Book>l=br.findAll();
		return l;
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		Optional<Book> o=br.findById(id);
		if (o.isPresent()) 
		{
//			sr.deleteById(id);
//			return "Data Deleted Successfully";
			Book s=o.get();
			br.delete(s);
			return "Data Deleted Successfully";
		}
			return "Data Not Found To Delete";
	
	}
	
}

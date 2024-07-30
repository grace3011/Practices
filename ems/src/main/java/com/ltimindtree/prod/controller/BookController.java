package com.ltimindtree.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltimindtree.prod.entity.Book;
import com.ltimindtree.prod.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        //TODO: process POST request
 
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Book> getBookById(Integer id){
        return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
    }
   
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updatebook(@PathVariable Integer id,@RequestBody Book details ) {
        return new ResponseEntity<>(bookService.updatebook(id, details),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteId(Integer id){
        bookService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}

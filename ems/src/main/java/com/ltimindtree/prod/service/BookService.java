package com.ltimindtree.prod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.prod.Respository.Bookrespository;
import com.ltimindtree.prod.entity.Book;

@Service
public class BookService {
    
    @Autowired
    private Bookrespository bookrespository;

    public Book addBook(Book book){
        return bookrespository.save(book);
    }
    public Book getBookById(Integer id){
        return bookrespository.findById(id).orElse(null);
    }
    public List<Book> getAllBooks(){
        return bookrespository.findAll();
    }

    public Book updatebook(Integer id, Book details){
        return bookrespository.save(details);

    }
    public void deleteId(Integer id){
        bookrespository.deleteById(id);
    }
}

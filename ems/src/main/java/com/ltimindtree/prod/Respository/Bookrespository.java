package com.ltimindtree.prod.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.prod.entity.Book;

@Repository
public interface Bookrespository extends JpaRepository<Book,Integer> {
    
}

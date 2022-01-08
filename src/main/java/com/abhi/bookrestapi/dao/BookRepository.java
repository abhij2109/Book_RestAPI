package com.abhi.bookrestapi.dao;

import com.abhi.bookrestapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findById(int id);
}

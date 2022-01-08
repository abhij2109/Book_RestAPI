package com.abhi.bookrestapi.controllers;

import com.abhi.bookrestapi.entities.Book;
import com.abhi.bookrestapi.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping(value="/books")
    public List<Book> getBooks(){
        return this.bookServices.getAllBooks();
    }

    @GetMapping(value="/books/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return this.bookServices.getBookById(id);
    }

    @PostMapping(value="/books")
    public Book addBook(@RequestBody Book book)
    {
        Book b=this.bookServices.addBook(book);
        return b;
    }

    @DeleteMapping(value="/books/{id}")
    public void deleteBook(@PathVariable int id){
        this.bookServices.deleteBookById(id);
    }

    @PutMapping(value="books/{id}")
    public Book updateBook(@RequestBody Book book,
                           @PathVariable int id){
        this.bookServices.updateBookById(book,id);
        return book;
    }
}

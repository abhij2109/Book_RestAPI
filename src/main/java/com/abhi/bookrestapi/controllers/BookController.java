package com.abhi.bookrestapi.controllers;

import com.abhi.bookrestapi.entities.Book;
import com.abhi.bookrestapi.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping(value="/books")
    public ResponseEntity<List<Book>> getBooks(){

        List<Book> list=bookServices.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping(value="/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){

        Book book=bookServices.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping(value="/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book b=null;
        try{
            b=this.bookServices.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception E)
        {
            E.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value="/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        try {
            this.bookServices.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception E){
            E.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value="books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,
                           @PathVariable int id){
        try {
            this.bookServices.updateBookById(book, id);
            return ResponseEntity.ok().body(book);
        }
        catch (Exception E){
            E.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

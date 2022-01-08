package com.abhi.bookrestapi.services;

import com.abhi.bookrestapi.dao.BookRepository;
import com.abhi.bookrestapi.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> books=(List<Book>) bookRepository.findAll();
        return books;
    }

    public Book getBookById(int id){
        Book b=null;
        try{
            b=this.bookRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public Book addBook(Book b){
        Book result=bookRepository.save(b);
        return result;
    }

    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }

    public void updateBookById(Book book,int id){
        book.setId(id);
        bookRepository.save(book);
    }
}











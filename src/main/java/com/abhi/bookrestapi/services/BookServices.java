package com.abhi.bookrestapi.services;

import com.abhi.bookrestapi.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServices {

    private static List<Book> books=new ArrayList<>();
    static{
        books.add(new Book(10,"Java Applications","JK Rowling"));
        books.add(new Book(11,"Let us Java","Yashwant Kanetkar"));
        books.add(new Book(12,"Core Java","Rawalpindi"));
        books.add(new Book(13,"Advanced Java","LalitRaja"));
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id){
        Book book=null;
        try {
            book = books.stream().filter(e -> e.getId() == id).findFirst().get();
        }
        catch (Exception E){
            E.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b){
        books.add(b);
        return b;
    }

    public void deleteBookById(int id){
        books=books.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
    }

    public void updateBookById(Book book,int id){
        books=books.stream().map(b->{
            if(b.getId()==id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}


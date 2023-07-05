package com.library.main.controller;


import com.library.main.Entities.Book;
import com.library.main.Service.BookService;
import com.library.main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Restcontroller {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public String registration(@RequestBody Map<String, Object> param){
        String user = userService.registration(param);
        return user;
    }


    @PostMapping("/addBook")
    public void addbook(@RequestBody Map<String, Object> param){
        bookService.addBook(param);
    }
    @GetMapping("/book")
    public List<Book> getAllBook(){
        List<Book> book = bookService.getAllBook();
        return book;
    }
    @PostMapping("/book")
    public Book getBookById(@RequestParam Long id){
         Book book = bookService.getBookById(id);
        return book;
    }
    @PostMapping("/deleteBook")
    public void deleteBook(@RequestParam Long id){
         bookService.deleteBook(id);
    }
}



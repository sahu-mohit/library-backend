package com.library.main.controller;


import com.library.main.Entities.Book;
import com.library.main.Entities.User;
import com.library.main.Service.BookService;
import com.library.main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Restcontroller {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody Map<String, Object> param){
        return userService.registration(param);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> param){
        return userService.login(param);
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addbook(@RequestBody Map<String, Object> param){
        try{
            return (bookService.addBook(param));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/book")
    public Object getAllBook(){
        Object book = bookService.getAllBook();
        try{
            if(book != null){
                return ResponseEntity.of((Optional.of(book)));
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PostMapping("/book")
    public ResponseEntity<Book> getBookById(@RequestParam Long id){
            Book book = bookService.getBookById(id);
            if(book != null) {
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
    }
    @PostMapping("/deleteBook")
    public ResponseEntity<?>deleteBook(@RequestParam Long id){
            return bookService.deleteBook(id);
    }
}



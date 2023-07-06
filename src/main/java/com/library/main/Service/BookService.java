package com.library.main.Service;

import com.library.main.Entities.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookService{
    ResponseEntity<String> addBook(Map<String, Object> param);

    Object getAllBook();

    Book getBookById(Long id);

    ResponseEntity<?> deleteBook(Long id);
}

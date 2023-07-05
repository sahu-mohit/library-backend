package com.library.main.Service;

import com.library.main.Entities.Book;

import java.util.List;
import java.util.Map;

public interface BookService{
    void addBook(Map<String, Object> param);

    List<Book> getAllBook();

    Book getBookById(Long id);

    void deleteBook(Long id);
}

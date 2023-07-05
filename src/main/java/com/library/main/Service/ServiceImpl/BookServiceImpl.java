package com.library.main.Service.ServiceImpl;

import com.library.main.Entities.Book;
import com.library.main.Repository.BookRepo;
import com.library.main.Service.BookService;
import com.library.main.Utility.DataTypeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Override
    public void addBook(Map<String, Object> param) {
        Long id = DataTypeUtility.longvalue(param.get("id"));
        String name = DataTypeUtility.stringvlue(param.get("name"));
        String authorname = DataTypeUtility.stringvlue((param.get("author")));
        Long cellno = DataTypeUtility.longvalue(param.get("cellno"));
        if(id == null || id == 0l){
            Book book = new Book();
            book.setId(id);
            book.setTitle(name);
            book.setAuthor(authorname);
            book.setCellno(cellno);
            bookRepo.save(book);
        }else{
            Book book = bookRepo.findById(id).get();
            if(!name.equals("")){
                book.setTitle(name);
            }
            if(!authorname.equals("")){
                book.setAuthor(authorname);
            }
            if(cellno != null || cellno != 0l)
            {
                book.setCellno(cellno);
            }
            bookRepo.save(book);
        }
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> book = bookRepo.findAll();
        return book;
    }

    @Override
    public Book getBookById(Long id) {
        Book book = new Book();
        try{
        book = bookRepo.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        if(id != 0l || id != null){
            bookRepo.deleteById(id);
        }
    }
}

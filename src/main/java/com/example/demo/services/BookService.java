package com.example.demo.services;
import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public Book saveOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean delete(Integer Id) {

        try {
            bookRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> findAll() { return bookRepository.findAll();
    }
}

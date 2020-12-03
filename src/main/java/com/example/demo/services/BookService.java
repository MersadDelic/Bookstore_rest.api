package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean delete(Long Id) {
        try {
            bookRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long Id) {
        return bookRepository.findById(Id);
    }
}

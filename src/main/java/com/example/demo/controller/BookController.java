package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})

public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> saveOrUpdateBook(
            @RequestBody Book book) {

        return new ResponseEntity<>(
                bookService.saveOrUpdateBook(book),
                HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(
                bookService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {

        Optional<Book> book = bookService.getById(id);
        if (!book.isPresent()) {
            throw new IllegalArgumentException("Ne postoji knjiga sa id: " + id);
        }
        return new ResponseEntity<>(
                bookService.getById(id),
                HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return new ResponseEntity<>(
                bookService.delete(id),
                HttpStatus.OK);
    }
}

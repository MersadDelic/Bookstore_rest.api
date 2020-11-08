package com.example.demo.controller;
import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins =  {"http://localhost:4200", "http://localhost:8080"})

public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book") /*save*/
    public Book createBook(@Valid @RequestBody Book book){
        return bookService.saveOrUpdateBook(book);
    }

    @GetMapping("/book")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(
                bookService.findAll(),
                HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        return new ResponseEntity<Boolean>(
                bookService.delete(id),
                HttpStatus.OK);
    }
}

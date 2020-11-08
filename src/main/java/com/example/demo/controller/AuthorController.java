package com.example.demo.controller;
import com.example.demo.models.Author;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins =  {"http://localhost:4200", "http://localhost:8080"})

public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public ResponseEntity<?> saveOrUpdateAuthor(
            @RequestBody Author author) {

        return new ResponseEntity<Author>(
                authorService.saveOrUpdateAuthor(author),
                HttpStatus.CREATED);

    }

    @GetMapping("/author")
    public ResponseEntity<?> getAlAuthors() {
        return new ResponseEntity<>(
                authorService.findAll(),
                HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        return new ResponseEntity<Boolean>(
                authorService.delete(id),
                HttpStatus.OK);
    }
}

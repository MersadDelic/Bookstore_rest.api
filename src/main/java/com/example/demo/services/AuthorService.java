package com.example.demo.services;

import com.example.demo.models.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveOrUpdateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public boolean delete(Integer Id) {
        try {
            authorRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author>getById(Integer Id) {
        return authorRepository.findById(Id);
    }


}

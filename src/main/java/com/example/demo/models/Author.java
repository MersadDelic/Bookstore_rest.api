package com.example.demo.models;
import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "authors")
public class Author implements Serializable
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 45)
    private String name;

    @Size(max = 45)
    private String address;


    @OneToMany (cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "author")
    private Set<Book> books = new HashSet<>();


    public Author()
    {}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}

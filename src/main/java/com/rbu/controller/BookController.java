package com.rbu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rbu.entity.Book;
import com.rbu.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    // Save Book
    @PostMapping
    public Book save(@RequestBody Book book) {
        return service.save(book);
    }

    // Find By ISBN
    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable String isbn) {
        return service.findByIsbn(isbn);
    }

    // Find All
    @GetMapping
    public List<Book> findAll() {
        return service.findAll();
    }

    // Find By Title
    @GetMapping("/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return service.findByTitle(title);
    }

    // Find By Author
    @GetMapping("/author/{author}")
    public List<Book> findByAuthor(@PathVariable String author) {
        return service.findByAuthor(author);
    }

    // Find By Genre
    @GetMapping("/genre/{genre}")
    public List<Book> findByGenre(@PathVariable String genre) {
        return service.findByGenre(genre);
    }

    // Find By Price Range
    @GetMapping("/price")
    public List<Book> findByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {

        return service.findByPriceRange(min, max);
    }

    // Delete By ISBN
    @DeleteMapping("/{isbn}")
    public String deleteByIsbn(@PathVariable String isbn) {

        service.deleteByIsbn(isbn);

        return "Book Deleted Successfully";
    }
}

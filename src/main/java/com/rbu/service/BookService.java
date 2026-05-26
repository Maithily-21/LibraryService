package com.rbu.service;

import java.util.List;

import com.rbu.entity.Book;

public interface BookService {

    Book save(Book book);

    Book findByIsbn(String isbn);

    List<Book> findAll();

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByPriceRange(double minPrice, double maxPrice);

    void deleteByIsbn(String isbn);
}

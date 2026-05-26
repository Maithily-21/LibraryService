package com.rbu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rbu.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

    Book findByIsbn(String isbn);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    @Query("FROM Book b WHERE b.price BETWEEN :minPrice AND :maxPrice")
    List<Book> findByPriceBetween(@Param("minPrice") double minPrice,
                                  @Param("maxPrice") double maxPrice);

    void deleteByIsbn(String isbn);
}
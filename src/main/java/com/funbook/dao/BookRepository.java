package com.funbook.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.funbook.beans.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByTitleContaining(String title);
}

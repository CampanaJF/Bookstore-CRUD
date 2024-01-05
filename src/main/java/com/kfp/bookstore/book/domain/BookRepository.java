package com.kfp.bookstore.book.domain;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    void save(Book book);

    Book findById(Integer id);
}

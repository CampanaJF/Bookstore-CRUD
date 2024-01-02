package com.kfp.bookstore.book.infrastructure;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import com.kfp.bookstore.book.infrastructure.jpa.BookJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository bookJpaRepository;
    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookJpaRepository.save(book);
    }
}

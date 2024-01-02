package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddBook {

    private final BookRepository bookRepository;
    public void execute(Book book) {

        this.bookRepository.save(book);
    }
}

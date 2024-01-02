package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListBooks {

    private final BookRepository bookRepository;
    public List<Book> execute() {

        return this.bookRepository.findAll();
    }
}

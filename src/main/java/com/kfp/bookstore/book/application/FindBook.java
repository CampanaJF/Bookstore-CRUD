package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindBook {

    private final BookRepository bookRepository;

    public Book execute(Integer bookId){

        return bookRepository.findById(bookId);
    }

}

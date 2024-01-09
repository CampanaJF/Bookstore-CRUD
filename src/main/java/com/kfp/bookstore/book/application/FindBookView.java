package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.BookRepository;
import com.kfp.bookstore.book.domain.BookView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindBookView {

    private final BookRepository bookRepository;

    public BookView execute(Integer bookId) {

        return bookRepository.getBookView(bookId);
    }
}

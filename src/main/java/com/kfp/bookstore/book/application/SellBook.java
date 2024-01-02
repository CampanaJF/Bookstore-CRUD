package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellBook {

    private final BookRepository bookRepository;
}

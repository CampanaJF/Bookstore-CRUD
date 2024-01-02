package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListBestSellers {

    private final BookRepository bookRepository;
}

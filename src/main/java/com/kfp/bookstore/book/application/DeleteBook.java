package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteBook {

    private final BookRepository bookRepository;

    public void execute(Integer bookId){

        Book toDelete = getBook(bookId);

        bookRepository.delete(toDelete);
    }

    private Book getBook(Integer bookId){
        return bookRepository.findById(bookId);
    }
}

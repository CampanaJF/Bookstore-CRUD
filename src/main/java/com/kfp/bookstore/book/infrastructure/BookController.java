package com.kfp.bookstore.book.infrastructure;

import com.kfp.bookstore.book.application.AddBook;
import com.kfp.bookstore.book.application.ListBooks;
import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.infrastructure.record.BookRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final ListBooks listBooks;
    private final AddBook addBook;

    @GetMapping
    ResponseEntity<List<Book>> listBooks(){
        return new ResponseEntity<>(listBooks.execute(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody BookRecord book){
        addBook.execute(book.toBook());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

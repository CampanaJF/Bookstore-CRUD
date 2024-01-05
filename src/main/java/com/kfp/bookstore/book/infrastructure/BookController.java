package com.kfp.bookstore.book.infrastructure;

import com.kfp.bookstore.book.application.AddBook;
import com.kfp.bookstore.book.application.ListBooks;
import com.kfp.bookstore.book.application.UpdateBook;
import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.exception.BookNotFoundException;
import com.kfp.bookstore.book.infrastructure.record.BookRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final ListBooks listBooks;
    private final AddBook addBook;
    private final UpdateBook updateBook;

    @GetMapping
    ResponseEntity<List<Book>> list(){

        return new ResponseEntity<>(listBooks.execute(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> add(@RequestBody BookRecord book){
        addBook.execute(book.toBook(),book.subjects());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    ResponseEntity<Void> update(
            @PathVariable("bookId") Integer bookId,
            @RequestBody BookRecord book){
        try{
            updateBook.execute(bookId, book.toBook(), book.subjects());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(BookNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "The requested book does not exist", e);
        }
    }

}

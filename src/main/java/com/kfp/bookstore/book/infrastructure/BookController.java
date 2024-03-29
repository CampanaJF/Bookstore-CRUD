package com.kfp.bookstore.book.infrastructure;

import com.kfp.bookstore.book.application.AddBook;
import com.kfp.bookstore.book.application.DeleteBook;
import com.kfp.bookstore.book.application.FindBook;
import com.kfp.bookstore.book.application.FindBookView;
import com.kfp.bookstore.book.application.ListBooks;
import com.kfp.bookstore.book.application.UpdateBook;
import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookView;
import com.kfp.bookstore.book.domain.exception.BookNotFoundException;
import com.kfp.bookstore.book.domain.exception.InvalidInputException;
import com.kfp.bookstore.book.infrastructure.record.BookRecord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Tag(name = "bookstore")
@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final ListBooks listBooks;
    private final AddBook addBook;
    private final UpdateBook updateBook;
    private final FindBook findBook;
    private final DeleteBook deleteBook;
    private final FindBookView findBookView;

    @GetMapping
    ResponseEntity<List<Book>> list(){
        return new ResponseEntity<>(listBooks.execute(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    ResponseEntity<Book> get(
            @PathVariable("bookId") Integer bookId){
        return new ResponseEntity<>(findBook.execute(bookId), HttpStatus.OK);
    }

    @Operation(
            description = "The view/projection of a book, this view only has a single field" +
                    " that hold the title and the name of the author",
            summary =  "gets a book view of a certain book",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping("/view/{bookId}")
    ResponseEntity<BookView> getView(
            @PathVariable("bookId") Integer bookId){
        return new ResponseEntity<>(findBookView.execute(bookId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> add(@RequestBody BookRecord book){
        addBook.execute(book.toBook());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    ResponseEntity<Void> update(
            @PathVariable("bookId") Integer bookId,
            @RequestBody BookRecord book){
        try{
            updateBook.execute(bookId, book.toBook());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(BookNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }catch(InvalidInputException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{bookId}")
    ResponseEntity<Void> delete(
            @PathVariable("bookId") Integer bookId){
        try{
            deleteBook.execute(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(BookNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "The requested book does not exist", e);
        }
    }

}

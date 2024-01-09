package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import com.kfp.bookstore.book.domain.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UpdateBook {

    private final BookRepository bookRepository;
    public void execute(Integer bookId, Book book) {

        book.setInventory(getBook(bookId).getInventory());
        book.setId(bookId);

        bookValidator(book);

        this.bookRepository.save(book);
    }

    private void bookValidator(Book book) {
        validateExistingBook(book.getId());
        validateStrings(book.getAuthor(),book.getTitle(),book.getPublisher());
        validateDate(book.getDateOfPublishing());
    }

    private void validateExistingBook(Integer bookId) {
        if(getBook(bookId)==null){
            throw new InvalidInputException("The book with that id does not exist");
        }
    }

    private void validateStrings(String author, String title, String publisher) {
        if(author.isEmpty() || title.isEmpty() || publisher.isEmpty()){
            throw new InvalidInputException("The data of the book must be valid");
        }
    }

    private void validateDate(Date dateOfPublishing) {
        if(dateOfPublishing==null || dateOfPublishing.after(new Date())){
            throw new InvalidInputException("The date of the book must be valid");
        }
    }

    private Book getBook(Integer bookId){
        return bookRepository.findById(bookId);
    }

}

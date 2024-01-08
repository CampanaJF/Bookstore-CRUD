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

        bookValidator(book);

        Book toUpdate = getBook(bookId);

        toUpdate.setTitle(book.getTitle());
        toUpdate.setAuthor(book.getAuthor());
        toUpdate.setDateOfPublishing(book.getDateOfPublishing());
        toUpdate.setPublisher(book.getPublisher());
        toUpdate.setSubjects(book.getSubjects());

        this.bookRepository.save(toUpdate);
    }

    private void bookValidator(Book book) {
        validateStrings(book.getAuthor(),book.getTitle(),book.getPublisher());
        validateDate(book.getDateOfPublishing());
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

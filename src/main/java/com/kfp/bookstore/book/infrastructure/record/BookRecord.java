package com.kfp.bookstore.book.infrastructure.record;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.subject.domain.Subject;

import java.util.Date;
import java.util.List;

public record BookRecord (
        String title,
        String author,
        String publisher,
        Date dateOfPublishing,
        List<Subject> subjects){

    public Book toBook(){

        Book newBook = Book.builder()
                .title(title)
                .dateOfPublishing(dateOfPublishing)
                .author(author)
                .publisher(publisher)
                .build();

        newBook.setSubjects(subjects);

        return newBook;
    }
}

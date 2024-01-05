package com.kfp.bookstore.book.infrastructure.record;

import com.kfp.bookstore.book.domain.Book;

import java.util.Date;
import java.util.List;

public record BookRecord (
        String title,
        String author,
        String publisher,
        Date dateOfPublishing,
        List<Integer> subjects){

    public Book toBook(){

        return Book.builder()
                .title(title)
                .dateOfPublishing(dateOfPublishing)
                .author(author)
                .publisher(publisher)
                .build();
    }
}

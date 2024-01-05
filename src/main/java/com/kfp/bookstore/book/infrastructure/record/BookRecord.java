package com.kfp.bookstore.book.infrastructure.record;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.inventory.domain.Inventory;

import java.util.Date;
import java.util.List;

public record BookRecord (
        String title,
        String author,
        String publisher,
        Date dateOfPublishing,
        List<Integer> subjects,
        Inventory inventory){

    public Book toBook(){

        return Book.builder()
                .title(title)
                .dateOfPublishing(dateOfPublishing)
                .author(author)
                .publisher(publisher)
                .inventory(inventory)
                .build();
    }
}

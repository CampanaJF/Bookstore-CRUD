package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import com.kfp.bookstore.inventory.domain.Inventory;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static java.math.BigDecimal.valueOf;

@Service
@AllArgsConstructor
@Log4j2
public class AddBook {

    private final BookRepository bookRepository;

    public void execute(Book book) {

        Inventory blankInventory = Inventory.builder()
                .book(book)
                .stock(0)
                .price(valueOf(0)).build();

        book.setInventory(blankInventory);

        log.info("Saving new book..." );
        this.bookRepository.save(book);
    }

}

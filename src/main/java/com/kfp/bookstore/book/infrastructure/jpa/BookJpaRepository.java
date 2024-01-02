package com.kfp.bookstore.book.infrastructure.jpa;

import com.kfp.bookstore.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Integer> {

}

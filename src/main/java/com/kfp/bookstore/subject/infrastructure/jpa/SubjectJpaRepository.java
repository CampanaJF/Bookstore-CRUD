package com.kfp.bookstore.subject.infrastructure.jpa;

import com.kfp.bookstore.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectJpaRepository extends JpaRepository<Book, Integer> {

}

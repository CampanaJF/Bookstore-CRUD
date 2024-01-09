package com.kfp.bookstore.book.infrastructure.jpa;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookJpaRepository extends JpaRepository<Book, Integer> {

    @Query(
            nativeQuery = true,
            value = "select b.author, b.title from books b where b.id = :id ;"
    )
    BookView getAuthorAndTitleById(Integer id);
}

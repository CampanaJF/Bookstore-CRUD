package com.kfp.bookstore.book.domain;

import org.springframework.beans.factory.annotation.Value;

public interface BookView {
    @Value("#{target.author + ' ' + target.title}")
    String getAuthorAndTitle();
}

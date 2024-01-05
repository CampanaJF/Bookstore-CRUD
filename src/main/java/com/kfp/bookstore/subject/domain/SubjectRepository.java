package com.kfp.bookstore.subject.domain;

import java.util.List;

public interface SubjectRepository {

    List<Subject> findAll();
}

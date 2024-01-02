package com.kfp.bookstore.subject.infrastructure.jpa;

import com.kfp.bookstore.subject.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectJpaRepository extends JpaRepository<Subject, Integer> {

}

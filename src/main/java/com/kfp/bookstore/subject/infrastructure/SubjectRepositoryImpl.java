package com.kfp.bookstore.subject.infrastructure;

import com.kfp.bookstore.subject.domain.Subject;
import com.kfp.bookstore.subject.domain.SubjectRepository;
import com.kfp.bookstore.subject.infrastructure.jpa.SubjectJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SubjectRepositoryImpl implements SubjectRepository {

    private final SubjectJpaRepository subjectJpaRepository;
    @Override
    public List<Subject> findAll() {
        return subjectJpaRepository.findAll();
    }
}

package com.kfp.bookstore.book.application;

import com.kfp.bookstore.book.domain.Book;
import com.kfp.bookstore.book.domain.BookRepository;
import com.kfp.bookstore.subject.domain.Subject;
import com.kfp.bookstore.subject.domain.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddBook {

    private final BookRepository bookRepository;
    private final SubjectRepository subjectRepository;
    public void execute(Book book, List<Integer> subjectsId) {

        List<Subject> subjects = getSubjects(subjectsId);

        book.setSubjects(subjects);

        this.bookRepository.save(book);
    }

    private List<Subject> getSubjects(List<Integer> subjectsId){
        List<Subject> subjects = this.subjectRepository.findAll();

        return subjects.stream().filter(s -> subjectsId.contains(s.getId())).toList();

    }
}

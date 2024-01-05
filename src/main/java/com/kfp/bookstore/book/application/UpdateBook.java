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
public class UpdateBook {

    private final BookRepository bookRepository;
    private final SubjectRepository subjectRepository;
    public void execute(Integer bookId, Book book, List<Integer> subjectsId) {

        Book toUpdate = getBook(bookId);
        List<Subject> subjects = getSubjects(subjectsId);

        toUpdate.setTitle(book.getTitle());
        toUpdate.setAuthor(book.getAuthor());
        toUpdate.setDateOfPublishing(book.getDateOfPublishing());
        toUpdate.setPublisher(book.getPublisher());
        toUpdate.setSubjects(subjects);

        this.bookRepository.save(toUpdate);
    }

    private Book getBook(Integer bookId){
        return bookRepository.findById(bookId);
    }

    private List<Subject> getSubjects(List<Integer> subjectsId){
        List<Subject> subjects = this.subjectRepository.findAll();

        return subjects.stream().filter(s -> subjectsId.contains(s.getId())).toList();

    }
}

package com.kfp.bookstore.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kfp.bookstore.inventory.domain.Inventory;
import com.kfp.bookstore.subject.domain.Subject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private String publisher;

    @Column(name = "date_of_publishing")
    private Date dateOfPublishing;
    
    @JsonIgnore
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private Inventory inventory;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_subjects",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects = new HashSet<>();

    public void setSubjects(List<Subject> subjects){
        this.subjects = new HashSet<>(subjects);
    }

}

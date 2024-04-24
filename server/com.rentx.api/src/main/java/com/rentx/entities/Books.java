package com.rentx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="books")
public class Books {

    @Id
    @Column(name="booksID")
    private int booksID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="catid", referencedColumnName = "category_id")
    private Category categoryID;

    @Column(name="book_condition")
    private String condition;

    @Column(name="author")
    private String author;

    @Column(name="year_of_public")
    private String yearOfPublished;

    public Books(String author, String yearOfPublished) {
        this.author = author;
        this.yearOfPublished = yearOfPublished;
    }

    public Books(int booksID, String author, String yearOfPublished) {
       this.booksID = booksID;
        this.author = author;
        this.yearOfPublished = yearOfPublished;
    }
}

package com.library.library.Model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "bookSeq")
    @SequenceGenerator(name = "bookSeq", sequenceName = "book_seq", allocationSize = 1)
    private int id;
    private String author;
    private String title;
    private LocalDate dateOfReturn;

    @ManyToOne(targetEntity = User.class)
    private User user;


    public Book(int id,String author, String title, LocalDate dateOfReturn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.dateOfReturn = dateOfReturn;
        this.user = null;
    }

    public Book(){}

    @JsonGetter
    public int getId() {
        return id;
    }

    @JsonIgnore
    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter
    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    @JsonIgnore
    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(dateOfReturn, book.dateOfReturn) &&
                Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, dateOfReturn, user);
    }
}

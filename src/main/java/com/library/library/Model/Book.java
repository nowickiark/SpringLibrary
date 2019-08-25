package com.library.library.Model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    @JsonIgnore
    private int id;
    private String author;
    private String title;
    @JsonIgnore
    private LocalDate dateOfReturn;

    public Book(int id,String author, String title, LocalDate dateOfReturn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.dateOfReturn = dateOfReturn;
    }

    public Book(){}

    @JsonGetter
    public int getId() {
        return id;
    }

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

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(dateOfReturn, book.dateOfReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, dateOfReturn);
    }
}

package com.library.library.service;

import com.library.library.Model.Book;
import com.library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;


@Service
public class OrderService {

    private BookRepository bookRepository;
    static final int DAYS_TO_RETURN = 14;

    @Autowired
    public OrderService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Set<Book> getBooks(String bookName){
       return bookRepository.getBooks(bookName);
    }


    public Optional<Book> orderBook(int id) {

       LocalDate dateOfReturn = LocalDate.now().plusDays(DAYS_TO_RETURN);

        Optional<Book> book = bookRepository.orderBook(id, dateOfReturn);

       return book;
    }

    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public void deleteBook(int id){
        bookRepository.deleteBook(id);
    }


    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public void returnBook(int id) {

        bookRepository.returnBook(id);
    }
}

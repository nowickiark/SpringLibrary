package com.library.library.service;

import com.library.library.Model.Book;
import com.library.library.Model.User;
import com.library.library.exception.BookIsNotOrderedException;
import com.library.library.repository.BookRepository;
import com.library.library.repository.BookRepositoryOld;
import com.library.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class OrderService {

    private BookRepository bookRepository;
    private UserRepository userRepository;

    static final int DAYS_TO_RETURN = 14;

    @Autowired
    public OrderService(BookRepository bookRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    // ok
    public Set<Book> getBooks(String bookName){

        Set<Book> books;

        if (bookName == null){
           books = new HashSet<>(bookRepository.findAll());
        } else {
           books = bookRepository.findByTitle(bookName);
        }

       return books;
}

    public Optional<Book> orderBook(int bookId, long userId ) {

        LocalDate dateOfReturn = LocalDate.now().plusDays(DAYS_TO_RETURN);

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        Optional<User> userOptional = userRepository.findById(userId);

        if(bookOptional.isPresent() && bookOptional.get().getDateOfReturn() == null && userOptional.isPresent()){

            Book book = bookOptional.get();

            book.setDateOfReturn(dateOfReturn);

            book.setUser(userOptional.get());

            return Optional.of( bookRepository.save(book));
        }

        return Optional.empty();
    }

    // ok
    public void addBook(Book book){
        bookRepository.save(book);
    }

    // ok
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    // ok
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    // ok
    public void returnBook(int id) {

        Optional<Book> bookOptional = bookRepository.findById(id);

        if(bookOptional.get() == null){
            throw new BookIsNotOrderedException("You first have to order a book to return it");
        }

        bookOptional.get().setDateOfReturn(null);
        bookOptional.get().setUser(null);
    }
}

//kto wypożyczył książke
//customer id, imie i nazwisko
//do każdej wypożyczonej książki kto ją wypożyczył


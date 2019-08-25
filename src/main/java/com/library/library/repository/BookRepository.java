package com.library.library.repository;

import com.library.library.Model.Book;
import com.library.library.exception.BookDoesNotExistsException;
import com.library.library.exception.BookIsNotOrderedException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private Set<Book> bookSet;

    public BookRepository(){
        bookSet = new HashSet<>();
        bookSet.add(new Book(findHighestId(), "F. Scott Fitzgerald","The Great Gatsby", null));
        bookSet.add(new Book(findHighestId(),"Harper Lee","To Kill a Mockingbird", null));
        bookSet.add(new Book(findHighestId(),"George Orwell","1984", null));
        bookSet.add(new Book(findHighestId(),"J.D. Salinger","The Catcher in the Rye", null));
        bookSet.add(new Book(findHighestId(),"J.R.R. Tolkien","The Hobbit", null));
    }

    private int findHighestId(){

        int maxId = 1;

        if (!bookSet.isEmpty()){
            maxId = bookSet.stream().map(b -> b.getId()).max(Integer::compare).get()+1;
        }

        return maxId;

    }

    public Set<Book> getBooks(String bookName){

        if (bookName==null){
            return bookSet;
        }
            return bookSet.stream().filter(book->book.getTitle().contains(bookName)).collect(Collectors.toSet());
    }

    public Optional<Book> orderBook(int id, LocalDate dateOfReturn){

        Optional<Book> bookOptional = bookSet.stream().
                                    filter(b->b.getDateOfReturn()==null).
                                    filter(b -> b.getId() == id).
                                    findAny();

            if(bookOptional.isPresent()){
                bookOptional.get().setDateOfReturn(dateOfReturn);
            }



        return bookOptional;
    }


    private Book getBookById(int id) {

        Optional<Book> bookOptional = bookSet.stream().filter(book -> book.getId() == id).findAny();

        if(bookOptional.isPresent()){
            return bookOptional.get();
        } else {
            throw new BookDoesNotExistsException("Book with id " + id + " doesn't exists");
        }

    }

    public void addBook(Book book) {

        book.setId(findHighestId());
        bookSet.add(book);

    }

    public void deleteBook(int id) {

        Book book = getBookById(id);
        bookSet.remove(book);

    }

    public void updateBook(Book updatedBook) {

        Book oldBook = bookSet.stream().filter(b->b.getId()==updatedBook.getId()).findAny().get();

        bookSet.remove(oldBook);
        bookSet.add(updatedBook);

    }

    public void returnBook(int id) {

        if(getBookById(id).getDateOfReturn() == null){
            throw new BookIsNotOrderedException("You first have to order a book to return it");
        }
         getBookById(id).setDateOfReturn(null);

    }
}

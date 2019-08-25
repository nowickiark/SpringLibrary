package com.library.library.controller;

import com.library.library.Model.Book;
import com.library.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {

    private OrderService orderService;

    @Autowired
    public BookController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value ="/books", produces = "application/json")
    public Set<Book> getBooks(@RequestParam(required = false) String bookName){

        return orderService.getBooks(bookName);
    }

    @GetMapping(value ="/books/order/{id}", produces = "application/json")
    public ResponseEntity<Book> orderBook(@PathVariable int id){

        Optional<Book> book = orderService.orderBook(id);


        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "book/add",consumes = "application/json")
    public ResponseEntity<Integer> addBook(@RequestBody Book book){

        orderService.addBook(book);

        return new ResponseEntity<>(book.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/book/remove/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id){
        orderService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "book/update",consumes = "application/json")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        orderService.updateBook(book);

        return ResponseEntity.accepted().build();
    }


    @GetMapping("book/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable int id){

        orderService.returnBook(id);

        return new ResponseEntity("Book succesfully returned",HttpStatus.OK);
    }


}

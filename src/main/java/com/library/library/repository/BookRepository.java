package com.library.library.repository;

import com.library.library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Set<Book> findByTitle(String title);

}

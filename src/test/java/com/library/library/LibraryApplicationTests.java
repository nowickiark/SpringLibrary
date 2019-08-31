package com.library.library;

import com.library.library.Model.Book;
import com.library.library.repository.BookRepositoryOld;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

    @Autowired
    private BookRepositoryOld bookRepositoryOld;


    @Test
    public void shouldReturnTrueWhenOrderedBookHasCorrectReturnDate() {

        //given
        LocalDate dateOfReturn = LocalDate.now().plusDays(14);

        //when
        Optional<Book> actualBook = bookRepositoryOld.orderBook(2, dateOfReturn);

        //then
        Assert.assertEquals(dateOfReturn,actualBook.get().getDateOfReturn());
    }

    @Test
    public void shouldReturnFalseWhenIdIsNotAvailable(){

        //given
        LocalDate dateOfReturn = LocalDate.now().plusDays(14);
        int id = 15;

        //when
        Optional<Book> actualBook = bookRepositoryOld.orderBook(id, dateOfReturn);

        //then
        Assert.assertFalse(actualBook.isPresent());
    }

    @Test
    public void shouldReturnFalseWhenBookIsOrdered(){

        //given
        int id = 15;
        LocalDate dateOfReturn = null;

        //when
        Optional<Book> actualBook = bookRepositoryOld.orderBook(id, dateOfReturn);

        //then
        Assert.assertFalse(actualBook.isPresent());
    }




}

package edu.trincoll.library.dao;

import edu.trincoll.library.entities.Book;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    void autowiringWorked() {
        assertNotNull(repository);
    }

    @Test
    void thereShouldBeFiveBooks() {
        assertEquals(5, repository.count());
    }

    @Test
    void findAll() {
        List<Book> books = repository.findAll();
        assertEquals(5, books.size());
    }

    @Test
    void insertBook() {
        Book book = new Book("The Da Vinci Code", "Dan Brown", "978-0-385-50420-1", LocalDate.of(2003, 3, 18));
        repository.save(book);
        assertNotNull(book.getId());
    }
}
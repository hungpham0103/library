package edu.trincoll.library.config;

import edu.trincoll.library.dao.BookRepository;
import edu.trincoll.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppConfig implements CommandLineRunner {
    private final BookRepository repository;

    @Autowired
    public AppConfig(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(
                List.of(
                        new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-3-16-148410-0", LocalDate.of(1925, 4, 10)),
                        new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", LocalDate.of(1960, 7, 11)),
                        new Book("1984", "George Orwell", "978-0-452-28423-4", LocalDate.of(1949, 6, 8)),
                        new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0", LocalDate.of(1951, 7, 16)),
                        new Book("Pride and Prejudice", "Jane Austen", "978-0-19-953556-9", LocalDate.of(1813, 1, 28))
                )
        );
    }
}

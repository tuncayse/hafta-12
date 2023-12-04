package dev.patika.LibraryApp.repository;

import dev.patika.LibraryApp.entity.Author;
import dev.patika.LibraryApp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByNameAndAuthor(String name, Author author);

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.id = :categoryId")
    List<Book> findByCategoryId(Long categoryId);
}

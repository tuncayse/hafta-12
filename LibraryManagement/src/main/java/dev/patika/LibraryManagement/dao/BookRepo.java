package dev.patika.LibraryManagement.dao;

import dev.patika.LibraryManagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}

package dev.patika.LibraryManagement.dao;

import dev.patika.LibraryManagement.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepo extends JpaRepository<BookBorrowing, Integer> {
}

package dev.patika.LibraryApp.repository;

import dev.patika.LibraryApp.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookBorrowingRepository extends JpaRepository<BookBorrowing,Long> {
}

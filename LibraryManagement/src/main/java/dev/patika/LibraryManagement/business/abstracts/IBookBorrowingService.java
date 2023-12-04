package dev.patika.LibraryManagement.business.abstracts;

import dev.patika.LibraryManagement.entities.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing getById (int id);
    BookBorrowing save (BookBorrowing bookBorrowing);
    BookBorrowing update (BookBorrowing bookBorrowing);
    void delete (int id);
    List<BookBorrowing> findAll();
}

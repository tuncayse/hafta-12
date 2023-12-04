package dev.patika.LibraryManagement.business.abstracts;

import dev.patika.LibraryManagement.entities.Book;

import java.util.List;

public interface IBookService {
    Book getById (int id);
    Book save (Book book);
    Book update (Book book);
    void delete (int id);
    List<Book> findAll();
}

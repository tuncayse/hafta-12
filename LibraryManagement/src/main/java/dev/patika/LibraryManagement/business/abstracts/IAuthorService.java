package dev.patika.LibraryManagement.business.abstracts;

import dev.patika.LibraryManagement.entities.Author;

import java.util.List;

public interface IAuthorService {
    Author getById (int id);
    Author save (Author author);
    Author update (Author author);
    void delete (int id);
    List<Author> findAll();
}
